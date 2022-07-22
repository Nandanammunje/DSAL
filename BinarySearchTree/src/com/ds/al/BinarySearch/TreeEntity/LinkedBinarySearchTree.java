package com.ds.al.BinarySearch.TreeEntity;

public class LinkedBinarySearchTree {

	private String data ;
	
	private LinkedBinarySearchTree left;
	
	private LinkedBinarySearchTree right;
	
	private LinkedBinarySearchTree next;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LinkedBinarySearchTree getLeft() {
		return left;
	}

	public void setLeft(LinkedBinarySearchTree left) {
		this.left = left;
	}

	public LinkedBinarySearchTree getRight() {
		return right;
	}

	public void setRight(LinkedBinarySearchTree right) {
		this.right = right;
	}

	public LinkedBinarySearchTree getNext() {
		return next;
	}

	public void setNext(LinkedBinarySearchTree next) {
		this.next = next;
	}
	
	
}
