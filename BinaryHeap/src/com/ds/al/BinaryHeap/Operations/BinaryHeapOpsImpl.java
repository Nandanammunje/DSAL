package com.ds.al.BinaryHeap.Operations;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

import com.ds.al.BinaryHeap.Entity.BinaryHeapEntity;
import com.ds.al.BinaryHeap.Entity.HeapTree;

public class BinaryHeapOpsImpl implements BinaryHeapOps {

	BinaryHeapEntity heapEntity;

	@Override
	public void printNumbersLessRange(BinaryHeapEntity heapEntity, int range) {
		// TODO Auto-generated method stub
		this.heapEntity = heapEntity;
		printNumberMin(heapEntity.getHeapArr(), 0, range);
	}

	@Override
	public void printNumbersMoreRange(BinaryHeapEntity heapEntity, int key) {
		// TODO Auto-generated method stub
		this.heapEntity = heapEntity;
		printNumberMax(heapEntity.getHeapArr(), 0, key);

	}

	private void printNumberMax(int arr[], int index, int key) {
		if (index < 0)
			return;
		if (arr[index] > key)
			System.out.println(arr[index]);
		else
			return;
		int rightIndex = heapEntity.getRightChild(index);
		printNumberMax(arr, rightIndex, key);
		int leftIndex = heapEntity.getLeftChild(index);
		printNumberMax(arr, leftIndex, key);

	}

	private void printNumberMin(int arr[], int index, int range) {
		if (index < 0)
			return;
		if (arr[index] < range)
			System.out.println(arr[index]);
		int rightIndex = heapEntity.getRightChild(index);
		printNumberMin(arr, rightIndex, range);
		int leftIndex = heapEntity.getLeftChild(index);
		printNumberMin(arr, leftIndex, range);
	}

	@Override
	public int findKthLargeNumber(BinaryHeapEntity heapEntity, int key) {
		// TODO Auto-generated method stub
		int Kmax = 0;
		for (int i = 1; i <= key; i++)
			Kmax = heapEntity.deleteMax();
		return Kmax;
	}

	@Override
	public int findKthLargeNumberOptimized(BinaryHeapEntity heapEntity, int key) {
		PriorityQueue<HeapTree> priorityIndex = new PriorityQueue<HeapTree>();
		int leftIndex, rightIndex;
		int Kmax[] = new int[1];
		Kmax[0] = heapEntity.getHeapArr()[0];
		HeapTree heap = new HeapTree(Kmax[0], 0);
		priorityIndex.add(heap);
		for (int i = 0; i < key; i++) {
			HeapTree heapElement = priorityIndex.poll();
			if (heapElement != null) {
				Kmax[0] = heapElement.getParent();
				leftIndex = (heapElement.getLeftChild() < heapEntity.getCapacity()) ? heapElement.getLeftChild() : -1;
				rightIndex = (heapElement.getRightChild() < heapEntity.getCapacity()) ? heapElement.getRightChild()
						: -1;
				if (leftIndex != -1) {
					HeapTree leftHeap = new HeapTree(heapEntity.getHeapArr()[leftIndex], leftIndex);
					priorityIndex.add(leftHeap);
				}
				if (rightIndex != -1) {
					HeapTree rightHeap = new HeapTree(heapEntity.getHeapArr()[rightIndex], rightIndex);
					priorityIndex.add(rightHeap);
				}
			}

		}

		return Kmax[0];
	}

	@Override
	public int[] findSlidingWindow(int[] arr, int window) {
		// TODO Auto-generated method stub
		int slidingWindowMax[] = new int[arr.length - window + 1];
		Deque<Integer> maxIndex = new LinkedList<Integer>();
		for (int i = 0; i < window; i++) {
			while (!maxIndex.isEmpty() && arr[maxIndex.getLast()] < arr[i])
				maxIndex.pollLast();
			maxIndex.addLast(i);;
		}
		for (int i = window; i < arr.length; i++) {
			slidingWindowMax[i - window] = arr[maxIndex.getFirst()];
			while (!maxIndex.isEmpty() && maxIndex.getFirst() <= i - window)
				maxIndex.pollFirst();
			while (!maxIndex.isEmpty() && arr[maxIndex.getLast()] < arr[i])
				maxIndex.pollLast(); 
			maxIndex.addLast(i);
		}
		slidingWindowMax[arr.length - window] = arr[maxIndex.getFirst()];
		return slidingWindowMax;
	}

}
