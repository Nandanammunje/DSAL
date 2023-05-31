package com.ds.al.dyp.ops;

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

}
