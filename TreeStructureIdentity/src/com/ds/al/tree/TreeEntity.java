package com.ds.al.tree;

import static java.lang.Boolean.TRUE;

import com.ds.al.constants.TreeConstants;


import static java.lang.Boolean.FALSE;

import static java.lang.Math.random;

public class TreeEntity {

	private TreeEntity Root;
	private int Data;
	private TreeEntity Left;
	private TreeEntity Right;

	
	
	public TreeEntity GetRootNode()
	{
		return Root;
	}
	
	public int getData() {
		return Data;
	}

	private void setData(int data) {
		Data = data;
	}

	public TreeEntity getLeft() {
		return Left;
	}

	public void setLeft(TreeEntity left) {
		Left = left;
	}

	public TreeEntity getRight() {
		return Right;
	}

	public void setRight(TreeEntity right) {
		Right = right;
	}

	public void AddNode(int data, String Type) {
		if (Root == null) {
			Root = new TreeEntity();
			Root.setData(data);
			Root.setLeft(null);
			Root.setRight(null);
		} else {

			if (Type.equalsIgnoreCase(TreeConstants.BST)) {
				CreateBST(data, Root, Root, TRUE);
			}
			else
			{
				CreateBT(data,Root,Root, TRUE);
			}

		}

	}

	private void CreateBST(int data,TreeEntity node,TreeEntity head,boolean right)
	{
		if(node!=null)
		{
			if(data > node.getData())
			{
				CreateBST(data,node.getRight(),node,TRUE);
			}
			else
			{
				CreateBST(data, node.getLeft(),node,FALSE);
			}
			
		}
		else
		{
			if(right)
			{
				
				node=new TreeEntity();
				node.setData(data);
				node.setLeft(null);
				node.setRight(null);
				head.setRight(node);
				return;
			}
			else
			{
				node=new TreeEntity();
				node.setData(data);
				node.setLeft(null);
				node.setRight(null);
				head.setLeft(node);
				return;
			}
		}
	}

	private void CreateBT(int data, TreeEntity head, TreeEntity node, boolean IsRight) {

		if (node != null) {

			if (random() * 10 > 4) {
				CreateBT(data, node, node.getRight(), TRUE);
			} else {
				CreateBT(data, head, node.getLeft(), FALSE);
			}

		} else {
			node = new TreeEntity();
			node.setData(data);
			node.setLeft(null);
			node.setRight(null);
			if (IsRight) {
				head.setRight(node);
			} else {
				head.setLeft(node);
			}
			return;
		}

	}

}
