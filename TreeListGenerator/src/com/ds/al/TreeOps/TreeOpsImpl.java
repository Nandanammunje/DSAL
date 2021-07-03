package com.ds.al.TreeOps;

import java.util.ArrayList;
import java.util.List;

import com.ds.al.tree.TreeEntity;

public class TreeOpsImpl implements TreeOps {

	@Override
	public List<TreeEntity> makeTrees(int nodeLimit) {
		// TODO Auto-generated method stub

		return GenBSTList(1, nodeLimit);
	}

	public List<TreeEntity> GenBSTList(int start, int end) {
		ArrayList<TreeEntity> treeList = new ArrayList<TreeEntity>();
		if (start > end) {
			treeList.add(null);
			return treeList;
		}
		if (start == end) {
			TreeEntity node = new TreeEntity();
			node.setData(start);
			node.setLeft(null);
			node.setRight(null);
			treeList.add(node);
			return treeList;
		}
		if (start + 1 == end) {
			TreeEntity nodeLeft = new TreeEntity();
			nodeLeft.setData(start);
			nodeLeft.setLeft(null);
			TreeEntity nodeRight = new TreeEntity();
			nodeRight.setData(end);
			nodeRight.setRight(null);
			nodeRight.setLeft(null);
			nodeLeft.setRight(nodeRight);
			treeList.add(nodeLeft);
			nodeLeft = new TreeEntity();
			nodeLeft.setData(start);
			nodeLeft.setRight(null);
			nodeLeft.setLeft(null);
			nodeRight = new TreeEntity();
			nodeRight.setData(end);
			nodeRight.setLeft(nodeLeft);
			nodeRight.setRight(null);
			treeList.add(nodeRight);
			return treeList;

		}

		for (int i = start; i <= end; i++) {

			List<TreeEntity> leftTree = GenBSTList(start, i - 1);
			List<TreeEntity> rightTree = GenBSTList(i + 1, end);

			for (int k = 0; k < leftTree.size(); k++) {
				TreeEntity left = leftTree.get(k);
				for (int j = 0; j < rightTree.size(); j++) {
					TreeEntity right = rightTree.get(j);
					TreeEntity node = new TreeEntity();
					node.setData(i);
					node.setLeft(left);
					node.setRight(right);
					treeList.add(node);
				}
			}

		}

		return treeList;
	}

	@Override
	public void PreorderTraversal(TreeEntity root) {
		// TODO Auto-generated method stub

		if (root != null) {
			System.out.print(root.getData()+" ");
			PreorderTraversal(root.getLeft());
			PreorderTraversal(root.getRight());
		} else
			return;

	}

}
