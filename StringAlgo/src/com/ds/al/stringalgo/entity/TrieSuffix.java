package com.ds.al.stringalgo.entity;

import java.util.HashMap;

public class TrieSuffix {

	private TrieSuffix root;

	private HashMap<Character, TrieSuffix> suffixMap;

	private boolean isWord;

	public TrieSuffix getRoot() {
		return root;
	}

	public void setRoot(TrieSuffix root) {
		this.root = root;
	}

	private TrieSuffix createNode() {
		TrieSuffix node = new TrieSuffix();
		node.suffixMap = new HashMap<Character, TrieSuffix>();
		node.isWord = false;
		return node;
	}

	private void createTrie(String suffix) {
		if (root == null)
			root = createNode();

		TrieSuffix currNode = root;
		for (int i = 0; i < suffix.length(); i++) {
			char letter = suffix.charAt(i);
			if (!currNode.suffixMap.containsKey(letter))
				currNode.suffixMap.put(letter, createNode());
			currNode = currNode.suffixMap.get(letter);
		}
		currNode.isWord = true;

	}

	public void createSuffixTrie(String word) {
		for (int i = 0; i < word.length(); i++) {
			createTrie(word.substring(i));
		}

	}

	public boolean isSubstring(String substr) {
		boolean isSubstring = true;

		TrieSuffix currNode = root;
		for (int i = 0; i < substr.length(); i++) {
			if (!currNode.suffixMap.containsKey(substr.charAt(i))) {
				isSubstring = false;
				break;
			}
			currNode=currNode.suffixMap.get(substr.charAt(i));

		}

		return isSubstring;
	}

}
