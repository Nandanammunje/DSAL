package com.ds.al.TreeUtility;

public class DoubleLinkedLstEntity {
	private DoubleLinkedLstEntity root;
	private DoubleLinkedLstEntity nxt;
	private DoubleLinkedLstEntity prev;
	private int length;
	private char data;

	public DoubleLinkedLstEntity() {

		root = null;
		length = 0;
		// TODO Auto-generated constructor stub
	}

	public DoubleLinkedLstEntity getNxt() {
		return nxt;
	}

	public void setNxt(DoubleLinkedLstEntity nxt) {
		this.nxt = nxt;
	}

	public DoubleLinkedLstEntity getPrev() {
		return prev;
	}

	public void setPrev(DoubleLinkedLstEntity prev) {
		this.prev = prev;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public DoubleLinkedLstEntity getHead() {
		return root;
	}

	public void addNode(char data) {
		if (root == null) {
			root = new DoubleLinkedLstEntity();
			root.setData(data);
			root.setNxt(null);
			root.setPrev(null);

		}

		else {
			DoubleLinkedLstEntity temp = root;
			while (temp.getNxt() != null)
				temp = temp.getNxt();
			DoubleLinkedLstEntity node = new DoubleLinkedLstEntity();
			node.setData(data);
			node.setNxt(null);
			node.setPrev(temp);
			temp.setNxt(node);
		}
		length++;
	}

	public void removeNode(DoubleLinkedLstEntity node) {
		DoubleLinkedLstEntity nxtNode;
		if (node == null)
			return;

		if (node == root) {
			nxtNode = node.getNxt();
			if (nxtNode != null)
				nxtNode.setPrev(null);
			root = nxtNode;
			node = null;
		} else {

			nxtNode = node.getNxt();
			node.getPrev().setNxt(nxtNode);
			if (nxtNode != null)
				nxtNode.setPrev(node.getPrev());

			node = null;

		}
		length--;
	}

	public int getLength() {
		return length;
	}

	public void printLst() {
		System.out.println("List of Nodes are ");
		String nodeString = "";
		for (DoubleLinkedLstEntity node = root; node != null; node = node.getNxt()) {
			nodeString = nodeString + node.getData() + "->";
		}
		System.out.println(nodeString);
	}

}
