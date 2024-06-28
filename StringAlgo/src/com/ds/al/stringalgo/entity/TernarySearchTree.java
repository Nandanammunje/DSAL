package com.ds.al.stringalgo.entity;

import java.util.ArrayList;

public class TernarySearchTree<T> {

	private char data;

	private T obj;

	private TernarySearchTree<T> leftLink;

	private TernarySearchTree<T> rightLink;

	private TernarySearchTree<T> midLink;

	private TernarySearchTree<T> root;

	private boolean isFirstword;

	private boolean isEOW;

	private int counter = 0;

	private int maxWordLength;

	public TernarySearchTree() {
		isEOW = false;
	}

	public TernarySearchTree<T> getRoot() {
		return root;
	}

	private void setRoot(TernarySearchTree<T> root) {
		this.root = root;
	}

	public char getData() {
		return data;
	}

	private void setData(char data) {
		this.data = data;
	}

	public TernarySearchTree<T> getLeftLink() {
		return leftLink;
	}

	private void setLeftLink(TernarySearchTree<T> leftLink) {
		this.leftLink = leftLink;
	}

	public TernarySearchTree<T> getRightLink() {
		return rightLink;
	}

	private void setRightLink(TernarySearchTree<T> rightLink) {
		this.rightLink = rightLink;
	}

	public TernarySearchTree<T> getMidLink() {
		return midLink;
	}

	private void setMidLink(TernarySearchTree<T> midLink) {
		this.midLink = midLink;
	}

	public T getObj() {
		return obj;
	}

	private void setObj(T obj) {
		this.obj = obj;
	}

	public void addWord(String word, T val) {
		if (root == null) {
			root = new TernarySearchTree<T>();
			root.setMidLink(null);
			root.setLeftLink(null);
			root.setRightLink(null);
			isFirstword = true;

		}

		TernarySearchTree<T> treeNode = root;
		if (isFirstword)
			TraverseAddChar(treeNode, 0, treeNode, word, 0, val);
		else {
			TraverseAddChar(treeNode, 0, treeNode, word, 0, val);

		}

		isFirstword = false;
	}

	private void TraverseAddChar(TernarySearchTree<T> treeNode, int index, TernarySearchTree<T> parentNode, String word,
			int compare, T val) {

		if (index >= word.length()) {
			parentNode.setObj(val);
			parentNode.isEOW = true;
			return;
		}

		if (isFirstword) {
			if (treeNode == root && treeNode.getData() == '\u0000') {
				treeNode.setData(word.charAt(index));
				TraverseAddChar(treeNode.getMidLink(), index + 1, treeNode, word, 0, val);
			} else {
				if (treeNode == null) {
					treeNode = new TernarySearchTree<T>();
					treeNode.setData(word.charAt(index));
					parentNode.setMidLink(treeNode);
					TraverseAddChar(treeNode.getMidLink(), index + 1, treeNode, word, 0, val);
				}

			}

		} else {
			if (treeNode != null) {
				int diff = treeNode.getData() - word.charAt(index);
				if (diff == 0) {
					TraverseAddChar(treeNode.getMidLink(), index + 1, treeNode, word, diff, val);
				} else if (diff > 0)
					TraverseAddChar(treeNode.getLeftLink(), index, treeNode, word, -1, val);
				else
					TraverseAddChar(treeNode.getRightLink(), index, treeNode, word, 1, val);

			} else {
				if (treeNode == null) {
					treeNode = new TernarySearchTree<T>();
					treeNode.setData(word.charAt(index));
					if (compare == 0)
						parentNode.setMidLink(treeNode);
					else if (compare == 1)
						parentNode.setRightLink(treeNode);
					else
						parentNode.setLeftLink(treeNode);
					TraverseAddChar(treeNode.getMidLink(), index + 1, treeNode, word, 0, val);
				}

			}

		}

	}

	public boolean startsWithWord(String txt) {
		boolean isExist = true;
		isExist = findTernaryNode(root, 0, txt);
		return isExist;
	}

	private boolean findTernaryNode(TernarySearchTree<T> node, int index, String word) {
		boolean isExist = true;
		if (index >= word.length() && node == null)
			return true;
		else if (index < word.length() && node == null)
			return false;
		if (index < word.length()) {
			if (node.data == word.charAt(index))
				isExist = findTernaryNode(node.getMidLink(), index + 1, word);
			else if (node.data > word.charAt(index))
				isExist = findTernaryNode(node.getLeftLink(), index, word);
			else
				isExist = findTernaryNode(node.getRightLink(), index, word);
		}

		return isExist;
	}

	public T getValueFromKey(String key) {
		T value = null;
		value = findValFromKey(key, root, 0);
		return value;

	}

	private T findValFromKey(String key, TernarySearchTree<T> node, int index) {
		T val = null;
		if (node != null && index < key.length()) {
			if (node.getData() == key.charAt(index)) {
				if (index == key.length() - 1)
					return node.getObj();
				else
					val = findValFromKey(key, node.getMidLink(), index + 1);
			} else if (node.data > key.charAt(index))
				val = findValFromKey(key, node.getLeftLink(), index);
			else
				val = findValFromKey(key, node.getRightLink(), index);

		}

		return val;
	}

	public boolean containsKey(String key) {
		boolean isKeyPresent = false;

		isKeyPresent = findKey(root, key, 0);

		return isKeyPresent;

	}

	private boolean findKey(TernarySearchTree<T> node, String key, int index) {
		boolean isPresent = false;
		if (node != null && index < key.length()) {
			if (node.getData() == key.charAt(index)) {
				if (index == key.length() - 1 && node.isEOW)
					return true;
				else if (index < key.length())
					isPresent = findKey(node.getMidLink(), key, index + 1);
			} else if (node.data > key.charAt(index))
				isPresent = findKey(node.getLeftLink(), key, index);
			else
				isPresent = findKey(node.getRightLink(), key, index);

		}

		return isPresent;
	}

	public ArrayList<String> getAllWords() {
		ArrayList<String> wordLst = new ArrayList<String>();
		getWordLst(wordLst, root, "");
		return wordLst;
	}

	private void getWordLst(ArrayList<String> wordLst, TernarySearchTree<T> node, String Letter) {
		if (node == null)
			return;
		if (node.isEOW) {
			wordLst.add(counter, Letter + node.getData());
			counter++;
		}
		getWordLst(wordLst, node.getMidLink(), Letter + node.getData());
		getWordLst(wordLst, node.getRightLink(), Letter);
		getWordLst(wordLst, node.getLeftLink(), Letter);

	}

	public int getMaxWordLength() {
		maxWordLength = 0;
		getMaxWordLength(root, 0);
		return maxWordLength;
	}

	private void getMaxWordLength(TernarySearchTree<T> node, int counter) {
		if (node == null)
			return;
		if (node.isEOW && counter+1 > maxWordLength)
			maxWordLength = counter+1;

		getMaxWordLength(node.getMidLink(), counter + 1);
		getMaxWordLength(node.getRightLink(), counter);
		getMaxWordLength(node.getLeftLink(), counter);

	}
	
	
	
}
