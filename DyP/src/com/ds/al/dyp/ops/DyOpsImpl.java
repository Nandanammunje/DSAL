package com.ds.al.dyp.ops;

public class DyOpsImpl implements DypOps {

	int memArr[][];

	private int getLcsArr(int i, int j, char[] a, char[] b) {
		if (i >= a.length || j >= b.length)
			return 0;

		if (memArr[i][j] != -1)
		{
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
	public int getLcs(char[] a, char[] b) {
		// TODO Auto-generated method stub

		memArr = new int[a.length + 1][b.length + 1];
		for (int i = 0; i <memArr.length; i++) {
			for (int j = 0; j < memArr[i].length; j++) {
				memArr[i][j] = -1;
			}
		}

		int lcsArr = getLcsArr(0, 0, a, b);
		return lcsArr;
	}

}
