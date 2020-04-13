package com.ds.al.Op;

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
	
	
	public static void SplitNode(LinkedLstEntity head,LinkedLstEntity start,LinkedLstEntity end)
	{
	   LinkedLstEntity slow,fast;
	   slow=fast=head;
	   while(fast!=null&&fast.getNext()!=null && fast.getNext().getNext()!=null)
	   {
		   slow=slow.getNext();
		   fast=fast.getNext().getNext();
	   }
	   end=slow.getNext();
	   start=head;
	   
	}

}
