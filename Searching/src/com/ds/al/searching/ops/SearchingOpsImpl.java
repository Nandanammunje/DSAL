package com.ds.al.searching.ops;

public class SearchingOpsImpl implements SearchingOps {

	private boolean doBinarySearch(int arr[], int searchElement, int low, int high) {

		if (low > high)
			return false;
		int mid = (low + high) / 2;
		if (arr[mid] == searchElement)
			return true;
		if (arr[mid] > searchElement)
			return doBinarySearch(arr, searchElement, low, mid);
		else
			return doBinarySearch(arr, searchElement, mid, high);

	}

	@Override
	public boolean findElementBinarySearch(int[] arr, int searchElement) {
		// TODO Auto-generated method stub
		boolean searchStatus = false;
		searchStatus = doBinarySearch(arr, searchElement, 0, arr.length - 1);
		return searchStatus;
	}

}
