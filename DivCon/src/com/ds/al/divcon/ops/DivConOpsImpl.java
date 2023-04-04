package com.ds.al.divcon.ops;

public class DivConOpsImpl implements DivConOps {

	void mergeArr(int arr[], int start, int mid, int end) {
		int subEndL = mid + 1 - start;
		int subEndR = end - mid;
		int lftArr[] = new int[subEndL];
		int rghtArr[] = new int[subEndR];
		for (int i = 0; i < subEndL; i++)
			lftArr[i] = arr[start + i];
		for (int j = 0; j < subEndR; j++)
			rghtArr[j] = arr[mid + 1 + j];
		int i = 0, j = 0, k = start;
		while (i < subEndL && j < subEndR) {
			if (lftArr[i] < rghtArr[j]) {
				arr[k] = lftArr[i];
				i++;
			} else {
				arr[k] = rghtArr[j];
				j++;
			}
			k++;
		}
		while (i < subEndL) {
			arr[k] = lftArr[i];
			i++;
			k++;
		}
		while (j < subEndR) {
			arr[k] = rghtArr[j];
			j++;
			k++;
		}

	}

	void sort(int arr[], int start, int end) {
		if (start < end) {
			int median = start + (end - start) / 2;

			sort(arr, start, median);
			sort(arr, median + 1, end);
			mergeArr(arr, start, median, end);
		}

	}

	@Override
	public void mergeSort(int[] arr) {
		// TODO Auto-generated method stub
		sort(arr, 0, arr.length - 1);
	}

	@Override
	public int getMedianOfSortedArr(int[] sortedArr1, int[] sortedArr2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
