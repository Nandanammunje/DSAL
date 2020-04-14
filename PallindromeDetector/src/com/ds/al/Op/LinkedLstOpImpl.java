package com.ds.al.Op;

import java.util.ArrayList;
import java.util.List;

import com.ds.al.entity.LinkedLstEntity;

public class LinkedLstOpImpl implements LinkedLstOp {

	@Override
	public LinkedLstEntity AddNode(LinkedLstEntity head, int data) {
		// TODO Auto-generated method stub
		LinkedLstEntity root,node;
		if(head==null)
		{
			head=new LinkedLstEntity();
			head.setData(data);
			head.setNext(null);
		}
		else
		{
			root=head;
			while(root.getNext()!=null)
			 root=root.getNext();
			node=new LinkedLstEntity();
			node.setData(data);
			node.setNext(null);
			root.setNext(node);
		        
			
		}
		return head;
	}
	
	public List<LinkedLstEntity> SplitNode(LinkedLstEntity head,LinkedLstEntity start,LinkedLstEntity end)
	{
		if(head==null)
			return null;
		List<LinkedLstEntity> param= new ArrayList<LinkedLstEntity>();
	   LinkedLstEntity slow,fast;
	   slow=fast=head;
	   while(fast!=null&&fast.getNext()!=null && fast.getNext().getNext()!=null)
	   {
		   slow=slow.getNext();
		   fast=fast.getNext().getNext();
	   }
	   end=slow.getNext();
	   param.add(head);
	   param.add(end);
	   slow.setNext(null);
	   return param;

	   
	}
	
	
	public LinkedLstEntity Reversenode(LinkedLstEntity head)
	{
		LinkedLstEntity nxt=null,prev=null,root=head;
		while(root!=null)
		{
			nxt=root.getNext();
			root.setNext(prev);
			prev=root;
			root=nxt;
		}
		return prev;
		
	}

	@Override
	public Boolean CheckPallindrome(LinkedLstEntity head1, LinkedLstEntity head2) {
		// TODO Auto-generated method stub
		LinkedLstEntity root;
		head2=Reversenode(head2);
		root=head2;
	     for(LinkedLstEntity i=head1;i!=null;i=i.getNext())
		   {
			
			if(root!=null &&i.getData()!=root.getData())
			{
				return false;
			}
			else
			{
				if(root!=null)
				root=root.getNext();
				else
				break;	
			}
		}
		return true;
		
	
	}

}
