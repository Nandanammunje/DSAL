package com.ds.al.BinarySearch.TreeOps;

import com.ds.al.BinarySearch.TreeEntity.BinarySearchTreeEntity;
import com.ds.al.Circular.DoubleLinkedLstEntity.CircularDoubleLinkedLstEntity;
import com.ds.al.DoubleLinkedLstEntity.DoubleLinkedLst;

public interface TreeOps {

	public BinarySearchTreeEntity createBST(String[] bstnodes);

	public BinarySearchTreeEntity findNode(String dataStr);

	public BinarySearchTreeEntity findMinimumNode();

	public BinarySearchTreeEntity findMaximumNode();

	public int findShortestPath(String bstNodeFirst, String bstNodeSecond);

	public CircularDoubleLinkedLstEntity convertBST2CDLL();

	public BinarySearchTreeEntity convertDLL2BST(DoubleLinkedLst head);

	public BinarySearchTreeEntity convertDLL2BSTOptimized(DoubleLinkedLst head);
	
	public BinarySearchTreeEntity findKthSmallestNode(int rank);
	
	 public BinarySearchTreeEntity findCeilNode(int key);
}
