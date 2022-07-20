package com.ds.al.TreeOps;

import java.util.TreeMap;

import com.ds.al.tree.TreeEntity;

public interface TreeOps {

	public TreeEntity getCreateTreeInorderPreorder(String inorderSequence, String preOrderSequence);

	public String[] getAncestors(String treeNode);

	public String getLCA(String treeNode1, String treeNode2);

	public String getZigZagStr() throws Exception;

	public TreeMap<Integer, String> getVerticalSum();

	public int getMinDepthRecursive();

	public int getMinDepthLevelOrder();

	public TreeEntity getPreOrderSuccessor(String treeNode);
	
	public TreeEntity deleteHalfNodes(TreeEntity root);

}
