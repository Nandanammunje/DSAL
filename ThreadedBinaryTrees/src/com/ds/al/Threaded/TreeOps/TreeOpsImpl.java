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

	private ThreadedBinaryTreeEntity foundNodeAddress = null;

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

			if (root.getlTag() == 0) {
				root.setLeft(predessorNode.peek());
			}

			if (successorNode.peek() == root)
				successorNode.pop();

			if (root.getrTag() == 0) {

				root.setRight(successorNode.peek());
			}
			predessorNode.push(root);

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

	private void findNodeAddress(String node, ThreadedBinaryTreeEntity root) {
		if (root.getData().equalsIgnoreCase(node))
			foundNodeAddress = root;
		else if (root.getlTag() == 1)
			findNodeAddress(node, root.getLeft());
		if (root.getrTag() == 1)
			findNodeAddress(node, root.getRight());

	}

	@Override
	public ThreadedBinaryTreeEntity findInorderSuccessor(String node) {
		// TODO Auto-generated method stub
		findNodeAddress(node, this.root);
		ThreadedBinaryTreeEntity nodeAddress = this.foundNodeAddress;
		ThreadedBinaryTreeEntity nodePointer = null;
		if (nodeAddress != null) {
			if (nodeAddress.getrTag() == 0) {
				nodePointer = nodeAddress.getRight();
				return nodePointer;
			}

			nodePointer = nodeAddress.getRight();
			while (nodePointer.getlTag() != 0) {

				nodePointer = nodePointer.getLeft();
			}

		}
		return nodePointer;
	}

	@Override
	public ThreadedBinaryTreeEntity findPreorderSuccessor(String node) {
		// TODO Auto-generated method stub
		findInorderSuccessor(node);
		ThreadedBinaryTreeEntity nodeAddress = this.foundNodeAddress;
		if (nodeAddress.getlTag() == 1 || nodeAddress.getrTag() == 1) {
			return (nodeAddress.getlTag() == 1) ? nodeAddress.getLeft() : nodeAddress.getRight();

		} else {
			while (nodeAddress.getrTag() != 1) {
				nodeAddress = nodeAddress.getRight();
				if (nodeAddress == null)
					return null;

			}
		}

		return nodeAddress.getRight();
	}

	@Override
	public ThreadedBinaryTreeEntity InsertNode(String parentNode, String childNode) {
		// TODO Auto-generated method stub

		boolean isChildEExist = false;
		findNodeAddress(parentNode, root);
		ThreadedBinaryTreeEntity node = this.foundNodeAddress;
		if (node.getrTag() == 1)
			isChildEExist = true;
		ThreadedBinaryTreeEntity newChildNode = new ThreadedBinaryTreeEntity();
		newChildNode.setData(childNode);
		newChildNode.setlTag(0);
		newChildNode.setrTag(node.getrTag());
		newChildNode.setLeft(node);
		newChildNode.setRight(node.getRight());
		node.setRight(newChildNode);
		node.setrTag(1);
		if (isChildEExist) {

			ThreadedBinaryTreeEntity previousNode = newChildNode.getRight();
			while (previousNode.getlTag() == 1) {
				previousNode = previousNode.getLeft();
			}
			previousNode.setLeft(newChildNode);

		}
		return root;
	}

}
