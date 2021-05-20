package com.ds.al.tree;

public class TreeEntity {

	private TreeEntity Root;
	private char Data;
	private TreeEntity Left;
	private TreeEntity Right;

	public TreeEntity GetRootNode() {
		return Root;
	}

	public char getData() {
		return Data;
	}

	public void setData(char data) {
		Data = data;
	}

	public TreeEntity getLeft() {
		return Left;
	}

	public void setLeft(TreeEntity left) {
		Left = left;
	}

	public TreeEntity getRight() {
		return Right;
	}

	public void setRight(TreeEntity right) {
		Right = right;
	}

}
