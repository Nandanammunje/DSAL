package com.ds.al.searching.ops;

import java.util.HashMap;

public class SearchingOpsImpl implements SearchingOps {

	private boolean doBinarySearch(int arr[], int searchElement, int low, int high) {

		if (low > high || arr[arr.length - 1] < searchElement || arr[0] > low)
			return false;
		int mid = low + (low + high) / 2;
		if (arr[mid] == searchElement)
			return true;
		if (arr[mid] > searchElement)
			return doBinarySearch(arr, searchElement, low, mid - 1);
		else
			return doBinarySearch(arr, searchElement, mid + 1, high);

	}

	private boolean doInterpolationSearch(int arr[], int searchElement, int low, int high) {

		if (low > high || arr[0] > searchElement || arr[arr.length - 1] < searchElement)
			return false;
		int slope = (arr[high] - arr[low]) / high - low;
		int interpolatedIndex = low + ((searchElement - arr[low]) / slope);
		if (arr[interpolatedIndex] == searchElement)
			return true;
		if (arr[interpolatedIndex] > searchElement)
			return doInterpolationSearch(arr, searchElement, low, interpolatedIndex - 1);
		else
			return doInterpolationSearch(arr, searchElement, high, interpolatedIndex + 1);

	}

	@Override
	public boolean findElementBinarySearch(int[] arr, int searchElement) {
		// TODO Auto-generated method stub
		boolean searchStatus = false;
		searchStatus = doBinarySearch(arr, searchElement, 0, arr.length - 1);
		return searchStatus;
	}

	@Override
	public boolean findElementInterpolationSearch(int[] arr, int searchElement) {
		// TODO Auto-generated method stub
		boolean searchStatus = false;
		searchStatus = doInterpolationSearch(arr, searchElement, 0, arr.length - 1);
		return searchStatus;
	}

	@Override
	public int findFirstRepeatingElement(int[] arr, int searchElement) {
		// TODO Auto-generated method stub
		int minIndex = arr.length;
		HashMap<Integer, Integer> repeatMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (repeatMap.containsKey(arr[i])) {
				int key = repeatMap.get(arr[i]);
				minIndex = (minIndex > key) ? key : minIndex;
			} else {

				repeatMap.put(arr[i], i);
			}

		}
		if (minIndex == arr.length)
			minIndex = -2;
		return minIndex + 1;
	}

}
