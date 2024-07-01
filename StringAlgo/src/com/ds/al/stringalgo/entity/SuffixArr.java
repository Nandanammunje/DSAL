package com.ds.al.stringalgo.entity;

import static com.ds.al.stringalgo.utility.StringAlgoUtility.areCharactersSame;

public class SuffixArr {

	private int suffArr[];

	private String suffixStr[];

	private int suffxArrIndex;

	public int[] getSuffArr() {
		return suffArr;
	}

	public void setSuffArr(int[] suffArr) {
		this.suffArr = suffArr;
	}

	public String[] getSuffixStr() {
		return suffixStr;
	}

	public void setSuffixStr(String[] suffixStr) {
		this.suffixStr = suffixStr;
	}

	public String[] getSuffixArr(String word) {
		suffxArrIndex = 0;
		suffArr = new int[word.length()];
		suffixStr = new String[word.length()];

		getSearchTree(word);

		return suffixStr;

	}

	private TernarySearchTree<Integer> getSearchTree(String word) {
		TernarySearchTree<Integer> prefixTree = new TernarySearchTree<Integer>();

		for (int i = 0; i < word.length(); i++) {
			prefixTree.addWord(word.substring(i), i);
		}
		LexicalOrderTraversal(prefixTree.getRoot(), "");

		return prefixTree;
	}

	private void LexicalOrderTraversal(TernarySearchTree<Integer> node, String substr) {
		if (node == null)
			return;

		LexicalOrderTraversal(node.getLeftLink(), substr);
		if (node.getObj() != null) {
			suffixStr[suffxArrIndex] = substr + node.getData();
			suffArr[suffxArrIndex] = node.getObj();
			suffxArrIndex++;
		}
		LexicalOrderTraversal(node.getMidLink(), substr + node.getData());
		LexicalOrderTraversal(node.getRightLink(), substr);

	}

	public boolean isSubStringPresent(String word) {
		if (areCharactersSame(suffixStr[0], word) == -1
				|| areCharactersSame(suffixStr[suffixStr.length - 1], word) == 1) {
			return false;
		} else {
			return isSubStringPresent(0, suffixStr.length - 1, word);
		}

	}

	private boolean isSubStringPresent(int low, int high, String word) {
		if (low > high)
			return false;
		int mid = low + (high - low) / 2;
		int compareValue = areCharactersSame(suffixStr[mid], word);
		if (compareValue == 0)
			return true;
		else if (compareValue == 1)
			return isSubStringPresent(mid + 1, high, word);
		else
			return isSubStringPresent(low, mid - 1, word);

	}

}
