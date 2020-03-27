package com.ds.al.ll;

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


}
