package com.ds.al.sorting.Ops;

public class SortingOpsImpl implements SortingOps {

	@Override
	public void selectionSort(int arr[]) {
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

	@Override
	public void insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		int j, key, temp;
		for (int i = 1; i < arr.length; i++) {
			j = i - 1;
			key = arr[i];
			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;

			}
			arr[j + 1] = key;

		}

	}

}
