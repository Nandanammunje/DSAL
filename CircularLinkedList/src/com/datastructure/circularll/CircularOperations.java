package com.datastructure.circularll;

public class CircularOperations implements  ListOperations {

	@Override
	public CircularLinkedList addNode(CircularLinkedList head, int data) {
		// TODO Auto-generated method stub
		CircularLinkedList root,node;
		if(head==null)
		{
			head= new CircularLinkedList();
			head.setData(data);
			head.setNext(null);
		}
		else
		{
			root=head;
		while(root.getNext()!=null && root.getNext()!=head)
			root=root.getNext();
			node=new CircularLinkedList();
			node.setData(data);
			node.setNext(head);
			root.setNext(node);
			
			
		}
		return head;
	}

	@Override
	public void DisplayNode(CircularLinkedList head) {
		// TODO Auto-generated method stub
		CircularLinkedList root;
		root=head;
		do
		{
			System.out.println(root.getData());
			root=root.getNext();
		}
		while(root!=null && root!=head);
		
	}

	@Override
	public CircularLinkedList addNodeFront(CircularLinkedList head,int data) {
		// TODO Auto-generated method stub
		CircularLinkedList root,node;
		root=new CircularLinkedList();
		root.setData(data);
		root.setNext(head);
		node=head;
	    do
	    {
	    
	    	node=node.getNext();
	    	System.out.println(node.getData());
	    }while(node!=null && node!=head);
		node.setNext(root);
		
		head=root;
		return head;
	}

}
