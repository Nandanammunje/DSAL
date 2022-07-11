package com.ds.al.avl.TreeEntity;

public class AvlTreeEntity {

	private int data;

	private AvlTreeEntity left;

	private AvlTreeEntity right;

	private int height;

	public AvlTreeEntity() {
		height = 1;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public AvlTreeEntity getLeft() {
		return left;
	}

	public void setLeft(AvlTreeEntity left) {
		this.left = left;
	}

	public AvlTreeEntity getRight() {
		return right;
	}

	public void setRight(AvlTreeEntity right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
