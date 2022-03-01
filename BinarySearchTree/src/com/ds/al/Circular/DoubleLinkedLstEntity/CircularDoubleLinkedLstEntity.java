package com.ds.al.Circular.DoubleLinkedLstEntity;

public class CircularDoubleLinkedLstEntity {

	private CircularDoubleLinkedLstEntity head;

	private CircularDoubleLinkedLstEntity prev;

	private CircularDoubleLinkedLstEntity next;

	private String data;

	public CircularDoubleLinkedLstEntity getHead() {
		return head;
	}

	public void setHead(CircularDoubleLinkedLstEntity head) {
		this.head = head;
	}

	public CircularDoubleLinkedLstEntity getPrev() {
		return prev;
	}

	public void setPrev(CircularDoubleLinkedLstEntity prev) {
		this.prev = prev;
	}

	public CircularDoubleLinkedLstEntity getNext() {
		return next;
	}

	public void setNext(CircularDoubleLinkedLstEntity next) {
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
