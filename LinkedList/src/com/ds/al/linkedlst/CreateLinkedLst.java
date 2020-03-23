package com.ds.al.linkedlst;

public class CreateLinkedLst {

	
	public static ListNode addnode(ListNode head,int data)
	{
		ListNode root,tail;
		if(head==null)
    	{
    		head=new ListNode();
    		head.setData(data);
    		head.setNext(null);
    	
    		root=head;
    	}
		
			else
	    	{ 
				tail=head;
				while(tail.getNext()!=null)
					tail=tail.getNext();
			    root=new ListNode();
	    		root.setData(data);
	    		root.setNext(null);
	    		tail.setNext(root);
	    		
			
	    	}
		return head;
	}
	public static ListNode addbegining(ListNode head,int data)
	{
		ListNode root;
		root=new ListNode();
		root.setData(data);
		root.setNext(head);
		head=root;
		
		
		
		return head;
		
	}
	public static ListNode deletebegigning(ListNode head)
	{
		ListNode root;
		root=head.getNext();
		head=null;
		head=root;
		return head;
	}
	public static ListNode deletenode(ListNode head,int num)
	{
		int i=1;
		ListNode root,nxt,prev;
		for(root=head;root!=null;root=root.getNext())
		{
		i++;
		if(i==num)
		{
			nxt=root.getNext().getNext();
			prev=root.getNext();
			prev=null;
			root.setNext(nxt);
			break;
		}
		}
		return head;
	}
}
