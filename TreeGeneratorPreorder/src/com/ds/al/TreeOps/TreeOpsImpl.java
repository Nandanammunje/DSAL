package com.ds.al.TreeOps;

import static com.ds.al.constants.TreeConstants.LEAFNODE;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import com.ds.al.tree.TreeEntity;

public class TreeOpsImpl implements TreeOps {

	private TreeEntity root;

	private int nodeIndex;

	@Override
	public TreeEntity createTreeCustomPreorder(String customPreOrderSeq) {
		// TODO Auto-generated method stub
		nodeIndex = 0;
		if (customPreOrderSeq.length() < 3)
			return null;
		else {
			genTree(root, customPreOrderSeq, nodeIndex, null, true);
			return root;
		}
	}

	public void genTree(TreeEntity root, String customPreOrderSeq, int index, TreeEntity head, boolean isLeft) {
		if (index > customPreOrderSeq.length() - 1)
			return;
		if (index == 0) {
			head = createTreeNode(this.root, head, customPreOrderSeq.charAt(0), isLeft);
			nodeIndex++;
			genTree(this.root, customPreOrderSeq, nodeIndex, head, TRUE);
			nodeIndex++;
			genTree(this.root, customPreOrderSeq, nodeIndex, head, FALSE);

		} else {
			head = createTreeNode(root, head, customPreOrderSeq.charAt(index), isLeft);
			if (head.getData() == LEAFNODE) {
				return;
			} else {
				nodeIndex++;
				genTree(this.root, customPreOrderSeq, nodeIndex, head, TRUE);
				nodeIndex++;
				genTree(this.root, customPreOrderSeq, nodeIndex, head, FALSE);
			}
		}

	}

	private TreeEntity createTreeNode(TreeEntity root, TreeEntity head, char data, boolean isLeft) {
		if (root == null) {
			root = new TreeEntity();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
			head = root;
			this.root = root;

		} else {
			TreeEntity node = new TreeEntity();
			node.setData(data);
			node.setLeft(null);
			node.setRight(null);
			if (isLeft)
				head.setLeft(node);
			else
				head.setRight(node);
			head = node;
		}
		return head;
	}

	@Override
	public void PreorderTraversal(TreeEntity root) {
		// TODO Auto-generated method stub
		if (root != null) {
			System.out.print(root.getData() + " ");
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
			System.out.print(root.getData()+" ");
			InorderTravsersal(root.getRight());
		} else
			return;

	}

}
