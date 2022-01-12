package com.ds.al.Threaded.TreeOps;

import com.ds.al.Threaded.TreeEntity.ThreadedBinaryTreeEntity;

public interface TreeOps {

	public ThreadedBinaryTreeEntity CreateThreadedBinary(String inorderSeq, String preOrderSeq);

	public ThreadedBinaryTreeEntity findInorderSuccessor(String node);

	public ThreadedBinaryTreeEntity findPreorderSuccessor(String node);

	public ThreadedBinaryTreeEntity InsertNode(String parentNode, String childNode);

}
