package com.ds.al.BinarySearch.TreeOps;

import com.ds.al.BinarySearch.TreeEntity.BinarySearchTreeEntity;

public interface TreeOps {

	public BinarySearchTreeEntity createBST(String dataStr);

	public BinarySearchTreeEntity findNode(String dataStr);

	public BinarySearchTreeEntity findMinimumNode();

	public BinarySearchTreeEntity findMaximumNode();

	public int findShortestPath(String bstNodeFirst,String bstNodeSecond);
}
