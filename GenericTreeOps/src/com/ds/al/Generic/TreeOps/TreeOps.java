package com.ds.al.Generic.TreeOps;

import com.ds.al.Generic.TreeEntity.GenericTreeEntity;

public interface TreeOps {

	public GenericTreeEntity mkGenericTree(String preOrderString, String inorderString);

	public void TreeTraversal(GenericTreeEntity root);

	public String getNodeSum(GenericTreeEntity root);

}
