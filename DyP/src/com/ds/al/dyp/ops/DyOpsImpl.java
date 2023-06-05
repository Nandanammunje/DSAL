package com.ds.al.dyp.ops;

import static com.ds.al.dysp.util.DypUtil.getMaxInt;

public class DyOpsImpl implements DypOps {

	int memArr[][];

	private int getLcsArr(int i, int j, char[] a, char[] b) {
		if (i >= a.length || j >= b.length)
			return 0;

		if (memArr[i][j] != -1) {
			System.out.println("Memoized part");
			return memArr[i][j];
		}
		if (a[i] == b[j]) {

			return memArr[i][j] = getLcsArr(i + 1, j + 1, a, b) + 1;
		} else {
			int first = getLcsArr(i, j + 1, a, b);
			memArr[i][j + 1] = first;
			int second = getLcsArr(i + 1, j, a, b);
			memArr[i + 1][j] = second;
			memArr[i][j] = (first > second) ? first : second;
			return memArr[i][j];
		}

	}

	@Override
	public void setDPArr(int x, int y, int defaultValue) {
		memArr = new int[x+1][y+1];
		for (int i = 0; i < memArr.length; i++) {
			for (int j = 0; j < memArr[i].length; j++) {
				memArr[i][j] = defaultValue;
			}

		}
	}

	private void getLcsArrTab(char[] a, char[] b) {
		for (int i = 0; i < memArr.length; i++)
			memArr[i][0] = 0;
		for (int j = 0; j < memArr[0].length; j++)
			memArr[0][j] = 0;
		for (int i = 1; i < memArr.length; i++) {
			for (int j = 1; j < memArr[i].length; j++) {

				if (a[i - 1] == b[j - 1]) {
					memArr[i][j] = memArr[i - 1][j - 1] + 1;
				} else {

					memArr[i][j] = (memArr[i - 1][j] > memArr[i][j - 1]) ? memArr[i - 1][j] : memArr[i][j - 1];
				}
			}

		}

	}

	@Override
	public int getLcs(char[] a, char[] b) {
		// TODO Auto-generated method stub

		memArr = new int[a.length + 1][b.length + 1];
		getLcsArrTab(a, b);
		for (int i = 0; i < memArr.length; i++) {
			for (int j = 0; j < memArr[i].length; j++) {
				memArr[i][j] = -1;
			}
		}

		getLcsArrTab(a, b);

		int lcsArr = getLcsArr(0, 0, a, b);
		return lcsArr;
	}

	@Override
	public int knapSackBinary(int capacity, int[] weights, int[] profits, int index) {
		// TODO Auto-generated method stub

		if (index >= weights.length || capacity <= 0)
			return 0;
		else if (capacity < weights[index])
			return knapSackBinary(capacity, weights, profits, index + 1);
		if(memArr[capacity][index]!=-1)
			return memArr[capacity][index];

		else
		{
			int maxFirst=profits[index]+knapSackBinary(capacity- weights[index], weights, profits, index+1);
			int maxSecond=knapSackBinary(capacity, weights, profits, index+1);
			memArr[capacity][index]=(maxFirst > maxSecond)?maxFirst:maxSecond;
			return  memArr[capacity][index];
		}
	}

}
