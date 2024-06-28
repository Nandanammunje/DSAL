package com.ds.al.stringalgo.entity;

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

	public int[] getSuffixArr(String word) {
		suffxArrIndex = 0;
		suffArr = new int[word.length()];
		getSearchTree(word);
		
		return suffArr;

	}

	private TernarySearchTree<Integer> getSearchTree(String word) {
		TernarySearchTree<Integer> prefixTree = new TernarySearchTree<Integer>();

		for (int i =0; i<word.length(); i++) {
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
			
			suffArr[suffxArrIndex] = node.getObj();
			suffxArrIndex++;
		}
		LexicalOrderTraversal(node.getMidLink(), substr+node.getData());
		LexicalOrderTraversal(node.getRightLink(), substr);

	}

}
