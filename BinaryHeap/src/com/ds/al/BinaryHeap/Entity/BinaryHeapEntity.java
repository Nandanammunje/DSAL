package com.ds.al.BinaryHeap.Entity;

public class BinaryHeapEntity {

	private int heapArr[];

	private int capacity;

	private int heapSize;

	public int[] getHeapArr() {
		return heapArr;
	}

	public BinaryHeapEntity(int capacity) {

		heapArr = new int[capacity];
		this.capacity = capacity;
		heapSize = 0;
	}

	public void insertIntoHeap(int data) {
		resizeHeap();
		heapArr[capacity - 1] = data;
		balanceHeap(capacity - 1);
	}

	private void balanceHeap(int pos) {
		int parent = getParent(pos);
		int maxTreeIndex = getMaxIndex(parent);
		if (maxTreeIndex != parent) {
			int temp = heapArr[parent];
			heapArr[parent] = heapArr[maxTreeIndex];
			heapArr[maxTreeIndex] = temp;
			balanceHeap(parent);
		} else
			return;

	}

	private void resizeHeap() {
		capacity++;
		int temp[] = new int[capacity];
		System.arraycopy(heapArr, 0, temp, 0, capacity - 1);
		heapArr = temp;

	}

	private void prelocateDown(int pos) {

		int maxTreeIndex = getMaxIndex(pos);
		if (maxTreeIndex != pos) {
			int temp = heapArr[pos];
			heapArr[pos] = heapArr[maxTreeIndex];
			heapArr[maxTreeIndex] = temp;
			prelocateDown(maxTreeIndex);

		} else
			return;

	}

	private int getMaxIndex(int pos) {
		int maxIndex = pos;

		int leftChild = getLeftChild(pos);
		int rightChild = getRightChild(pos);
		if (leftChild > 0 && heapArr[leftChild] > heapArr[maxIndex])
			maxIndex = leftChild;
		if (rightChild > 0 && heapArr[rightChild] > heapArr[maxIndex])
			maxIndex = rightChild;
		return maxIndex;
	}

	private int getLeftChild(int i) {

		int leftIndex = (2 * i) + 1;
		if (leftIndex < capacity)
			return leftIndex;
		else
			return -1;
	}

	private int getRightChild(int i) {
		int rightIndex = (2 * i) + 2;
		if (rightIndex < capacity)
			return rightIndex;

		else
			return -1;

	}

	private int getParent(int i) {
		int parentIndex = (i - 1) / 2;

		if (parentIndex >= 0)
			return parentIndex;
		else
			return -1;

	}

	public void heapify(int a[]) {
		for (int i = 0; i < a.length; i++)
			heapArr[i] = a[i];

		for (int i = (capacity - 1) / 2; i >= 0; i--)
			prelocateDown(i);

	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

}