package com.ds.al.Generic.TreeEntity;

public class GenericTreeEntity {
	
private String Data;

private GenericTreeEntity firstChild;

private GenericTreeEntity nextSibbling;

public String getData() {
	return Data;
}

public void setData(String data) {
	Data = data;
}

public GenericTreeEntity getFirstChild() {
	return firstChild;
}

public void setFirstChild(GenericTreeEntity firstChild) {
	this.firstChild = firstChild;
}

public GenericTreeEntity getNextSibbling() {
	return nextSibbling;
}

public void setNextSibbling(GenericTreeEntity nextSibbling) {
	this.nextSibbling = nextSibbling;
}

@Override
public String toString() {
	return "GenericTreeEntity [Data=" + Data + ", firstChild=" + firstChild + ", nextSibbling=" + nextSibbling + "]";
}




}
