package com.ds.al.TreeUtility;

import com.ds.al.tree.TreeEntity;

public class StackEntity {

	private LinkedLstEntity head;

	private LinkedLstEntity tail;

	private int length;

	public StackEntity() {

		length = 0;
		head = null;
		tail = null;
	}

	public void pushNode(TreeEntity node) {
		LinkedLstEntity stackNode = new LinkedLstEntity();

		head = stackNode.AddNode(head, node);
		if (tail == null) {

			tail = head;
		}
		length++;
	}

	public TreeEntity popNode() throws Exception {

		if (length > 0) {
			LinkedLstEntity node = head.getNext();
			TreeEntity popNode = head.getNode();
			head = node;
			length--;
			return popNode;
		} else {
			throw new Exception("Cannot perform pop action on Empty ");
		}

	}

	public int size() {
		return length;

	}
	


}
