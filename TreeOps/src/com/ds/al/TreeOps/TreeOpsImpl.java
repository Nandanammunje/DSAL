package com.ds.al.TreeOps;

import static com.ds.al.TreeUtility.StringUtility.StrReverse;
import static com.ds.al.constants.TreeConstants.NODESEPERATOR;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Integer.MAX_VALUE;

import java.util.TreeMap;

import com.ds.al.TreeUtility.QueueEntity;
import com.ds.al.tree.TreeEntity;

public class TreeOpsImpl implements TreeOps {

	private int headIndex;
	private TreeEntity root;
	private int currNodeIndex;
	private boolean found = false;
	private String AncestorNodes;
	private TreeMap<Integer, String> verticalSumMap;
	private int minDepth;

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

	public void getAncestorString(String treeNode, TreeEntity Node, String path) {
		// TODO Auto-generated method stub
		if (root == null || Node == null || found) {
			return;
		}
		if (treeNode.equals(Character.toString(Node.getData()))) {
			AncestorNodes = path;
			found = true;
			return;
		}
		path = path + Node.getData() + NODESEPERATOR;
		getAncestorString(treeNode, Node.getLeft(), path);
		getAncestorString(treeNode, Node.getRight(), path);
	}

	@Override
	public String[] getAncestors(String treeNode) {
		// TODO Auto-generated method stub
		String path = "";
		found = false;
		AncestorNodes = "";
		String nodes[] = null;
		getAncestorString(treeNode, root, path);
		if (AncestorNodes != null && !AncestorNodes.isEmpty()) {
			nodes = AncestorNodes.split(",");
		}

		return nodes;
	}

	@Override
	public String getLCA(String treeNode1, String treeNode2) {
		// TODO Auto-generated method stub
		String lcaNode = null;
		String ancestralNodes1[] = getAncestors(treeNode1);
		String ancestralNodes2[] = getAncestors(treeNode2);
		if (ancestralNodes1 != null && ancestralNodes2 != null && ancestralNodes1.length > 0
				&& ancestralNodes2.length > 0) {
			int commonPathLen = (ancestralNodes1.length > ancestralNodes2.length) ? ancestralNodes2.length
					: ancestralNodes1.length;
			for (int i = 0; i < commonPathLen; i++) {
				if (ancestralNodes1[i].equals(ancestralNodes2[i])) {
					lcaNode = ancestralNodes1[i];
				}
			}
		}

		return lcaNode;
	}

	public String zigZagTraversal() throws Exception {
		QueueEntity queue = new QueueEntity();
		queue.Enqueue(root);
		queue.Enqueue(null);
		TreeEntity treeNode;
		String zigZagStr = "";
		while (!queue.isEmpty()) {
			treeNode = queue.Dequeue();

			if (treeNode == null) {
				if (queue.getSize() < 1)
					break;
				queue.Enqueue(null);
				zigZagStr = zigZagStr + NODESEPERATOR;
			} else {
				zigZagStr = zigZagStr + treeNode.getData();
				if (treeNode.getLeft() != null)
					queue.Enqueue(treeNode.getLeft());
				if (treeNode.getRight() != null)
					queue.Enqueue(treeNode.getRight());
			}
		}
		return zigZagStr;
	}

	@Override
	public String getZigZagStr() throws Exception {

		String preZigZagStr = zigZagTraversal();
		String zigZagStr = "";
		if (preZigZagStr != null && !preZigZagStr.isEmpty() && !preZigZagStr.trim().isEmpty()) {
			String zigZagTraversal[] = preZigZagStr.split(NODESEPERATOR);
			zigZagStr = zigZagTraversal[0];
			for (int i = 1; i < zigZagTraversal.length; i++) {
				if (i % 2 == 1) {
					zigZagStr = zigZagStr + StrReverse(zigZagTraversal[i]);
				} else {
					zigZagStr = zigZagStr + zigZagTraversal[i];
				}
			}

		}

		return zigZagStr;

	}

	public void setVerticalSumMap(TreeEntity root, int colIndex) {
		String verticalSumString;
		if (root == null) {
			return;
		}
		if (verticalSumMap.containsKey(colIndex)) {
			verticalSumString = verticalSumMap.get(colIndex) + Character.toString(root.getData());
			verticalSumMap.put(colIndex, verticalSumString);
		} else {
			verticalSumMap.put(colIndex, Character.toString(root.getData()));
		}

		setVerticalSumMap(root.getLeft(), colIndex + 1);
		setVerticalSumMap(root.getRight(), colIndex - 1);

	}

	@Override
	public TreeMap<Integer, String> getVerticalSum() {
		// TODO Auto-generated method stub
		verticalSumMap = new TreeMap<Integer, String>();
		if (root != null) {

			setVerticalSumMap(root, 0);
		}

		return verticalSumMap;
	}

	public void setMinDepth(TreeEntity root, int depth) {

		if (root == null) {
			return;
		} else {

			if (root.getLeft() == null && root.getRight() == null) {
				if (minDepth > depth) {
					minDepth = depth;
				}
			}

			depth++;
			setMinDepth(root.getLeft(), depth);
			setMinDepth(root.getRight(), depth);
		}

	}

	@Override
	public int getMinDepthRecursive() {
		// TODO Auto-generated method stub
		minDepth = MAX_VALUE;
		setMinDepth(root, 0);
		return minDepth + 1;
	}

	@Override
	public int getMinDepthLevelOrder() {
		// TODO Auto-generated method stub
		int distance = 0;
		QueueEntity queue = new QueueEntity();
		queue.Enqueue(root);
		queue.Enqueue(null);
		try {
			while (!queue.isEmpty() && (queue.getSize() >1)) {

				TreeEntity node = queue.Dequeue();
				if (node != null) {

					if (node.getLeft() != null) {
						queue.Enqueue(node.getLeft());
					}
					if (node.getRight() != null) {
						queue.Enqueue(node.getRight());
					}

					if (node.getRight() == null && node.getLeft() == null) {
						break;
					}

				} else {
					if (node == null) {
                         distance++;
                         queue.Enqueue(null);
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return distance+1;
	}

	

}
