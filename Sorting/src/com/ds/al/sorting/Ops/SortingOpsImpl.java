package com.ds.al.sorting.Ops;

public class SortingOpsImpl implements SortingOps {

	@Override
	public void sortingAlgorithm(int arr[]) {
		// TODO Auto-generated method stub
		int minIdx, temp;
		for (int i = 0; i < arr.length - 1; i++) {
			minIdx = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[minIdx] > arr[j])
					minIdx = j;

			temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;

		}

	}

}
