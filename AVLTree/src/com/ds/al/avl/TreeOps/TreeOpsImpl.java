package com.ds.al.avl.TreeOps;

import com.ds.al.avl.TreeEntity.AvlTreeEntity;
import static com.ds.al.avl.Utility.TreeUtility.getMax;
public class TreeOpsImpl implements TreeOps {

	private int getNodeHeight(AvlTreeEntity node) {
		if (node == null)
			return 0;
		else
			return node.getHeight();
	}

	
	private int getHeightDiff(AvlTreeEntity node)
	
	{
		if(node==null)
			return 0;
		else
			return getNodeHeight(node.getLeft())-getNodeHeight(node.getRight());
		
		
	}
	
	public AvlTreeEntity rightRotate(AvlTreeEntity node)
	{
		AvlTreeEntity leftNode=node.getLeft();
		AvlTreeEntity rightNode=leftNode.getRight();
		node.setLeft(rightNode);
		leftNode.setRight(node);
		
		return leftNode;
		
		
		
	}

	public AvlTreeEntity insertIntoBST(AvlTreeEntity node, int data) {

		if (node == null) {
			node = new AvlTreeEntity();
			node.setData(data);
			return node;
		}
		if(data < node.getData())
        node.setLeft(insertIntoBST(node.getLeft(), data));
		else if(data >node.getData())
		node.setRight(insertIntoBST(node.getRight(), data));
		node.setHeight(getMax(getNodeHeight(node.getLeft()),getNodeHeight(node.getRight()))+1);
		int balanceFactor=getHeightDiff(node);
		if(balanceFactor > 1  && data < node.getData())
		{
			return rightRotate(node);
		}
			
		
		
		

		return node;
	}

	@Override
	public AvlTreeEntity createAVLTree(int[] avlArr) {
		// TODO Auto-generated method stub
		AvlTreeEntity root = null;
		for (Integer i : avlArr)
			root = insertIntoBST(root, i);

		return root;
	}

}
