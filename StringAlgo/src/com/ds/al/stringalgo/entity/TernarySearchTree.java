package com.ds.al.stringalgo.entity;

public class TernarySearchTree<T> {

	private char data;

	private T obj;

	private TernarySearchTree leftLink;

	private TernarySearchTree rightLink;

	private TernarySearchTree midLink;

	private TernarySearchTree root;

	private boolean isFirstword;

	public TernarySearchTree() {

	}

	public TernarySearchTree getRoot() {
		return root;
	}

	public void setRoot(TernarySearchTree root) {
		this.root = root;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public TernarySearchTree getLeftLink() {
		return leftLink;
	}

	public void setLeftLink(TernarySearchTree leftLink) {
		this.leftLink = leftLink;
	}

	public TernarySearchTree getRightLink() {
		return rightLink;
	}

	public void setRightLink(TernarySearchTree rightLink) {
		this.rightLink = rightLink;
	}

	public TernarySearchTree getMidLink() {
		return midLink;
	}

	public void setMidLink(TernarySearchTree midLink) {
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
			root = new TernarySearchTree();
			root.setMidLink(null);
			root.setLeftLink(null);
			root.setRightLink(null);
			isFirstword = true;

		}

		TernarySearchTree treeNode = root;
		if (isFirstword)
			TraverseAddChar(treeNode, 0, treeNode, word, 0, val);
		else {
			TraverseAddChar(treeNode, 0, treeNode, word, 0, val);

		}

		isFirstword = false;
	}

	private void TraverseAddChar(TernarySearchTree treeNode, int index, TernarySearchTree parentNode, String word,
			int compare, T val) {

		if (index >= word.length()) {
			parentNode.setObj(val);
			return;
		}

		if (isFirstword) {
			if (treeNode == root && treeNode.getData() == '\u0000') {
				treeNode.setData(word.charAt(index));
				TraverseAddChar(treeNode.getMidLink(), index + 1, treeNode, word, 0, val);
			} else {
				if (treeNode == null) {
					treeNode = new TernarySearchTree();
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
					treeNode = new TernarySearchTree();
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

	public boolean containsWord(String txt) {
		boolean isExist = true;
		isExist = findTernaryNode(root, 0, txt);
		return isExist;
	}

	private boolean findTernaryNode(TernarySearchTree node, int index, String word) {
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

	private T findValFromKey(String key, TernarySearchTree node, int index) {
		T val = null;
		if (node != null && index < key.length()) {
			if (node.getData() == key.charAt(index)) {
				if (index == key.length() - 1)
					return (T) node.getObj();
				else
					val = findValFromKey(key, node.getMidLink(), index + 1);
			} else if (node.data > key.charAt(index))
				val = findValFromKey(key, node.getLeftLink(), index);
			else
				val = findValFromKey(key, node.getRightLink(), index);

		}

		return val;
	}

}
