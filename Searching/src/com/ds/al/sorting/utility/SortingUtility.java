package com.ds.al.sorting.utility;

public class SortingUtility {

	public static void swapArr(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static int getMax(int arr[]) {
		int max = arr[0];
		for (int i : arr) {
			max = (i < max) ? max : i;
		}
		return max;
	}

}
