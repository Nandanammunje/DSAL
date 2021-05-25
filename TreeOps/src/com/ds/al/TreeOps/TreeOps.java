package com.ds.al.TreeOps;

import com.ds.al.tree.TreeEntity;

public interface TreeOps {

	public TreeEntity getCreateTreeInorderPreorder(String inorderSequence, String preOrderSequence);

	public String[] getAncestors(String treeNode);

	public String getLCA(String treeNode1, String treeNode2);
	
	public String getZigZagStr() throws Exception ;

}
