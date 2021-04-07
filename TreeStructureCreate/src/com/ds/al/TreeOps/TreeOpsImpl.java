package com.ds.al.TreeOps;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.HashMap;

import com.ds.al.TreeUtility.DoubleLinkedLstEntity;
import com.ds.al.tree.TreeEntity;

public class TreeOpsImpl implements TreeOps {

	private int headIndex;
	private TreeEntity root;
	private int currNodeIndex;
	private HashMap<String, Integer> indexMap;
	private DoubleLinkedLstEntity queue;

	private void getCreateTree(String inorderSubStr, String preOrderSequence, TreeEntity root, int index,
			TreeEntity head, String inOrderSequence) {
		// TODO Auto-generated method stub

		if (index > preOrderSequence.length() || inorderSubStr == null || inorderSubStr.isEmpty())
			return;
		boolean isLeft;
		String preOrderNode = Character.toString(preOrderSequence.charAt(index));
		int nodeIndex = inOrderSequence.indexOf(preOrderNode);
		if (nodeIndex > headIndex)
			isLeft = FALSE;
		else
			isLeft = TRUE;
		head = createTreeNode(root, head, preOrderNode, isLeft);
		headIndex = nodeIndex;
		currNodeIndex++;
		String leftSequence = "";
		int splitIndex = inorderSubStr.indexOf(preOrderNode);
		if (splitIndex + 1 <= inorderSubStr.length())
			leftSequence = inorderSubStr.substring(0, splitIndex);
		String rightSequence = "";
		if (splitIndex + 1 < inorderSubStr.length())
			rightSequence = inorderSubStr.substring(splitIndex + 1, inorderSubStr.length());
		getCreateTree(leftSequence, preOrderSequence, this.root, currNodeIndex, head, inOrderSequence);
		getCreateTree(rightSequence, preOrderSequence, this.root, currNodeIndex, head, inOrderSequence);

	}

	private TreeEntity createTreeNode(TreeEntity root, TreeEntity head, String data, boolean isLeft) {
		if (root == null) {
			root = new TreeEntity();
			root.setData(data.charAt(0));
			root.setLeft(null);
			root.setRight(null);
			head = root;
			this.root = root;

		} else {
			TreeEntity node = new TreeEntity();
			node.setData(data.charAt(0));
			node.setLeft(null);
			node.setRight(null);
			if (isLeft)
				head.setLeft(node);
			else
				head.setRight(node);
			head = node;
		}
		return head;
	}

	@Override
	public TreeEntity getCreateTreeInorderPreorder(String inorderSequence, String preOrderSequence) {
		// TODO Auto-generated method stub
		getCreateTree(inorderSequence, preOrderSequence, null, 0, null, inorderSequence);

		return this.root;
	}

	public void mkTreeInorderPostorder(String inorderSub, String postOrderSeq, TreeEntity root, int index,
			TreeEntity head, String inorderSequence) {
		if (index > postOrderSeq.length() || inorderSub == null || inorderSub.isEmpty())
			return;
		String postOrderNode = Character.toString(postOrderSeq.charAt(index));
		boolean isLeft;
		int nodeIndex = inorderSequence.indexOf(postOrderNode);
		if (nodeIndex > headIndex)
			isLeft = FALSE;
		else
			isLeft = TRUE;
		head = createTreeNode(root, head, postOrderNode, isLeft);
		headIndex = nodeIndex;
		currNodeIndex++;
		String leftSequence = "";
		String rightSequence = "";
		int splitIndex = inorderSub.indexOf(postOrderNode);
		if (splitIndex < inorderSequence.length()) {
			leftSequence = inorderSub.substring(0, splitIndex);
			rightSequence = inorderSub.substring(splitIndex + 1, inorderSub.length());
		}
		mkTreeInorderPostorder(rightSequence, postOrderSeq, this.root, currNodeIndex, head, inorderSequence);
		mkTreeInorderPostorder(leftSequence, postOrderSeq, this.root, currNodeIndex, head, inorderSequence);

	}

	private String getHeadNode(String inorderSeq) {
		char temp[] = inorderSeq.toCharArray();
		indexMap.clear();
		for (int i = 0; i < temp.length; i++) {
			indexMap.put(Character.toString(temp[i]), i);
		}

		for (DoubleLinkedLstEntity tmp = queue.getHead(); tmp != null; tmp = tmp.getNxt()) {
			if (indexMap.containsKey(Character.toString(tmp.getData()))) {
				String headNode = Character.toString(tmp.getData());
				queue.removeNode(tmp);
				return headNode;
			}
		}

		return null;
	}

	@Override
	public TreeEntity getCreateTreeInorderPostorder(String inorderSequence, String postOrderSequence) {
		// TODO Auto-generated method stub
		mkTreeInorderPostorder(inorderSequence, postOrderSequence, null, 0, null, inorderSequence);
		return this.root;
	}

	// public void pushIndexMap(String LevelOrder)

	public void mkTreeInorderLevelOrder(String inorderSubstr, String levelOrderSequence, TreeEntity root, int index,
			TreeEntity head, String inorderSequence) {
		String leftSequence = "", rightSequence = "";
		int splitIndex;
		if (index > levelOrderSequence.length() || inorderSubstr == null || inorderSubstr.isEmpty())
			return;
		if (index == 0) {
			head = createTreeNode(null, null, Character.toString(queue.getHead().getData()), true);
			currNodeIndex++;
			splitIndex = inorderSubstr.indexOf(queue.getHead().getData());
			headIndex = splitIndex;
			if (splitIndex < inorderSubstr.length()) {
				leftSequence = inorderSubstr.substring(0, splitIndex);
				rightSequence = inorderSubstr.substring(splitIndex + 1, inorderSubstr.length());
			}
			mkTreeInorderLevelOrder(leftSequence, levelOrderSequence, this.root, currNodeIndex, head, inorderSequence);
			mkTreeInorderLevelOrder(rightSequence, levelOrderSequence, this.root, currNodeIndex, head, inorderSequence);

		} else {
			String levelorderNode = getHeadNode(inorderSubstr);
			currNodeIndex++;
			if (levelorderNode == null || levelorderNode.isEmpty())
				return;
			boolean isLeft;
			int nodeIndex = inorderSequence.indexOf(levelorderNode);
			if (nodeIndex > headIndex)
				isLeft = FALSE;
			else
				isLeft = TRUE;
			head = createTreeNode(root, head, levelorderNode, isLeft);
			if (nodeIndex < inorderSubstr.length()) {
				leftSequence = inorderSubstr.substring(0, nodeIndex);
				rightSequence = inorderSubstr.substring(nodeIndex + 1, inorderSubstr.length());
			}
			mkTreeInorderLevelOrder(leftSequence, levelOrderSequence, this.root, currNodeIndex, head, inorderSequence);
			mkTreeInorderLevelOrder(rightSequence, levelOrderSequence, this.root, currNodeIndex, head, inorderSequence);
		}
	}

	@Override
	public TreeEntity getCreateTreeInorderLevelorder(String inorderSequence, String levelOrderSequence) {
		// TODO Auto-generated method stub
		indexMap = new HashMap<String, Integer>();
		char levelOrderCharArr[] = levelOrderSequence.toCharArray();
		queue = new DoubleLinkedLstEntity();
		for (int i = 0; i < levelOrderCharArr.length; i++) {
			queue.addNode(levelOrderCharArr[i]);
		}

		return null;
	}

}
