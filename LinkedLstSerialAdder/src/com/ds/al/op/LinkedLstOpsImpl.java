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
	public LinkedLstEntity Reorderdigits(LinkedLstEntity head,int data)
	{
		LinkedLstEntity newnode;
		if(head==null)
		{
			head=new LinkedLstEntity();
			head.setData(data);
			head.setNext(null);
			}
		else
		{
			newnode=new LinkedLstEntity();
			newnode.setData(data);
			newnode.setNext(head);
			head=newnode;
			
		}
		return head;
		
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
 public int CompareNode(LinkedLstEntity first,LinkedLstEntity second)
 {
	 int firstlength=0,secondlength=0, flag=1;
	 for(LinkedLstEntity i=first;i!=null;i=i.getNext())
	    firstlength++;
	 for(LinkedLstEntity j=second;j!=null;j=j.getNext())
	 {
		 secondlength++;
		 if(firstlength < secondlength)
		 {
			 flag=-1;
			 break;
		 }
	 }
	 if(firstlength==secondlength)
	 {
		 flag=0;
	 }
	 return flag;
	 
 }
	@Override
	public LinkedLstEntity SerialAdd(LinkedLstEntity head1, LinkedLstEntity head2) {
		// TODO Auto-generated method stub
		int x=0,data=0;
		head1=ReverseNode(head1);
		head2=ReverseNode(head2);
		LinkedLstEntity newnode=null,point,secondpoint=head2;
		int flag=CompareNode(head1,head2);
		if(flag==-1)
	    point=head2;
	    else
	    point=head1;
	    while(point!=null)
	    {
	    	x=(secondpoint!=null)?secondpoint.getData():0;
	    	data=point.getData()+x+data;
	    	newnode=Reorderdigits(newnode, data%10);
	    	data=data/10;
	        point=point.getNext();
	    	if(secondpoint!=null)
	    	secondpoint=secondpoint.getNext();	
	    }
	    if(data>0)
	    newnode=Reorderdigits(newnode,1);	
		
		return newnode;
	}

}
