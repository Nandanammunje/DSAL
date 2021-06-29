package com.ds.al.TreeUtility;

import com.ds.al.tree.TreeEntity;

public class StackEntity {

	private LinkedLstEntity first, last;
	private int length;

	public StackEntity() {
		length = 0;
		first = last = null;
	}

	public void pushStack(TreeEntity treeNode) {
		LinkedLstEntity node = new LinkedLstEntity();
		if (first == null) {
			first = node.AddNode(first, treeNode);
			last = first;
		} else {
			first = node.AddNode(first, treeNode);
		}
		length++;
	}

	public TreeEntity popStack() throws Exception {

		TreeEntity node = null;

		if (length > 0) {
			LinkedLstEntity nextNode;
			nextNode = first.getNext();
			node = first.getNode();
			first = nextNode;
		} else {
			throw new Exception("cannot perform pop operation on empty queue");
		}
		length--;
		return node;
	}

	public int getStackSize() {
		return length;
	}

	public TreeEntity getFirst() {
		if (first == null)
			return null;
		return first.getNode();
	}

	public TreeEntity getLast() {
		if (last == null)
			return null;
		return last.getNode();
	}

}

