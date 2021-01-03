package com.ds.al.TreeOps;

import com.ds.al.tree.TreeEntity;

public class TreeOpsImpl implements TreeOps {

	private int headIndex;
	private TreeEntity root;

	
	private void getCreateTree(String inorderSubStr, String preOrderSequence, TreeEntity root, int index,TreeEntity head,String inOrderSequence) {
		// TODO Auto-generated method stub
		
		if (index > preOrderSequence.length() || inorderSubStr == null || inorderSubStr.isEmpty())
			return;
		boolean isLeft;
		String preOrderNode = Character.toString(preOrderSequence.charAt(index));
		int nodeIndex = inOrderSequence.indexOf(preOrderNode);
		if (nodeIndex > headIndex)
			isLeft = false;  
		else
			isLeft=true;
		head=createTreeNode(root,head, preOrderNode, isLeft);
		headIndex=nodeIndex;
		String leftSequence=inorderSubStr.substring(0,nodeIndex);
		String rightSequence="";
		if(nodeIndex+1<inorderSubStr.length())
		rightSequence=inorderSubStr.substring(nodeIndex+1,inorderSubStr.length());
		getCreateTree(leftSequence, preOrderSequence, this.root, ++index,head,inOrderSequence);
		getCreateTree(rightSequence, preOrderSequence, this.root, ++index,head,inOrderSequence);

	}

	private TreeEntity createTreeNode(TreeEntity root, TreeEntity head, String data, boolean isLeft) {
        if(root==null)
        {
        	root=new TreeEntity();
        	root.setData(Integer.parseInt(data));
        	root.setLeft(null);
        	root.setRight(null);
        	head=root;
        	this.root=root;
        	
        }
        else
        {
        	TreeEntity node=new TreeEntity();
        	node.setData(Integer.parseInt(data));
        	node.setLeft(null);
        	node.setRight(null);
        	if(isLeft)
        	head.setLeft(node);
        	else
        	head.setRight(node);
        	head=node;
        }
		return head;
	}

	
	@Override
	public TreeEntity getCreateTreeInorderPreorder(String inorderSequence, String preOrderSequence) {
		// TODO Auto-generated method stub
		getCreateTree(inorderSequence, preOrderSequence,null,0,null,inorderSequence);
		
		return this.root;
	}
	
}
