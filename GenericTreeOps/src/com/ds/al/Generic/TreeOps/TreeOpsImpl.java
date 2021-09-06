package com.ds.al.Generic.TreeOps;

import java.util.HashMap;

import com.ds.al.Generic.TreeEntity.GenericTreeEntity;

public class TreeOpsImpl implements TreeOps {

	private int index;

	private GenericTreeEntity root;

	private int headIndex;

	private String nodeSum;

	private HashMap<Integer, Integer> depthMap;

	private int minDepth;
	
	private boolean isIsomorphic;

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
			depth = depth + depthMap.getOrDefault(parent[index],0);
			if (depth > minDepth)
				minDepth = depth;
			depthMap.put(node, depth+1);
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
	
	
	public void checkIsomorphic(GenericTreeEntity root1,GenericTreeEntity root2)
	{
		
		if((root1==null&&root2!=null)||(root1!=null && root2==null))
		{
		   isIsomorphic=false;
		   return;	
		}
		if(root1!=null && root2!=null)
		{
		checkIsomorphic(root1.getFirstChild(), root2.getFirstChild());
		checkIsomorphic(root1.getNextSibbling(), root2.getNextSibbling());
		}
	}

	@Override
	public boolean isIsomorphic(GenericTreeEntity root1, GenericTreeEntity root2) {
		// TODO Auto-generated method stub
		isIsomorphic=true;
		checkIsomorphic(root1, root2);
		return isIsomorphic;
	}

}
