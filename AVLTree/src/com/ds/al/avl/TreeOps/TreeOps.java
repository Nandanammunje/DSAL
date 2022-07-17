package com.ds.al.avl.TreeOps;

import com.ds.al.avl.TreeEntity.AvlTreeEntity;

public interface TreeOps {

	public AvlTreeEntity createAVLTree(int[] avlArr);
	
	public int countNodesinRange(int startRange,int endRange,AvlTreeEntity root);

}
