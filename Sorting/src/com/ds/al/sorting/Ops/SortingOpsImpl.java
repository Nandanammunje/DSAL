package com.ds.al.sorting.Ops;

import com.ds.al.sorting.entity.BinaryHeapEntity;

public class SortingOpsImpl implements SortingOps {

	public void doMerge(int arr[], int start, int mid, int end) {
		int leftTmpLen = mid - start + 1;
		int rightTmpLen = end - mid;
		int leftTmpArr[] = new int[leftTmpLen];
		int rightTmpArr[] = new int[rightTmpLen];
		for (int i = start; i <= mid; i++)
			leftTmpArr[i - start] = arr[i];
		for (int j = mid + 1; j <= end; j++)
			rightTmpArr[j - mid - 1] = arr[j];
		int i = 0, j = 0, k = start;
		while (i < leftTmpLen && j < rightTmpLen) {
			if (leftTmpArr[i] > rightTmpArr[j]) {
				arr[k] = rightTmpArr[j];

				j++;
			} else {
				arr[k] = leftTmpArr[i];
				i++;

			}
			k++;
		}
		while (i < leftTmpLen) {
			arr[k] = leftTmpArr[i];
			i++;
			k++;
		}
		while (j < rightTmpLen) {
			arr[k] = rightTmpArr[j];
			j++;
			k++;
		}

	}

	public void doMergeSort(int arr[], int start, int end) {
		if (start >= end)
			return;

		int mid = start + (end - start) / 2;
		doMergeSort(arr, start, mid);
		doMergeSort(arr, mid + 1, end);
		doMerge(arr, start, mid, end);

	}

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

	@Override
	public void mergeSort(int[] arr) {
		// TODO Auto-generated method stub
		doMergeSort(arr, 0, arr.length - 1);

	}

	@Override
	public void heapSort(int[] arr) {
		// TODO Auto-generated method stub
		BinaryHeapEntity heap = new BinaryHeapEntity(arr.length);
		heap.heapify(arr);
		arr = heap.doHeapSort();

	}

}
