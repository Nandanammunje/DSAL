package com.ds.al.stringalgo.entity;

import java.util.HashMap;

public class TrieNode {

	private HashMap<Character, TrieNode> triNodeMap;

	private boolean isWord;

	private TrieNode rootNode;

	public TrieNode getRootNode() {
		return rootNode;
	}

	private TrieNode createNode() {
		TrieNode node = new TrieNode();
		node.triNodeMap = new HashMap<Character, TrieNode>();
		node.isWord = false;
		return node;
	}

	public void addWord(String word) {

		if (rootNode == null) {
			rootNode = new TrieNode();

			isWord = false;
			rootNode.triNodeMap = new HashMap<Character, TrieNode>();
		}

		TrieNode currentTrieNode = rootNode;
		for (int i = 0; i < word.length(); i++) {
			if (!currentTrieNode.triNodeMap.containsKey(word.charAt(i)))
				currentTrieNode.triNodeMap.put(word.charAt(i), createNode());

			currentTrieNode = currentTrieNode.triNodeMap.get(word.charAt(i));

		}
		currentTrieNode.isWord = true;

	}

	public boolean startsWith(String startStr) {
		boolean checkStartWith = true;
		TrieNode currNode = rootNode;
		for (int i = 0; i < startStr.length(); i++) {

			if (currNode.triNodeMap.containsKey(startStr.charAt(i))) {
                  currNode=currNode.triNodeMap.get(startStr.charAt(i));
			}
			else
			{
				checkStartWith=false;
				break;
			}

		}

		return checkStartWith;
	}

}
