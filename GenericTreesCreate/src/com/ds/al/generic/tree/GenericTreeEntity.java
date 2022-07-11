package com.ds.al.generic.tree;

public class GenericTreeEntity {

	private String data;

	private GenericTreeEntity nextSibling;

	private GenericTreeEntity nextChild;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public GenericTreeEntity getNextSibling() {
		return nextSibling;
	}

	public void setNextSibling(GenericTreeEntity nextSibling) {
		this.nextSibling = nextSibling;
	}

	public GenericTreeEntity getNextChild() {
		return nextChild;
	}

	public void setNextChild(GenericTreeEntity nextChild) {
		this.nextChild = nextChild;
	}
	
	
	

}
