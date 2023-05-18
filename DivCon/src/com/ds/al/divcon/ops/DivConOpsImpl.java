package com.ds.al.divcon.ops;

import static com.ds.al.divcon.util.DivConUtil.getMedian;

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
	public int getMedianOfSortedArrEffMerg(int[] sortedArr1, int[] sortedArr2) {
		// TODO Auto-generated method stub
		int mrgArrlen = sortedArr1.length + sortedArr2.length;
		int mergedArr[] = new int[mrgArrlen];
		int i = 0, j = 0, k = 0;
		while (i < sortedArr1.length && j < sortedArr2.length && k <= (mrgArrlen + 1) / 2) {
			if (sortedArr1[i] > sortedArr2[j]) {
				mergedArr[k] = sortedArr2[j];
				j++;
			} else {
				mergedArr[k] = sortedArr1[i];
				i++;
			}
			k++;
		}
		while (i < sortedArr1.length && k <= (mrgArrlen + 1) / 2) {
			mergedArr[k] = sortedArr1[i];
			i++;
			k++;

		}
		while (j < sortedArr2.length && k <= (mrgArrlen + 1) / 2) {
			mergedArr[k] = sortedArr2[j];
			j++;
			k++;
		}
		int median = ((mrgArrlen % 2) == 0) ? ((mergedArr[(mrgArrlen / 2)] + (mergedArr[((mrgArrlen) / 2) - 1])) / 2)
				: mergedArr[(mrgArrlen - 1) / 2];
		return median;
	}

	private int getMedianSmeLen(int arr1[], int arr2[], int startF, int endF, int startSec, int endSec) {

		if (endF - startF == 1 && endSec - startSec == 1) {
			int maxStart = Math.max(arr1[startF], arr2[startSec]);
			int minEnd = Math.min(arr1[endF], arr2[endSec]);
			return (maxStart + minEnd) / 2;
		}
		int medianFirst = getMedian(startF, endF, arr1);
		int medianSec = getMedian(startSec, endSec, arr2);
		if (medianFirst == medianSec)
			return medianFirst;
		if (medianFirst > medianSec)
			return getMedianSmeLen(arr1, arr2, startF, (startF + endF + 1) / 2, (startSec + endSec + 1) / 2, endSec);
		else
			return getMedianSmeLen(arr1, arr2, (startF + endF + 1) / 2, endF, startSec, (startSec + endSec + 1) / 2);

	}

	private double getMedianDiffLen(int arr1[], int arr2[]) {
		if (arr1.length > arr2.length)
			getMedianDiffLen(arr2, arr1);
		int low = 0, high = arr1.length;
		int medianMerged = (arr1.length + arr2.length + 1) >> 1;
		while (low <= high) {
			int lowMid = (low + high) >> 1;
			int highMid = medianMerged - lowMid;
			int l1 = (lowMid == 0) ? Integer.MIN_VALUE : arr1[lowMid - 1];
			int l2 = (highMid == 0) ? Integer.MIN_VALUE : arr2[highMid - 1];
			int lowMidVal = (lowMid == arr1.length) ? Integer.MAX_VALUE : arr1[lowMid];
			int highMidVal = (highMid == arr2.length) ? Integer.MAX_VALUE : arr2[highMid];
			if (l1 <= highMidVal && l2 <= lowMidVal) {
				if ((arr1.length + arr2.length) % 2 == 0) {
					return (Math.max(l2, l1) + Math.min(lowMidVal, highMidVal)) / 2;

				} else {
					return Math.max(l1, l2);
				}
			}
			if (l1 > highMidVal) {
				high = lowMid - 1;
			} else {
				low = lowMid + 1;
			}

		}

		return medianMerged;
	}

	@Override
	public int getMedianOfSortedArrEqualLen(int[] sortedArr1, int[] sortedArr2) {
		// TODO Auto-generated method stub
		int medianSmeLen = getMedianSmeLen(sortedArr1, sortedArr2, 0, sortedArr1.length - 1, 0, sortedArr2.length - 1);

		return medianSmeLen;
	}

	@Override
	public int getMedianOfSortedArrUnequalLen(int[] sortedArr1, int[] sortedArr2) {
		// TODO Auto-generated method stub
		getMedianDiffLen(sortedArr1, sortedArr2);
		return 0;
	}

}
