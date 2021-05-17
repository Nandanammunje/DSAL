package com.ds.al.TreeUtility;

public class LinkedTreePathEntity {

	private int data;
	private LinkedTreePathEntity next;
	private LinkedTreePathEntity current;
	private LinkedTreePathEntity head;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkedTreePathEntity getNext() {
		return next;
	}

	public void setNext(LinkedTreePathEntity next) {
		this.next = next;
	}

	public LinkedTreePathEntity addNode(int data) {
		LinkedTreePathEntity root = null;
		if (head == null) {
			head = new LinkedTreePathEntity();
			head.setData(data);
			head.setNext(null);
			current = head;
		} else {
			root = new LinkedTreePathEntity();
			root.setData(data);
			root.setNext(null);
			current.setNext(root);
			current = root;

		}

		return head;

	}

	@Override
	public String toString() {
		return "LinkedTreePathEntity [data=" + data + "]";
	}
	
}
