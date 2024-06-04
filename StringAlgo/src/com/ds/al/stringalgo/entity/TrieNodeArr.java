package com.ds.al.stringalgo.entity;

public class TrieNodeArr {

	private TrieNodeArr rootNode;

	private boolean isWord;

	Node trieMap[]; 

	public TrieNodeArr() {
		if (rootNode == null) {
			rootNode = new TrieNodeArr();
			rootNode.trieMap = new Node[26];
			isWord=false;
		}
		// TODO Auto-generated constructor stub
	}

}
