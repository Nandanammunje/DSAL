package com.ds.al.BinaryHeap.Entity;

public class HeapTree implements Comparable<HeapTree> {

	private int parent;
	private int leftChild;
	private int rightChild;

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(int leftChild) {
		this.leftChild = leftChild;
	}

	public int getRightChild() {
		return rightChild;
	}

	public void setRightChild(int rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public int compareTo(HeapTree o) {
		// TODO Auto-generated method stub

		return this.parent - o.parent;
	}

}
