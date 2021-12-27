package com.ds.al.Threaded.TreeOps;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.Stack;

import com.ds.al.Threaded.TreeEntity.ThreadedBinaryTreeEntity;

public class TreeOpsImpl implements TreeOps {

	private int headIndex;

	private ThreadedBinaryTreeEntity root;

	private Stack<ThreadedBinaryTreeEntity> successorNode;

	private Stack<ThreadedBinaryTreeEntity> predessorNode;

	private int currNodeIndex;

	private void mkBinaryTree(String inOrderSubstr, String preOrderSeq, ThreadedBinaryTreeEntity root, int index,
			ThreadedBinaryTreeEntity head, String inOrderSequence) {

		if (index > preOrderSeq.length() || inOrderSubstr == null || inOrderSubstr.isEmpty())
			return;
		boolean isLeft;
		String preOrderNode = Character.toString(preOrderSeq.charAt(index));
		int nodeIndex = inOrderSequence.indexOf(preOrderNode);
		if (nodeIndex > headIndex)
			isLeft = FALSE;
		else
			isLeft = TRUE;
		head = createTreeNode(root, head, preOrderNode, isLeft);
		headIndex = nodeIndex;
		currNodeIndex++;
		String leftSequence = "";
		int splitIndex = inOrderSubstr.indexOf(preOrderNode);
		if (splitIndex + 1 <= inOrderSubstr.length())
			leftSequence = inOrderSubstr.substring(0, splitIndex);
		String rightSequence = "";
		if (splitIndex + 1 < inOrderSubstr.length())
			rightSequence = inOrderSubstr.substring(splitIndex + 1, inOrderSubstr.length());
		mkBinaryTree(leftSequence, preOrderSeq, this.root, currNodeIndex, head, inOrderSequence);
		mkBinaryTree(rightSequence, preOrderSeq, this.root, currNodeIndex, head, inOrderSequence);

	}

	private ThreadedBinaryTreeEntity createTreeNode(ThreadedBinaryTreeEntity root, ThreadedBinaryTreeEntity head,
			String data, boolean isLeft) {
		if (root == null) {
			root = new ThreadedBinaryTreeEntity();
			root.setData(Character.toString(data.charAt(0)));
			root.setLeft(null);
			root.setRight(null);
			head = root;
			this.root = root;

		} else {
			ThreadedBinaryTreeEntity node = new ThreadedBinaryTreeEntity();
			node.setData(Character.toString(data.charAt(0)));
			node.setLeft(null);
			node.setRight(null);
			node.setlTag(0);
			node.setrTag(0);
			if (isLeft) {
				head.setLeft(node);
				head.setlTag(1);

			} else {

				head.setRight(node);
				head.setrTag(1);
			}
			head = node;
		}
		return head;
	}

	public void mkThreadedBinaryTree(ThreadedBinaryTreeEntity root) {
		if (root != null) {
			if (root.getlTag() == 1) {
				successorNode.push(root);
				mkThreadedBinaryTree(root.getLeft());
			}

			System.out.println(root.getData());
			if (root.getlTag() == 0) {
				root.setLeft(predessorNode.peek());
			}
			if (root.getrTag() == 0) {

				root.setRight(successorNode.peek());
			}
			predessorNode.push(root);
			if (successorNode.peek() == root)
				successorNode.pop();

			if (root.getrTag() == 1) {

				mkThreadedBinaryTree(root.getRight());

			}
		}
		return;
	}

	@Override
	public ThreadedBinaryTreeEntity CreateThreadedBinary(String inorderSeq, String preOrderSeq) {
		// TODO Auto-generated method stub

		mkBinaryTree(inorderSeq, preOrderSeq, root, currNodeIndex, root, inorderSeq);
		predessorNode = new Stack<ThreadedBinaryTreeEntity>();
		successorNode = new Stack<ThreadedBinaryTreeEntity>();
		predessorNode.push(null);
		successorNode.push(null);
		mkThreadedBinaryTree(root);

		return root;

	}

}
