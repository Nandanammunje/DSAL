package com.ds.al.Generic.TreeOps;

import java.util.HashMap;
import static java.lang.Math.log;

import com.ds.al.Generic.TreeEntity.GenericTreeEntity;

public class TreeOpsImpl implements TreeOps {

	private int index;

	private GenericTreeEntity root;

	private int headIndex;

	private String nodeSum;

	private HashMap<Integer, Integer> depthMap;

	private int minDepth;

	private boolean isIsomorphic;

	private double treeHeight;

	public void createTreeGeneric(GenericTreeEntity root, GenericTreeEntity head, int Index, String preOrderString,
			String inorderString, String inorderSubStr) {
		if (Index >= preOrderString.length() || inorderSubStr == null | inorderSubStr.isEmpty()) {
			return;
		}
		boolean isChild;
		String node = Character.toString(preOrderString.charAt(Index));
		int nodeIndex = inorderString.indexOf(node);
		index++;
		if (nodeIndex > headIndex)
			isChild = false;
		else
			isChild = true;
		head = createTreeNode(head, node, isChild);
		headIndex = nodeIndex;
		String siblingStr = "";
		String childStr = "";
		int splitIndex = inorderSubStr.indexOf(node);
		if (splitIndex < inorderSubStr.length()) {

			childStr = inorderSubStr.substring(0, splitIndex);
			siblingStr = inorderSubStr.substring(splitIndex + 1, inorderSubStr.length());
		}

		createTreeGeneric(this.root, head, index, preOrderString, inorderString, childStr);
		createTreeGeneric(this.root, head, index, preOrderString, inorderString, siblingStr);

	}

	public GenericTreeEntity createTreeNode(GenericTreeEntity head, String nodeData, boolean isChild) {

		if (head == null) {

			head = new GenericTreeEntity();
			head.setData(nodeData);
			head.setFirstChild(null);
			head.setNextSibbling(null);
			this.root = head;
			return head;
		} else {
			GenericTreeEntity node = new GenericTreeEntity();
			node.setData(nodeData);
			if (isChild)
				head.setFirstChild(node);
			else
				head.setNextSibbling(node);

			head = node;
		}
		return head;

	}

	@Override
	public GenericTreeEntity mkGenericTree(String preOrderString, String inorderString) {
		// TODO Auto-generated method stub
		createTreeGeneric(null, null, 0, preOrderString, inorderString, inorderString);
		return this.root;

	}

	@Override
	public void TreeTraversal(GenericTreeEntity root) {
		// TODO Auto-generated method stub
		if (root != null) {
			TreeTraversal(root.getFirstChild());
			System.out.println(" " + root.getData());
			TreeTraversal(root.getNextSibbling());

		}

	}

	public void TreeSum(GenericTreeEntity root) {

		if (root != null) {
			TreeSum(root.getFirstChild());
			nodeSum = nodeSum + root.getData();
			TreeSum(root.getNextSibbling());

		}
	}

	@Override
	public String getNodeSum(GenericTreeEntity root) {
		// TODO Auto-generated method stub
		nodeSum = "";
		TreeSum(root);
		return nodeSum;
	}

	public void getMinDepth(int parent[], int node, int index, int depth) {

		if (parent[index] == -1 || depthMap.containsKey(parent[index])) {
			depth = depth + depthMap.getOrDefault(parent[index], 0);
			if (depth > minDepth)
				minDepth = depth;
			depthMap.put(node, depth + 1);
			return;

		} else {
			depth++;
			getMinDepth(parent, node, parent[index], depth);
		}

	}

	@Override
	public int getDepth(int[] parentArr) {
		// TODO Auto-generated method stub
		depthMap = new HashMap<Integer, Integer>();
		minDepth = -1;
		for (int i = 0; i < parentArr.length; i++) {
			getMinDepth(parentArr, i, i, 0);
		}
		return minDepth;
	}

	public void checkIsomorphic(GenericTreeEntity root1, GenericTreeEntity root2) {

		if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			isIsomorphic = false;
			return;
		}
		if (root1 != null && root2 != null) {
			checkIsomorphic(root1.getFirstChild(), root2.getFirstChild());
			checkIsomorphic(root1.getNextSibbling(), root2.getNextSibbling());
		}
	}

	@Override
	public boolean isIsomorphic(GenericTreeEntity root1, GenericTreeEntity root2) {
		// TODO Auto-generated method stub
		isIsomorphic = true;
		checkIsomorphic(root1, root2);
		return isIsomorphic;
	}

	public void getCompleteTreeHeight(int treeNodes, int knumber) {

		int number = (treeNodes*(knumber-1)) + 1;
		treeHeight = customLogBase(number, knumber)-1;
	}

	public double customLogBase(int number, int base) {

		return log(number) / log(base);

	}

	public void genericTreeListIterator(String[] nodeString, int kNumber, GenericTreeEntity head, int childHeight,
			int siblingCount, boolean isChild) {

		if (this.index >= nodeString.length || head == null) {
			return;
		}

		if (childHeight < treeHeight && isChild) {

			childHeight++;
			head = createTreeNode(head, nodeString[this.index], isChild);
			this.index++;
			siblingCount = 0;

		} else if (siblingCount < kNumber - 1 && !isChild) {
			siblingCount++;
			head = createTreeNode(head, nodeString[this.index], isChild);
			this.index++;

		} else {
			return;
		}
         genericTreeListIterator(nodeString, kNumber, head, childHeight, siblingCount,true);
         genericTreeListIterator(nodeString, kNumber, head, childHeight, siblingCount,false);
	}

	@Override
	public boolean isQuasiIsomorphic(GenericTreeEntity root1, GenericTreeEntity root2) {
		// TODO Auto-generated method stub
		if (root1 == null && root2 == null) {
			return true;
		}
		if ((root1 == null && root2 != null) || (root2 == null && root1 != null))

		{
			return false;
		}
		return (isQuasiIsomorphic(root1.getFirstChild(), root2.getFirstChild())
				&& isQuasiIsomorphic(root1.getNextSibbling(), root2.getNextSibbling())
				|| (isQuasiIsomorphic(root1.getFirstChild(), root2.getNextSibbling())
						&& isQuasiIsomorphic(root1.getNextSibbling(), root2.getFirstChild())));

	}

	@Override
	public GenericTreeEntity GenerateGenericTreePreorder(String[] nodeList, int kNumber) {
		// TODO Auto-generated method stub
		getCompleteTreeHeight(nodeList.length, kNumber);
		GenericTreeEntity root = new GenericTreeEntity();
		root.setData(nodeList[0]);
		index = 1;
		root.setFirstChild(null);
		root.setNextSibbling(null);
		genericTreeListIterator(nodeList,kNumber,root,0,0,true);
		return root;
	}

}
