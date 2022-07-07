package com.ds.al.BinarySearch.TreeOps;

import java.util.ArrayList;

import com.ds.al.BinarySearch.TreeEntity.BinarySearchTreeEntity;
import com.ds.al.Circular.DoubleLinkedLstEntity.CircularDoubleLinkedLstEntity;
import com.ds.al.DoubleLinkedLstEntity.DoubleLinkedLst;
import com.ds.al.Threaded.TreeEntity.ThreadedBinaryTreeEntity;

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

	public BinarySearchTreeEntity findFloorNode(int key);

	public ArrayList<String> findIntersection(BinarySearchTreeEntity nodeA, BinarySearchTreeEntity nodeB);

	public void findIntersectionOptimized(DoubleLinkedLst nodeA, DoubleLinkedLst nodeB,
			ArrayList<String> commonNodeLst);

	public DoubleLinkedLst convertBST2DLL(BinarySearchTreeEntity node);

	void printBSTRange(BinarySearchTreeEntity root, int K1, int K2);
	
	void printThreadedBinaryTree(ThreadedBinaryTreeEntity root,int k1,int k2);

	public ThreadedBinaryTreeEntity getThreadedBSTRoot(String[] bstnodes);

}
