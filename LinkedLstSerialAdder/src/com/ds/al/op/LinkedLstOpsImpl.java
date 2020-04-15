package com.ds.al.op;

import com.ds.al.entity.LinkedLstEntity;

public class LinkedLstOpsImpl implements LinkedLstOps {

	@Override
	public LinkedLstEntity AddNode(LinkedLstEntity head, int data) {
		// TODO Auto-generated method stub
		
		LinkedLstEntity root=null,newnode=null;
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
			newnode=new LinkedLstEntity();
			newnode.setData(data);
			newnode.setNext(null);
			root.setNext(newnode);
			
		}
		
		return head ;
	}
	
	public LinkedLstEntity ReverseNode(LinkedLstEntity head)
	{
		LinkedLstEntity nxt=null,prev=null,root;
		root=head;
		
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
	public LinkedLstEntity SerialAdd(LinkedLstEntity head1, LinkedLstEntity head2) {
		// TODO Auto-generated method stub
		head1=ReverseNode(head1);
		head2=ReverseNode(head2);
		LinkedLstEntity newnode=null;
		int data=0;
		LinkedLstEntity i=head1,j=head2;
		while(i!=null && j!=null)
		{
           data=i.getData()+j.getData()+data;
           newnode=AddNode(newnode, data%10);
           data=data/10;
           i=i.getNext();
           j=j.getNext();
		}
		newnode=ReverseNode(newnode);
		return newnode;
	}

}
