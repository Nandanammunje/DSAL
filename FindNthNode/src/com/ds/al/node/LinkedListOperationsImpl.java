package com.ds.al.node;

import java.util.HashMap;

public class LinkedListOperationsImpl implements LinkedListOperations {

	@Override
	public LinkedListNode AddNode(int data, LinkedListNode head) {
		// TODO Auto-generated method stub
        LinkedListNode root,node;
        if(head==null)
        {
        	head=new LinkedListNode();
        	head.setData(data);
        	head.setNext(null);
        }
        else
        { 
        	root=head;
        	while(root.getNext()!=null)
        	root=root.getNext();
        	node=new LinkedListNode();
        	node.setData(data);
        	node.setNext(null);
        	root.setNext(node);
      }
        
        
        return head;
	}

	@Override
	public LinkedListNode FindNthNode(int pos,LinkedListNode head) {
		// TODO Auto-generated method stub
		int i=0;
		LinkedListNode node=null;
		HashMap<Integer,LinkedListNode> map=new HashMap<>();
	     for(LinkedListNode root=head;root!=null;root=root.getNext())
	     {
	    	 i++;
	    	 map.put(i,root);
	    }
	   
	    node=map.get(i-pos+1);
	  
		return node;
	}

	@Override
	public LinkedListNode FindNthNodeFast(int pos, LinkedListNode head) {
       LinkedListNode slow,fast;
       slow=fast=head;
       int i=1;
      
      
       for(fast=head;fast!=null;fast=fast.getNext())
       {
    	   i++;
    	   if(pos==1 && fast.getNext()==null)
    		  return fast;
    	   if(i%pos==0)
    	   {
    		   slow=slow.getNext();
    	   }
    	   
       }
       
       if(i==pos+1)
      return head;
       else if(i<pos)
       return null;
       
				return slow;
	}

}
