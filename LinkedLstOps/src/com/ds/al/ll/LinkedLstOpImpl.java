package com.ds.al.ll;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedLstOpImpl implements LinkedLstOp {

	@Override
	public LinkedLst AddNode(LinkedLst head, int data) {
		// TODO Auto-generated method stub
		LinkedLst root,newnode;
		if(head==null)
		{
			head=new LinkedLst();
			head.setData(data);
			head.setNext(null);
				}
		else
		{
			root=head;
			while(root.getNext()!=null)
			  root=root.getNext();
			newnode=new LinkedLst();
			newnode.setData(data);
			newnode.setNext(null);
			root.setNext(newnode);
	
	
	 		
		}
		return head;
	}

	@Override
	public LinkedLst ReverseNode(LinkedLst head,int blocksize) {
		// TODO Auto-generated method stub
		int i=1;
		LinkedLst root=head,prev=null,slow,fast,nxt,nodenxt,blocknode=null;
		while(root!=null)
		{
		if(i%blocksize==1)
		prev=root;
		root=root.getNext();
		i++;
		 if(i%blocksize==0 && root!=null)
		 {
			slow=prev;
			fast=root.getNext();	
			nodenxt=fast;
			
		    while(slow!=nodenxt && slow!=null)
		    	
		    {
		    	nxt=slow.getNext();
		    	slow.setNext(fast);
		        fast=slow;
		    	slow=nxt;
		    }
		    
		    if(i == blocksize)
		       head=fast;
		    else
		    blocknode.setNext(root);
		    root=slow;
		    i++;
		   blocknode=prev;
		   
		 }
		}
		
		return head;
	}
	public LinkedLst ReorderList(LinkedLst head)
	{
	
		LinkedLst fast,slow,start=head;
	     slow=fast=head;
	     Queue<LinkedLst> queue=new LinkedList<>();
	     while(fast!=null&&fast.getNext()!=null)
	     {
	    	 queue.add(slow);
	    	 fast=fast.getNext();
	    	 slow=slow.getNext();
	    	
	    	 if(fast!=null)
	    	 {
	    		 
	             		 
	    		 fast=fast.getNext();
	    	 }
	    	 
	     }
	      
	     Stack<LinkedLst> stack=new Stack<LinkedLst>();
	    
	     for(LinkedLst i=slow;i!=null;i=i.getNext())
	    	 stack.push(i);
	     head=queue.remove();
	     head.getData();
	     start=stack.pop();
	     start.getData();
	     head.setNext(start);
	    while(!queue.isEmpty()||!stack.isEmpty())
	    {
	    	start.getData();
	      if(queue.peek()!=null)
	      {
	      start.setNext(queue.remove());
	      start=start.getNext();
	      }
	      if(stack.peek()!=null)
	      {
	    	  start.setNext(stack.pop());
	    	  start=start.getNext();
	      }
	    	start.setNext(null);  
	    }
	     
	     
	     //System.out.println("Data in the middle is "+slow.getData());
	     
	     
		return head;
	}
           

}
