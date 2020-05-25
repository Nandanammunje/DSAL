package com.ds.al.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ds.al.entity.TreeEntity;

public class TraversalOpsImpl implements TraversalOps {

	@Override
	public void PreorderTraversal(TreeEntity root) {
		// TODO Auto-generated method stub
     if(root!=null)
     {
    	 System.out.println(root.getData());
    	 PreorderTraversal(root.getLeft());
    	 PreorderTraversal(root.getRight());
     }
     else
    	 return ;
	}

	@Override
	public void InorderTravsersal(TreeEntity root) {
		// TODO Auto-generated method stub
		if(root!=null)
		{
			InorderTravsersal(root.getLeft());
			System.out.println(root.getData());
		    InorderTravsersal(root.getRight());
		}
		else
			return ;
	}

	@Override
	public void PostorderTraversal(TreeEntity root) {
		// TODO Auto-generated method stub
		if(root!=null)
		{
		  PostorderTraversal(root.getLeft());
		  PostorderTraversal(root.getRight());
		  System.out.println(root.getData());
		}
	}

	@Override
	public List<Integer> PreorderTraversalIterative(TreeEntity root) {
		// TODO Auto-generated method stub
		List<Integer> PreorderList=new ArrayList<Integer>();
		Stack<TreeEntity> stck=new Stack<TreeEntity>();
		TreeEntity node;
		stck.add(root);
		while(!stck.empty())
		{
			node=stck.pop();
			if(node!=null)
			PreorderList.add(node.getData());
			if(node.getRight()!=null)
			stck.push(node.getRight());
			if(node.getLeft()!=null)
			stck.push(node.getLeft());
		}
		
		return PreorderList;
	}

	@Override
	public List<Integer> InorderTraversalIterative(TreeEntity root) {
		// TODO Auto-generated method stub
		Stack<TreeEntity> TreeStack=new Stack<TreeEntity>();

		boolean done=false;
		while(done)
		{
			if(root!=null)
			{
				TreeStack.add(root);
				root=root.getLeft();
			}
			else
			{
				
			}
		}
		return null;
	}

}
