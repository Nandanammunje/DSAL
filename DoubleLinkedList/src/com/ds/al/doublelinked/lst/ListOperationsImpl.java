package com.ds.al.doublelinked.lst;

public class ListOperationsImpl implements ListOpertaions {

	@Override
	public StructuredList AddNode(StructuredList head, int data) {
		// TODO Auto-generated method stub
		StructuredList root,tail;
		if(head==null)
		{
			head= new StructuredList();
			head.setData(data);
			head.setNext(null);
			head.setPrev(null);
			return head;
		}
		else
		{
			tail=head;
			while(tail.getNext()!=null)
			tail=tail.getNext();
		    root=new StructuredList();
		    root.setData(data);
		    root.setNext(null);
		    root.setPrev(tail);
		    tail.setNext(root); 
	}
  return head;
}

	@Override
	public StructuredList AddnodeatBeg(StructuredList head, int data) {
		// TODO Auto-generated method stub
		StructuredList tail;
		tail= new StructuredList();
		tail.setData(data);
		tail.setPrev(null);
		tail.setNext(head);
		head.setPrev(tail);
		head=tail;
		return head;
	}

	@Override
	public StructuredList AddnodeatEnd(StructuredList head, int data) {
		// TODO Auto-generated method stub
		StructuredList root,node;
		root=head;
		while(root.getNext()!=null)
			root=root.getNext();
		node=new StructuredList();
		node.setData(data);
		node.setNext(null);
		node.setPrev(root);
		root.setNext(node);
		return head;
	}

	@Override
	public StructuredList Addnodeatinter(StructuredList head, int data, int pos) {
		// TODO Auto-generated method stub
		StructuredList root,node;
		root=head;
		for(int i=0;i<pos-1;i++)
		{
			
			root=root.getNext();
			
		}
		
		node=new StructuredList();
		node.setData(data);
		node.setNext(root);
		
		node.setPrev(root.getPrev());
	    root.getPrev().setNext(node);
		root.setPrev(node);
		return head;
	}

	@Override
	public StructuredList DeleteBeg(StructuredList head) {
		// TODO Auto-generated method stub
		StructuredList root;
		root=head;
		root.getNext().setPrev(null);
	    head=root.getNext();
	    root=null;
		return head;
	}

	@Override
	public StructuredList DeleteEnd(StructuredList head) {
		// TODO Auto-generated method stub
		
	StructuredList root;
	root=head;
  while(root.getNext()!=null)
	  root=root.getNext();
      root.getPrev().setNext(null);
      root=null;
		return head;
		
		
	}

	@Override
	public StructuredList DeleteInter(StructuredList head, int pos) {
		// TODO Auto-generated method stub
		StructuredList root;
		root=head;
		for(int i=0;i<pos-1;i++)
		{
			root=root.getNext();
		}
          root.getPrev().setNext(root.getNext());
          root.getNext().setPrev(root.getPrev());
		    root=null;
		return head;
	}
}
