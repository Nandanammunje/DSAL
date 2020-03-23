package com.ds.al.doublelinked.lst;

public class StructuredList {

	private int data;
	private StructuredList prev;
	private StructuredList next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public StructuredList getPrev() {
		return prev;
	}
	public void setPrev(StructuredList prev) {
		this.prev = prev;
	}
	public StructuredList getNext() {
		return next;
	}
	public void setNext(StructuredList next) {
		this.next = next;
	}
	
	
}
