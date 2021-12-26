package com.ds.al.Threaded.TreeEntity;

public class ThreadedBinaryTreeEntity {
	
	private ThreadedBinaryTreeEntity left;
	
	private int lTag;
	
	private String data;
	
	private int rTag;
	
	private ThreadedBinaryTreeEntity right;

	public ThreadedBinaryTreeEntity getLeft() {
		return left;
	}

	public void setLeft(ThreadedBinaryTreeEntity left) {
		this.left = left;
	}

	public int getlTag() {
		return lTag;
	}

	public void setlTag(int lTag) {
		this.lTag = lTag;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getrTag() {
		return rTag;
	}

	public void setrTag(int rTag) {
		this.rTag = rTag;
	}

	public ThreadedBinaryTreeEntity getRight() {
		return right;
	}

	public void setRight(ThreadedBinaryTreeEntity right) {
		this.right = right;
	}
	
	

}
