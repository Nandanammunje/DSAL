package com.ds.al.TreeUtility;

import com.ds.al.tree.TreeEntity;

/**
 * @author nandannayak
 * This is utitily class for queue entity where queue is created using LinkedList
 */
public class LinkedLstEntity {

	private TreeEntity node;
	private LinkedLstEntity next;

	public TreeEntity getNode() {
		return node;
	}

	public void setNode(TreeEntity node) {
		this.node = node;
	}

	public LinkedLstEntity getNext() {
		return next;
	}

	public void setNext(LinkedLstEntity next) {
		this.next = next;
	}

	/**
	 * @param head is starting member of the queue
	 * @param Treenode is Tree data to be pushed into the queue
	 * @return
	 */
	public LinkedLstEntity AddNode(LinkedLstEntity head, TreeEntity Treenode) {
		// TODO Auto-generated method stub
		LinkedLstEntity root, node;

		if (head == null) {
			head = new LinkedLstEntity();
			head.setNode(Treenode);
			head.setNext(null);

		} else {
			root = head;
			while (root.getNext() != null)
				root = root.getNext();
			node = new LinkedLstEntity();
			node.setNext(null);
			node.setNode(Treenode);
			root.setNext(node);
			return root;
		}
		return head;
	}

}
