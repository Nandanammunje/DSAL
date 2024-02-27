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
		int j, key;
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

	@Override
	public void shellSort(int[] arr) {
		// TODO Auto-generated method stub
		int j, key;
		for (int gap = arr.length / 2; gap >= 1; gap = gap / 2) {
			for (int i = gap; i < arr.length; i++) {
				j = i - gap;
				key = arr[i];
				while (j >= 0 && key < arr[j - gap]) {
					arr[j + gap] = arr[j];
					j = j - gap;
				}
				arr[j + gap] = key;

			}

		}

	}

}
