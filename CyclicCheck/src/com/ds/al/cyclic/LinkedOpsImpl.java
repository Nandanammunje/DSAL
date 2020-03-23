package com.ds.al.cyclic;

import java.util.HashMap;



public class LinkedOpsImpl  implements LinkedOps{

	@Override
	public LinkedLi AddNode(int data, LinkedLi head) {
		LinkedLi root,tail;
		if(head==null)
    	{
    		head=new LinkedLi();
    		head.setData(data);
    		head.setNext(null);
    	
    		root=head;
    	}
		
			else
	    	{ 
				tail=head;
				while(tail.getNext()!=null)
					tail=tail.getNext();
			    root=new LinkedLi();
	    		root.setData(data);
	    		root.setNext(null);
	    		tail.setNext(root);
	    		
			
	    	}
		return head;	
		
		
	}
    public boolean CyclicDetector(LinkedLi head)
    {
    HashMap<LinkedLi,Integer> table=new HashMap<LinkedLi, Integer>();
    int index=0;
    for(LinkedLi root=head;root!=null;root=root.getNext())
    {
    	
    	if(table.containsKey(root))
    	{
    		return true;
    	}
    	else
    	{
    		index++;
    		table.put(root,index);
    	}
    }
		return false;
    	
    }
	@Override
	public LinkedLi CircularNode(int data, LinkedLi head) {
		// TODO Auto-generated method stub
		
		LinkedLi root,node;
		if(head==null)
		{
			head= new LinkedLi();
			head.setData(data);
			head.setNext(null);
		}
		else
		{
			root=head;
		while(root.getNext()!=null && root.getNext()!=head)
			root=root.getNext();
			node=new LinkedLi();
			node.setData(data);
			node.setNext(head);
			root.setNext(node);
			
			
		}
		return head;
	}
	@Override
	public boolean CyclicFloydDetector(LinkedLi head) {
		// TODO Auto-generated method stub
		LinkedLi fast,slow;
		fast=slow=head;
		while(fast!=null && fast.getNext()!=null)
		{
			fast=fast.getNext().getNext();
			slow=slow.getNext();
			if(fast==slow)
			{
			  return true;
			}
		}
		return false;
	}
	@Override
	public LinkedLi DetectCyclicNode(LinkedLi head) {
		// TODO Auto-generated method stub
		LinkedLi fast,slow;
		fast=slow=head;
		while(fast!=null && fast.getNext()!=null)
		{
			fast=fast.getNext().getNext();
			slow=slow.getNext();
			if(fast==slow)
			{
				break;
			}
		}
		slow=head;
		while(slow!=head)
		{
			slow=slow.getNext();
			fast=fast.getNext();
		}
		return fast;
	}
}
