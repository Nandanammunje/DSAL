package com.ds.al.traversal;

import com.ds.al.trees.TreeEntity;

public class TraversalOpsImpl implements TraversalOps {

	@Override
	public void PreorderTraversal(TreeEntity root) {
		// TODO Auto-generated method stub
		if (root != null) {
			System.out.println(root.getData());
			PreorderTraversal(root.getLeft());
			PreorderTraversal(root.getRight());
		} else
			return;
	}

	@Override
	public void InorderTravsersal(TreeEntity root) {
		// TODO Auto-generated method stub
		if (root != null) {
			InorderTravsersal(root.getLeft());
			System.out.println(root.getData());
			InorderTravsersal(root.getRight());
		} else
			return;
	}

}
