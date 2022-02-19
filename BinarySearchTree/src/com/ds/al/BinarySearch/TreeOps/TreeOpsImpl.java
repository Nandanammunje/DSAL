package com.ds.al.BinarySearch.TreeOps;

import com.ds.al.BinarySearch.TreeEntity.BinarySearchTreeEntity;

public class TreeOpsImpl implements TreeOps {

	private BinarySearchTreeEntity root;
	private BinarySearchTreeEntity foundNode;

	public void createBinarySearchTree(String data) {

		if (root == null) {
			root = new BinarySearchTreeEntity();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
			return;
		}

		else {
			mkBinaryTree(root, root, data, true);
		}

	}

	private void mkBinaryTree(BinarySearchTreeEntity parent, BinarySearchTreeEntity node, String data, boolean isLeft) {

		if (node != null) {

			if (compareCharacter(node.getData().charAt(0), data.charAt(0))) {
				mkBinaryTree(node, node.getLeft(), data, true);
			} else {
				mkBinaryTree(node, node.getRight(), data, false);
			}
		} else {
			node = new BinarySearchTreeEntity();
			node.setData(data);
			node.setLeft(null);
			node.setRight(null);
			if (isLeft)
				parent.setLeft(node);
			else
				parent.setRight(node);

		}

	}

	private boolean compareCharacter(char a, char b) {
		int charFirst = (int) a;

		int charSecond = (int) b;

		return charFirst > charSecond;
	}

	@Override
	public BinarySearchTreeEntity createBST(String dataStr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dataStr.length(); i++) {
			createBinarySearchTree(Character.toString(dataStr.charAt(i)));
		}
		return root;
	}

	public void searchBSTNode(BinarySearchTreeEntity node, String data) {

		if (node == null)
			return;
		if (node.getData().equalsIgnoreCase(data)) {
			foundNode = node;
			return;
		} else {
			if (compareCharacter(node.getData().charAt(0), data.charAt(0)))
				searchBSTNode(node.getLeft(), data);
			else
				searchBSTNode(node.getRight(), data);

		}

	}

	@Override
	public BinarySearchTreeEntity findNode(String dataStr) {
		// TODO Auto-generated method stub
		searchBSTNode(root, dataStr);
		return foundNode;
	}

}
