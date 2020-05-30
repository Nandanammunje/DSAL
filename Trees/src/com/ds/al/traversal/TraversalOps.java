package com.ds.al.traversal;

import java.util.List;

import com.ds.al.entity.TreeEntity;

public interface TraversalOps {

	public void PreorderTraversal(TreeEntity root);
	public void InorderTravsersal(TreeEntity root);
	public void PostorderTraversal(TreeEntity root);
	public List<Integer> PreorderTraversalIterative(TreeEntity root);
	public List<Integer> InorderTraversalIterative(TreeEntity root);
	public List<Integer> PostOrderTraversalIterartive(TreeEntity root);
	
}
