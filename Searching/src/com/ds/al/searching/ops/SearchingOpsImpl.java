package com.ds.al.searching.ops;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import com.ds.al.sorting.Ops.SortingOps;
import com.ds.al.sorting.Ops.SortingOpsImpl;

public class SearchingOpsImpl implements SearchingOps {

	private boolean doBinarySearch(int arr[], int searchElement, int low, int high) {

		if (low > high || arr[arr.length - 1] < searchElement || arr[0] > searchElement)
			return false;
		int mid = low + (high - low) / 2;
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

	@Override
	public int[] findTwoElementSumK(int[] arr, int sum) {
		// TODO Auto-generated method stub
		HashSet<Integer> findMap = new HashSet<Integer>();
		int sumNumbers[] = new int[2];

		for (int i = 0; i < arr.length; i++) {
			if (findMap.contains(sum - arr[i])) {
				sumNumbers[0] = arr[i];
				sumNumbers[1] = arr[sum - arr[i]];
			} else {
				findMap.add(arr[i]);
			}
		}

		return sumNumbers;
	}

	@Override
	public int[] findTwoElementSumSquareElement(int[] arr) {
		// TODO Auto-generated method stub
		int squareTriplet[] = new int[3];
		for (int i = 0; i < arr.length; i++)
			arr[i] = arr[i] * arr[i];
		SortingOps ops = new SortingOpsImpl();
		ops.quickSort(arr);
		int j, k;
		for (int i = arr.length - 1; i >= 0; i--) {
			j = 0;
			k = i - 1;
			while (j < k) {

				if (arr[j] + arr[k] == arr[i]) {
					squareTriplet[0] = arr[j];
					squareTriplet[1] = arr[k];
					squareTriplet[2] = arr[i];
				}

				else if (arr[j] + arr[k] > arr[i]) {
					k--;
				} else {
					j++;
				}

			}

		}

		return squareTriplet;
	}

	@Override
	public int findTripletSum(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int counter = 0;
		for (int i = arr.length - 1; i >= 2; i--) {

			for (int j = 0; j <= i - 1; j++) {
				if (doBinarySearch(arr, arr[i] - arr[j], j + 1, i - 1)) {
					counter++;
				}

			}

		}

		return counter;
	}

	@Override
	public int findPairSumCloseToZero(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int low = 0, high = arr.length - 1, sum, modSum = Integer.MAX_VALUE, closeSum = Integer.MAX_VALUE;
		int pairNum[] = new int[2];
		while (low < high) {

			sum = arr[low] + arr[high];
			if (Math.abs(sum) < modSum || (Math.abs(sum) == modSum) && sum < (pairNum[0] + pairNum[1])) {
				modSum = Math.abs(sum);
				pairNum[0] = arr[low];
				pairNum[1] = arr[high];
			}
			if (sum > 0)
				high--;
			else if (sum < 0)
				low++;
			else {
				break;
			}

		}

		return pairNum[0] + pairNum[1];
	}

}
