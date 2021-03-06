package com.ds.al.ll;

public class LinkedOpsImpl implements LinkedLstOps {

	@Override
	public LinkedLst AddNode(LinkedLst head, int data) {
	LinkedLst root,node;
	
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
		node=new LinkedLst();
		node.setData(data);
		node.setNext(null);
    	root.setNext(node);
	}
		return head;
	}

	@Override
	public LinkedLst GetMedian(LinkedLst head) {
		// TODO Auto-generated method stub
		LinkedLst slow,fast;
		slow=fast=head;
		while(fast!=null && fast.getNext()!=null)
		{
			fast=fast.getNext();
			slow=slow.getNext();
			if(fast!=null&&fast.getNext()!=null)
			{
				fast=fast.getNext();
			}
		}
		if(fast!=null)
			System.out.println("check the node data "+fast.getData());
		return slow;
	}

	@Override
	public LinkedLst EvenOdd(LinkedLst head) {
		// TODO Auto-generated method stub
          LinkedLst slow,fast;
          slow=fast=head;
          while(fast!=null && fast.getNext()!=null)
          {
        	  fast=fast.getNext().getNext();
        	  slow=slow.getNext();
          }
          
        	  
		return fast;
	}

	@Override
	public LinkedLst SwapList(LinkedLst head) {
		// TODO Auto-generated method stub
		LinkedLst slownode=null,fastnode=null,fastnxt=null;
		slownode=head;
	    fastnode=slownode.getNext();
	    while(fastnode!=null)
	    {
	    	if(slownode==head)
	    	{
	    		fastnxt=fastnode.getNext();
	    		slownode.setNext(fastnxt);
	    		fastnode.setNext(slownode);
	    		head=fastnode;
	    		fastnode=fastnxt;
	    		}
	    	else
	    	{
	    	    fastnxt=fastnode.getNext();
	    		slownode.setNext(fastnxt);
	    		fastnode.setNext(fastnxt.getNext());
	    		fastnxt.setNext(fastnode);
	    		slownode=fastnode;
	    		fastnode=fastnode.getNext();
	    			    		
	    	}
	    }
			
		
		
		
		return head;
		
	}
	public static LinkedLst RecurseSwapList(LinkedLst head,LinkedLst fastnode,LinkedLst slownode)
	{
		LinkedLst fastnxt;
		if(head==null || fastnode==null)
		{
			return head;
		}
		if(slownode==head)
		{
			fastnxt=fastnode.getNext();
			slownode.setNext(fastnxt);
			fastnode.setNext(slownode);
			head=fastnode;
			fastnode=fastnxt;
		return	RecurseSwapList(head, fastnode, slownode);
		
		}
		else
		{
		fastnxt=fastnode.getNext();
 		slownode.setNext(fastnxt);
 		fastnode.setNext(fastnxt.getNext());
 		fastnxt.setNext(fastnode);
 		slownode=fastnode;
 		fastnode=fastnode.getNext();
 		return RecurseSwapList(head, fastnode, slownode);
	}
	}
}
