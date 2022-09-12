package com.ds.al.BinaryHeap.Operations;

import com.ds.al.BinaryHeap.Entity.BinaryHeapEntity;

public interface BinaryHeapOps {

	public void printNumbersLessRange(BinaryHeapEntity heapEntity, int key);

	public void printNumbersMoreRange(BinaryHeapEntity heapEntity, int key);

	public int findKthLargeNumber(BinaryHeapEntity heapEntity, int key);

	public int findKthLargeNumberOptimized(BinaryHeapEntity heapEntity, int key);

	public int[] findSlidingWindow(int arr[], int window);
}
