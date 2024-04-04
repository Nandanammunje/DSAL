package com.ds.al.searching.ops;

public interface SearchingOps {

	boolean findElementBinarySearch(int arr[], int searchElement);

	boolean findElementInterpolationSearch(int arr[], int searchElement);

	int findFirstRepeatingElement(int arr[], int searchElement);

	int[] findTwoElementSumK(int arr[], int sum);

	int[] findTwoElementSumSquareElement(int arr[]);

	int findTripletSum(int arr[]);

	int findPairSumCloseToZero(int arr[]);

	void findTripletSumK(int arr[], int sumK);

	void findTripletCloseToZero(int arr[]);

	int findElementinRotatedSortedArr(int arr[], int searchElement);

	int findBitonicIndex(int arr[]);

}
