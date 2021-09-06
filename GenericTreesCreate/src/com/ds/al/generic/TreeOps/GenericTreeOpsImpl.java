package com.ds.al.generic.TreeOps;

import com.ds.al.generic.tree.GenericTreeEntity;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class GenericTreeOpsImpl implements GenericTreeOps {

	private int headIndex;
	private GenericTreeEntity root;
	private int currNodeIndex;

	/**
	 * BT representation of Generic Tree where child is left node and sibling as
	 * right node starting from extreme left to right
	 */
	@Override
	public GenericTreeEntity getCreateGenericTreeInorderPreorder(String inorderSequence, String preOrderSequence) {
		// TODO Auto-generated method stub
       createGenericTree(inorderSequence, preOrderSequence,null,0,null, inorderSequence);   
		return root;
	}

	public void createGenericTree(String inorderSubStr, String preOrderSequence, GenericTreeEntity root, int index,
			GenericTreeEntity head, String inOrderSequence) {

		if (inorderSubStr == null || inorderSubStr.isEmpty() || inorderSubStr.length() == 0) {
			return;

		}
		boolean isChild;
		String node = Character.toString(preOrderSequence.charAt(index));
		int nodeIndex = inOrderSequence.indexOf(node);
		if (nodeIndex > headIndex)
			isChild = FALSE;
		else
			isChild = TRUE;
		head = createTreeNode(root, head, node, isChild);
		headIndex = nodeIndex;
		currNodeIndex++;
		String leftSequence = "";
		int splitIndex = inorderSubStr.indexOf(node);
		if (splitIndex + 1 <= inorderSubStr.length())
			leftSequence = inorderSubStr.substring(0, splitIndex);
		String rightSequence = "";
		if (splitIndex + 1 < inorderSubStr.length())
			rightSequence = inorderSubStr.substring(splitIndex + 1, inorderSubStr.length());
		createGenericTree(leftSequence, preOrderSequence, this.root, currNodeIndex, head, inOrderSequence);
		createGenericTree(rightSequence, preOrderSequence, this.root, currNodeIndex, head, inOrderSequence);
	}

	private GenericTreeEntity createTreeNode(GenericTreeEntity root, GenericTreeEntity head, String data,
			boolean isChild) {
		if (root == null) {
			root = new GenericTreeEntity();
			root.setData(data);
			root.setNextChild(null);
			root.setNextSibling(null);
			head = root;
			this.root = root;

		} else {
			GenericTreeEntity node = new GenericTreeEntity();
			node.setData(data);
			node.setNextChild(null);
			node.setNextSibling(null);
			if (isChild)
				head.setNextChild(node);
			else
				head.setNextSibling(node);
			head = node;
		}
		return head;
	}
}
