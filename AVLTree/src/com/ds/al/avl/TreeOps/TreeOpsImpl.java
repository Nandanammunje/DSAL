package com.ds.al.avl.TreeOps;

import com.ds.al.avl.TreeEntity.AvlTreeEntity;
import static com.ds.al.avl.Utility.TreeUtility.getMax;

public class TreeOpsImpl implements TreeOps {

	private int getNodeHeight(AvlTreeEntity node) {
		if (node == null)
			return 0;
		else
			return node.getHeight();
	}

	private int getHeightDiff(AvlTreeEntity node)

	{
		if (node == null)
			return 0;
		else
			return getNodeHeight(node.getLeft()) - getNodeHeight(node.getRight());

	}

	private AvlTreeEntity rightRotate(AvlTreeEntity node) {
		
		
		AvlTreeEntity leftNode = node.getLeft();
		AvlTreeEntity rightNode = leftNode.getRight();
		node.setLeft(rightNode);
		leftNode.setRight(node);
		node.setHeight(getMax(getNodeHeight(node.getLeft()), getNodeHeight(node.getRight())) + 1);
		leftNode.setHeight(getMax(getNodeHeight(leftNode.getLeft()), getNodeHeight(leftNode.getRight())) + 1);
		return leftNode;

	}

	private AvlTreeEntity leftRotate(AvlTreeEntity node) {

		AvlTreeEntity rightNode = node.getRight();
		AvlTreeEntity leftNode = rightNode.getLeft();
		node.setRight(leftNode);
		rightNode.setLeft(node);
		node.setHeight(getMax(getNodeHeight(node.getLeft()), getNodeHeight(node.getRight())) + 1);
		rightNode.setHeight(getMax(getNodeHeight(rightNode.getLeft()),getNodeHeight(rightNode.getRight())) + 1);
		return rightNode;

	}

	private AvlTreeEntity insertIntoBST(AvlTreeEntity node, int data) {

		if (node == null) {
			node = new AvlTreeEntity();
			node.setData(data);
			return node;
		}
		if (data < node.getData())
			node.setLeft(insertIntoBST(node.getLeft(), data));
		else if (data > node.getData())
			node.setRight(insertIntoBST(node.getRight(), data));
		node.setHeight(getMax(getNodeHeight(node.getLeft()), getNodeHeight(node.getRight())) + 1);
		int balanceFactor = getHeightDiff(node);
		if (balanceFactor > 1 && data < node.getLeft().getData()) {
			return rightRotate(node);
		}

		if (balanceFactor > 1 && data > node.getLeft().getData()) {
			node.setLeft(leftRotate(node.getLeft()));
			return rightRotate(node);
		}
		if (balanceFactor < -1 && data > node.getRight().getData()) {
			return leftRotate(node);
		}
		if (balanceFactor < -1 && data < node.getRight().getData()) {
			node.setRight(rightRotate(node.getRight()));
			return leftRotate(node);
		}

		return node;
	}

	@Override
	public AvlTreeEntity createAVLTree(int[] avlArr) {
		// TODO Auto-generated method stub
		AvlTreeEntity root = null;
		for (Integer i : avlArr)
			root = insertIntoBST(root, i);

		return root;
	}

	@Override
	public int countNodesinRange(int startRange, int endRange,AvlTreeEntity node) {
		// TODO Auto-generated method stub
		if(node==null)
			return 0;
		if(node.getData() < startRange)
		return countNodesinRange(startRange, endRange, node.getRight());
		else if(node.getData() >=endRange)
			return countNodesinRange(startRange, endRange, node.getLeft());
		else
			return 1+countNodesinRange(startRange, endRange, node.getLeft())+countNodesinRange(startRange, endRange, node.getRight());
		
	}

}
