package com.ds.al.entity;
import static java.lang.Math.*;
public class TreeEntity {

	private int data;
	private TreeEntity Right;
	private TreeEntity Left;
	private TreeEntity RootNode;
	
	public TreeEntity()
	{
		
	}
	
	public int getData() {
		return data;
	}
	private void setData(int data) {
		this.data = data;
	}
	public TreeEntity getRight() {
		return Right;
	}
	private void setRight(TreeEntity right) {
		Right = right;
	}
	public TreeEntity getLeft() {
		return Left;
	}
	private void setLeft(TreeEntity left) {
		Left = left;
	}
	public void AddNode(int data)
	{
		
		if(RootNode==null)
		{
			RootNode=new TreeEntity();
			RootNode.setData(data);
			RootNode.setLeft(null);
			RootNode.setRight(null);
		
		}
		else
		{
			
			CreateRST(data, RootNode, RootNode, true);
			
					}
		
	}
	private void CreateRST(int data,TreeEntity node,TreeEntity head,boolean right)
	{
		if(node!=null)
		{
			
			if(random()*10 > 4)
			{
				CreateRST(data,node.getRight(),node,true);
			}
			else
			{
				CreateRST(data, node.getLeft(),node,false);
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
	
	public TreeEntity GetRoot()
	{
		if(RootNode!=null)
			return RootNode;
		else
		return null;
	}
	
	
}
