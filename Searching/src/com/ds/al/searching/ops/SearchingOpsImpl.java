package com.ds.al.searching.ops;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

	private int doModifiedBinarySearch(int arr[], int searchElement, int low, int high) {
		int mid = low + (high - low) / 2;

		if (low <= high) {
			if (arr[mid] == searchElement)
				return mid;
			if (arr[low] < arr[mid]) {
				if (arr[low] < searchElement && searchElement < arr[mid]) {
					return doModifiedBinarySearch(arr, searchElement, low, mid - 1);
				} else
					return doModifiedBinarySearch(arr, searchElement, mid + 1, high);
			} else {
				if (searchElement > arr[mid] && searchElement < arr[high])
					return doModifiedBinarySearch(arr, searchElement, mid + 1, high);
				else
					return doModifiedBinarySearch(arr, searchElement, low, mid - 1);

			}

		}
		return -1;
	}

	private int findFirstOccurence(int arr[], int searchElement, int start, int end) {

		if (start <= end && arr[0] <= searchElement && arr[arr.length - 1] >= searchElement) {
			int midElementIndx = start + (end - start) / 2;

			if (midElementIndx == 0 || arr[midElementIndx] == searchElement && arr[midElementIndx - 1] != searchElement)
				return midElementIndx;

			if (arr[midElementIndx] < searchElement)
				return findFirstOccurence(arr, searchElement, (midElementIndx + 1), end);
			else
				return findFirstOccurence(arr, searchElement, start, (midElementIndx - 1));

		}
		return -1;

	}

	private int findLastOccurence(int arr[], int searchNum, int start, int end) {
		if (start <= end) {
			int midIndx = start + (end - start) / 2;

			if (midIndx == arr.length - 1 || arr[midIndx] == searchNum && arr[midIndx + 1] != searchNum) {
				return midIndx;
			}
			if (arr[midIndx] <= searchNum)
				return findLastOccurence(arr, searchNum, midIndx + 1, end);
			else
				return findLastOccurence(arr, searchNum, start, midIndx - 1);
		}
		return -1;
	}

	private int findIndexBitonicBinSearch(int arr[], int low, int high) {
		int midIndx = low + (high - low) / 2;
		if (low <= high) {
			if ((midIndx == 0 || midIndx == arr.length - 1)
					|| arr[midIndx - 1] < arr[midIndx] && arr[midIndx + 1] < arr[midIndx]) {
				return midIndx;
			} else if (midIndx == 0 || arr[midIndx - 1] < arr[midIndx]) {
				return findIndexBitonicBinSearch(arr, midIndx + 1, high);
			}

			return findIndexBitonicBinSearch(arr, low, midIndx - 1);
		}
		return midIndx;
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

	@Override
	public void findTripletSumK(int[] arr, int sumK) {

		Arrays.sort(arr);
		int searchNum;
		for (int i = arr.length - 1; i >= 2; i--) {

			for (int j = 0; j <= i - 1; j++) {
				searchNum = sumK - arr[i] - arr[j];
				if (searchNum > 0) {
					if (doBinarySearch(arr, sumK, j, i)) {
						System.out.println("triplet is " + arr[i] + " " + arr[j] + " " + searchNum);
					}

				} else if (searchNum < 0) {
					continue;
				}

			}

		}
	}

	private void findTripletSumKNoBin(int arr[], int sumK) {
		Arrays.sort(arr);
		int l, r;
		for (int i = 0; i < arr.length - 2; i++) {
			l = i + 1;
			r = arr.length - 1;
			while (l < r) {
				if (arr[i] + arr[l] + arr[r] == sumK)
					System.out.println(" triplet is " + arr[i] + " " + arr[l] + " " + arr[r]);
				else if (arr[i] + arr[l] + arr[r] < sumK)
					l++;
				else
					r--;
			}

		}

	}

	@Override
	public void findTripletCloseToZero(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int l, r, modSum = Integer.MAX_VALUE, sum;
		int triplet[] = new int[3];
		for (int i = 0; i < arr.length - 2; i++) {
			l = i + 1;
			r = arr.length - 1;
			while (l < r) {
				sum = arr[l] + arr[r] + arr[i];

				if (Math.abs(sum) < modSum || (Math.abs(sum) == modSum) && sum < triplet[0] + triplet[1] + triplet[2]) {
					triplet[0] = arr[i];
					triplet[1] = arr[l];
					triplet[2] = arr[r];
				}

			}
			if (arr[i] > 0) {
				break;
			}
		}

	}

	@Override
	public int findElementinRotatedSortedArr(int[] arr, int searchElement) {
		// TODO Auto-generated method stub
		doModifiedBinarySearch(arr, searchElement, 0, arr.length - 1);
		return 0;
	}

	@Override
	public int findBitonicIndex(int[] arr) {
		// TODO Auto-generated method stub

		return findIndexBitonicBinSearch(arr, 0, arr.length - 1);
	}

	@Override
	public int findFirstOccurence(int[] arr, int findElement) {
		// TODO Auto-generated method stub
		return findFirstOccurence(arr, findElement, 0, arr.length - 1);
	}

	@Override
	public int findLastOccurence(int[] arr, int findElement) {
		// TODO Auto-generated method stub

		return findLastOccurence(arr, findElement, 0, arr.length - 1);
	}

}
