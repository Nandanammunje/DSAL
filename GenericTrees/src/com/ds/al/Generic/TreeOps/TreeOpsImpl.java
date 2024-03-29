package com.ds.al.Generic.TreeOps;

import com.ds.al.Generic.TreeEntity.GenericTreeEntity;

public class TreeOpsImpl implements TreeOps {

	public int index;

	public GenericTreeEntity root;

	public int headIndex;

	public void createTreeGeneric(GenericTreeEntity root, GenericTreeEntity head, int Index, String preOrderString,
			String inorderString, String inorderSubStr) {
		if (Index >= preOrderString.length() || inorderSubStr == null | inorderSubStr.isEmpty()) {
			return;
		}
		boolean isChild;
		String node = Character.toString(preOrderString.charAt(Index));
		int nodeIndex = inorderString.indexOf(node);
		index++;
		if (nodeIndex > headIndex)
			isChild = false;
		else
			isChild = true;
		head = createTreeNode(head, node, isChild);
		headIndex = nodeIndex;
		String siblingStr = "";
		String childStr = "";
		int splitIndex = inorderSubStr.indexOf(node);
		if (splitIndex < inorderSubStr.length()) {

			childStr = inorderSubStr.substring(0, splitIndex);
			siblingStr = inorderSubStr.substring(splitIndex + 1, inorderSubStr.length());
		}

		createTreeGeneric(this.root, head, index, preOrderString, inorderString, childStr);
		createTreeGeneric(this.root, head, index, preOrderString, inorderString, siblingStr);

	}

	public GenericTreeEntity createTreeNode(GenericTreeEntity head, String nodeData, boolean isChild) {

		if (head == null) {

			head = new GenericTreeEntity();
			head.setData(nodeData);
			head.setFirstChild(null);
			head.setNextSibbling(null);
			this.root = head;
			return head;
		} else {
			GenericTreeEntity node = new GenericTreeEntity();
			node.setData(nodeData);
			if (isChild)
				head.setFirstChild(node);
			else
				head.setNextSibbling(node);

			head = node;
		}
		return head;

	}

	@Override
	public GenericTreeEntity mkGenericTree(String preOrderString, String inorderString) {
		// TODO Auto-generated method stub
		createTreeGeneric(null, null, 0, preOrderString, inorderString, inorderString);
		return this.root;

	}

	@Override
	public void TreeTraversal(GenericTreeEntity root) {
		// TODO Auto-generated method stub
		if (root != null) {
			TreeTraversal(root.getFirstChild());
			System.out.println(" " + root.getData());
			TreeTraversal(root.getNextSibbling());
			

		}

	}

}
