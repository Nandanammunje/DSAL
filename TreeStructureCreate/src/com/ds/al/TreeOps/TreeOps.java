package com.ds.al.TreeOps;

import com.ds.al.tree.TreeEntity;

public interface TreeOps {
	
	public TreeEntity getCreateTreeInorderPreorder(String inorderSequence,String preOrderSequence);

	public TreeEntity getCreateTreeInorderPostorder(String inorderSequence,String postOrderSequence);	
	
	
}
