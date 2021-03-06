package com.ds.al.LinkedLst;

public class LinkedLstOpsImpl implements LinkedLstOps {

	@Override
	public LinkedLstEntity AddNode(LinkedLstEntity head,int data) {
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

	@Override
	public LinkedLstEntity ReverseNode(LinkedLstEntity head) {
	LinkedLstEntity tail=null,prev=null,pointer=head;
		while(pointer!=null)
		{
			tail=pointer.getNext();
			pointer.setNext(prev);
			prev=pointer;
			pointer=tail;
		}
		return prev;
	}
	public void DispReverseNode(LinkedLstEntity head)
	{
	     if(head.getNext()!=null)
	    DispReverseNode(head.getNext());
	      
	      System.out.println(head.getData());
	}
	public static LinkedLstEntity RecurseReverse(LinkedLstEntity head,LinkedLstEntity prev)
	{
	if(head==null)
	return prev;
	LinkedLstEntity root=head.getNext();
	head.setNext(prev);
	prev=head;
	head=root;
    return RecurseReverse(head, prev);	
	}

}
