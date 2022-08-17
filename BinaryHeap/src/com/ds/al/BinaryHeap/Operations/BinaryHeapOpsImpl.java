package com.ds.al.BinaryHeap.Operations;

import com.ds.al.BinaryHeap.Entity.BinaryHeapEntity;

public class BinaryHeapOpsImpl implements BinaryHeapOps {

	BinaryHeapEntity heapEntity;

	@Override
	public void printNumbersLessRange(BinaryHeapEntity heapEntity, int range) {
		// TODO Auto-generated method stub
		this.heapEntity = heapEntity;
		printNumber(heapEntity.getHeapArr(), 0, range);
	}

	private void printNumber(int arr[], int index, int range) {
		if (index < 0)
			return;
		if (arr[index] < range)
			System.out.println(arr[index]);
		int rightIndex = heapEntity.getRightChild(index);
		printNumber(arr, rightIndex, range);
		int leftIndex = heapEntity.getLeftChild(index);
		printNumber(arr, leftIndex, range);
	}
}
