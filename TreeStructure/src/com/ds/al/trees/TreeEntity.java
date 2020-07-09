package com.ds.al.trees;

import static java.lang.Boolean.TRUE;

import com.ds.al.entity.constants.Constants;

import static java.lang.Boolean.FALSE;
import static java.lang.Math.random;

public class TreeEntity {

	private int data;
	private TreeEntity Left;
	private TreeEntity Right;
	private TreeEntity root;

	private int getData() {
		return data;
	}

	private void setData(int data) {
		this.data = data;
	}

	private TreeEntity getLeft() {
		return Left;
	}

	private void setLeft(TreeEntity left) {
		Left = left;
	}

	private TreeEntity getRight() {
		return Right;
	}

	private void setRight(TreeEntity right) {
		Right = right;
	}

	public TreeEntity getRoot() {
		return root;
	}

	private void setRoot(TreeEntity root) {
		this.root = root;
	}

	public void AddNode(int data, String type) {
		if (root == null) {
			root = new TreeEntity();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
		} else {

			if (type.equalsIgnoreCase(Constants.BST)) {
				CreateBST(data, root, root, TRUE);
			}
			else if(type.equalsIgnoreCase(Constants.BT))
			{
				CreateBT(data, root, root, TRUE);
			}

		}

	}

	private void CreateBST(int data, TreeEntity node, TreeEntity head, boolean isRight) {
		if (node != null) {
			if (node.getData() < data) {

				CreateBST(data, node.getRight(), node, TRUE);
			} else {
				CreateBST(data, node.getLeft(), node, FALSE);
			}

		} else {
			if (isRight) {
				node = new TreeEntity();
				node.setData(data);
				node.setLeft(null);
				node.setRight(null);
				head.setRoot(node);
			} else {

				node = new TreeEntity();
				node.setData(data);
				node.setLeft(null);
				node.setRight(null);
				head.setLeft(node);
			}
			return;
		}

	}

	private void CreateBT(int data, TreeEntity node, TreeEntity head, boolean isRight) {
		if (node != null) {
			if (random() * 10 > 4) {
				CreateBT(data, node.getRight(), node, TRUE);
			} else {
				CreateBT(data, node.getLeft(), node, FALSE);
			}

		} else {
            node = new TreeEntity();
			node.setData(data);
			node.setLeft(null);
			node.setRight(null);
			if (isRight)
				head.setRight(node);
			else
				head.setLeft(node);
		}

	}

}
