package com.ds.al.TreeOps;

import java.util.List;

import com.ds.al.tree.TreeEntity;

public interface TreeOps {

	public List<TreeEntity> makeTrees(int nodeLimit);
	public void PreorderTraversal(TreeEntity root);
}
