package com.ds.al.TreeOps;

import com.ds.al.tree.TreeEntity;

public interface TreeOps {

	public boolean CompareTreeStructure(TreeEntity root1, TreeEntity root2);

	public int GetTreeDiameter(TreeEntity root);

	public int GetTeeDiamterUtility(TreeEntity root);

	public int getMaxLevelSum(TreeEntity root);

	public void getRoottoLeafPath(TreeEntity root, String dataString);

	public boolean isSumPathExist(TreeEntity root, int pathSum);

	public int getBTSum(TreeEntity root);

	public int getBTSumIterative(TreeEntity root);

	public TreeEntity MirrorTree(TreeEntity root);

	public void InorderTravsersal(TreeEntity root);

}
