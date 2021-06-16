package com.ds.al.TreeUtility;

import com.ds.al.tree.TreeEntity;

/**
 * @author nandannayak This is utitily class for queue entity where queue is
 *         created using LinkedList
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
	 * @param head     is starting member of the queue
	 * @param Treenode is Tree data to be pushed into the queue
	 * @returns the first member of the list i.e is head
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

	public LinkedLstEntity BackNode(LinkedLstEntity head, TreeEntity Treenode) {
		LinkedLstEntity node;

		if (head == null) {
			head = new LinkedLstEntity();
			head.setNode(Treenode);
			head.setNext(null);

		} else {

			node = new LinkedLstEntity();
			node.setNode(Treenode);
			node.setNext(head);
			head = node;

		}
		return head;
	}

}
>>>>>>> bca1f0593787cec261bf7cf3470d9e893fbb1671
