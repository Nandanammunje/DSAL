package com.ds.al.BinarySearch.TreeOps;

import com.ds.al.BinarySearch.TreeEntity.BinarySearchTreeEntity;
import com.ds.al.Circular.DoubleLinkedLstEntity.CircularDoubleLinkedLstEntity;

public class TreeOpsImpl implements TreeOps {

	private BinarySearchTreeEntity root;
	private BinarySearchTreeEntity foundNode;
	private BinarySearchTreeEntity minNode;
	private BinarySearchTreeEntity maxNode;
	private CircularDoubleLinkedLstEntity head;
	private CircularDoubleLinkedLstEntity prevLstNode;

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

	private int compareCharacterInt(char a, char b) {
		int charFirst = (int) a;
		int charSecond = (int) b;
		int compareInt = (charFirst == charSecond) ? 0 : (charFirst > charSecond) ? 1 : -1;
		return compareInt;

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

	public void setMinimumNode(BinarySearchTreeEntity node) {
		if (node != null) {
			minNode = node;
			setMinimumNode(node.getLeft());
		}

		else
			return;
	}

	public void setMaximumNode(BinarySearchTreeEntity node) {
		if (node != null) {
			maxNode = node;
			setMaximumNode(node.getRight());
		} else
			return;

	}

	@Override
	public BinarySearchTreeEntity findMinimumNode() {
		// TODO Auto-generated method stub
		setMinimumNode(root);

		return minNode;
	}

	@Override
	public BinarySearchTreeEntity findMaximumNode() {
		// TODO Auto-generated method stub
		setMaximumNode(root);
		return maxNode;
	}

	public String createPathString(String bstNode, String dataStr, BinarySearchTreeEntity node) {
		if (node == null)
			return dataStr;
		int charComparVal = compareCharacterInt(bstNode.charAt(0), node.getData().charAt(0));
		if (charComparVal > 0) {
			dataStr = dataStr + node.getData() + createPathString(bstNode, dataStr, node.getRight());

		} else if (charComparVal < 0) {
			dataStr = dataStr + node.getData() + createPathString(bstNode, dataStr, node.getLeft());
		} else {
			dataStr = dataStr + node.getData();
		}

		return dataStr;
	}

	@Override
	public int findShortestPath(String bstNodeFirst, String bstNodeSecond) {
		// TODO Auto-generated method stub
		String nodePath1 = "";
		String nodePath2 = "";
		nodePath1 = nodePath1 + createPathString(bstNodeFirst, nodePath1, root);
		nodePath2 = nodePath2 + createPathString(bstNodeSecond, nodePath2, root);
        int shortestPath=getDistFromLCA(nodePath1, nodePath2);
		
		return shortestPath;
	}

	public int getDistFromLCA(String nodePath1, String nodePath2) {
		int loopLength = (nodePath1.length() > nodePath2.length()) ? nodePath2.length() : nodePath1.length();
		int comparIndex = 0;
		for (int i = 0; i < loopLength; i++) {
			if (compareCharacterInt(nodePath1.charAt(i), nodePath2.charAt(i)) == 0) {
				comparIndex = i;

			}
		}
        comparIndex=2*comparIndex;
		int nodeDistance = nodePath1.length()+nodePath2.length()-comparIndex-2;
		return nodeDistance;

	}

	public void inorderTraverseConvert(CircularDoubleLinkedLstEntity prevNode,BinarySearchTreeEntity root)
	{
		
		if(root!=null)
		{
		inorderTraverseConvert(prevNode ,root.getLeft());
		initializeLst(root.getData());
		inorderTraverseConvert(prevNode, root.getRight());
		}
		
		
		
	}
	
	public void initializeLst(String data)
	
	{
		CircularDoubleLinkedLstEntity currNode;
		if(head==null)
		{
			head=new CircularDoubleLinkedLstEntity();
			head.setData(data);
			head.setNext(head);
			head.setPrev(null);
			currNode=head;
		}
		else
		{
			CircularDoubleLinkedLstEntity node=new CircularDoubleLinkedLstEntity();
			node.setData(data);
			node.setPrev(prevLstNode);
			prevLstNode.setNext(node);
			node.setNext(head);
			currNode=node;
			
			
		}
		prevLstNode=currNode;
		
	}
	
	@Override
	public CircularDoubleLinkedLstEntity convertBST2CDLL() {
		// TODO Auto-generated method stub
		inorderTraverseConvert(head, root);
		
		return head;
	}
}
