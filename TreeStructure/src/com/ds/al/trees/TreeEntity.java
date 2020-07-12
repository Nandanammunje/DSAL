package com.ds.al.trees;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class TreeEntity {

	private int Data;
	private TreeEntity Root;
	private TreeEntity Left;
	private TreeEntity Right;
	private static TreeCreateHelper GetRankMap;

	public int getData() {
		return Data;
	}

	private void setData(int data) {
		Data = data;
	}

	private void SetRank() {

		if (GetRankMap == null) {
			GetRankMap = new TreeCreateHelper();

		}
	}

	public TreeEntity getRoot() {
		return Root;
	}

	public TreeEntity getLeft() {
		return Left;
	}

	private void setLeft(TreeEntity left) {
		Left = left;
	}

	public TreeEntity getRight() {
		return Right;
	}

	private void setRight(TreeEntity right) {
		Right = right;
	}

	public void AddNode(int data) {

		if (Root == null) {
			Root = new TreeEntity();
			Root.setData(data);
			Root.setLeft(null);
			Root.setRight(null);
			SetRank();

		} else {

			CreateBT(data, Root, Root, TRUE);

		}
	}

	public void CreateBT(int data, TreeEntity head, TreeEntity node, boolean isRight) {

		if (node != null) {
			if (GetRankMap.GetRank(node.getData()) > GetRankMap.GetRank(data)) {
				CreateBT(data, node, node.getLeft(), FALSE);
			} else {
				CreateBT(data, node, node.getRight(), TRUE);
			}

		} else {
			node = new TreeEntity();
			node.setData(data);
			node.setLeft(null);
			node.setRight(null);

			if (isRight) {
				head.setRight(node);
			} else {
				head.setLeft(node);
			}

			return;
		}

	}
}
