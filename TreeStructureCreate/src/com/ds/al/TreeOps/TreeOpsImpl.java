package com.ds.al.TreeOps;

import com.ds.al.tree.TreeEntity;
import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;

public class TreeOpsImpl implements TreeOps {

	private int headIndex;
	private TreeEntity root;
	private int currNodeIndex;

	private void getCreateTree(String inorderSubStr, String preOrderSequence, TreeEntity root, int index,
			TreeEntity head, String inOrderSequence) {
		// TODO Auto-generated method stub

		if (index > preOrderSequence.length() || inorderSubStr == null || inorderSubStr.isEmpty())
			return;
		boolean isLeft;
		String preOrderNode = Character.toString(preOrderSequence.charAt(index));
		int nodeIndex = inOrderSequence.indexOf(preOrderNode);
		if (nodeIndex > headIndex)
			isLeft = FALSE;
		else
			isLeft = TRUE;
		head = createTreeNode(root, head, preOrderNode, isLeft);
		headIndex = nodeIndex;
		currNodeIndex++;
		String leftSequence = "";
		int splitIndex = inorderSubStr.indexOf(preOrderNode);
		if (splitIndex + 1 <= inorderSubStr.length())
			leftSequence = inorderSubStr.substring(0, splitIndex);
		String rightSequence = "";
		if (splitIndex + 1 < inorderSubStr.length())
			rightSequence = inorderSubStr.substring(splitIndex + 1, inorderSubStr.length());
		getCreateTree(leftSequence, preOrderSequence, this.root, currNodeIndex, head, inOrderSequence);
		getCreateTree(rightSequence, preOrderSequence, this.root, currNodeIndex, head, inOrderSequence);

	}

	private TreeEntity createTreeNode(TreeEntity root, TreeEntity head, String data, boolean isLeft) {
		if (root == null) {
			root = new TreeEntity();
			root.setData(data.charAt(0));
			root.setLeft(null);
			root.setRight(null);
			head = root;
			this.root = root;

		} else {
			TreeEntity node = new TreeEntity();
			node.setData(data.charAt(0));
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
	public TreeEntity getCreateTreeInorderPreorder(String inorderSequence, String preOrderSequence) {
		// TODO Auto-generated method stub
		getCreateTree(inorderSequence, preOrderSequence, null, 0, null, inorderSequence);

		return this.root;
	}

	public void mkTreeInorderPostorder(String inorderSub, String postOrderSeq, TreeEntity root, int index,TreeEntity head, String inorderSequence) {
		if (index > postOrderSeq.length() || inorderSub == null || inorderSub.isEmpty())
			return;
		String postOrderNode = Character.toString(postOrderSeq.charAt(index));
		boolean isLeft;
		int nodeIndex = inorderSequence.indexOf(postOrderNode);
		if (nodeIndex > headIndex)
			isLeft = FALSE;
		else
			isLeft = TRUE;
		head = createTreeNode(root, head, postOrderNode, isLeft);
		headIndex = nodeIndex;
		currNodeIndex++;
		String leftSequence = "";
		String rightSequence = "";
		int splitIndex = inorderSub.indexOf(postOrderNode);
		if (splitIndex < inorderSequence.length()) {
			leftSequence = inorderSub.substring(0, splitIndex);
			rightSequence = inorderSub.substring(splitIndex + 1, inorderSub.length());
		}
		mkTreeInorderPostorder(rightSequence, postOrderSeq, this.root, currNodeIndex, head, inorderSequence);
		mkTreeInorderPostorder(leftSequence, postOrderSeq, this.root, currNodeIndex, head, inorderSequence);

	}

	@Override
	public TreeEntity getCreateTreeInorderPostorder(String inorderSequence, String postOrderSequence) {
		// TODO Auto-generated method stub
		mkTreeInorderPostorder(inorderSequence, postOrderSequence, null, 0, null, inorderSequence);
		return this.root;
	}

}
