package com.ds.al.BinaryHeap.Operations;

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
		
		
		
		
	PriorityQueue<HeapTree> priorityIndex=new PriorityQueue<HeapTree>();
	
	
		return 0;
	}

	
}
