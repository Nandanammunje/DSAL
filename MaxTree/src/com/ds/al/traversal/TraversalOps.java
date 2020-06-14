package com.ds.al.traversal;

import com.ds.al.entity.TreeEntity;

public interface TraversalOps {

	public void PreorderTraversal(TreeEntity root);

	public void InorderTravsersal(TreeEntity root);

	public int MaxTreeElement(TreeEntity root);

	public int MaxTreeElementIterative(TreeEntity root);

	public boolean SearchTreeElement(TreeEntity root, int data);

	public boolean SearchTreeElementIterative(TreeEntity root, int data);

	public int TreeSizeCalculator(TreeEntity root);

	public int TreeSizeCalculatorIterartive(TreeEntity root);

	public int GetTreeHeight(TreeEntity root);

	public int GetTreeHeightIterative(TreeEntity root);

	public int TreeGetDeepestNode(TreeEntity root);

	public int GetHalfNodes(TreeEntity root);

	public int GetLeafNodes(TreeEntity root);

	public int GetFullNodes(TreeEntity root);

}
