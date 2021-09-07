package com.ds.al.Generic.TreeOps;

import com.ds.al.Generic.TreeEntity.GenericTreeEntity;

public interface TreeOps {

	public GenericTreeEntity mkGenericTree(String preOrderString, String inorderString);

	public void TreeTraversal(GenericTreeEntity root);

	public String getNodeSum(GenericTreeEntity root);
	
	public int getDepth(int parentArr[]);
	
	public boolean isIsomorphic(GenericTreeEntity root1,GenericTreeEntity root2);
	
	public boolean isQuasiIsomorphic(GenericTreeEntity root1,GenericTreeEntity root2);

}
