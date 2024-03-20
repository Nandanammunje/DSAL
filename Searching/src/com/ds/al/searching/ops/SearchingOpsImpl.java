package com.ds.al.searching.ops;

public class SearchingOpsImpl implements SearchingOps {

	private boolean doBinarySearch(int arr[], int searchElement, int low, int high) {

		if (low > high || arr[arr.length-1] < searchElement||arr[0]>low)
			return false;
		int mid =low+ (low + high) / 2;
		if (arr[mid] == searchElement)
			return true;
		if (arr[mid] > searchElement)
			return doBinarySearch(arr, searchElement, low, mid-1);
		else
			return doBinarySearch(arr, searchElement, mid+1, high);

	}

	@Override
	public boolean findElementBinarySearch(int[] arr, int searchElement) {
		// TODO Auto-generated method stub
		boolean searchStatus = false;
		searchStatus = doBinarySearch(arr, searchElement, 0, arr.length);
		return searchStatus;
	}

}
