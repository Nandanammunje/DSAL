package com.ds.al.queue;



public class LinkedListEntity {

	private int data;
	private LinkedListEntity next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedListEntity getNext() {
		return next;
	}
	public void setNext(LinkedListEntity next) {
		this.next = next;
	}
	
	public LinkedListEntity AddNode(LinkedListEntity head, int data) {
		// TODO Auto-generated method stub
		LinkedListEntity root,node;
		
		if(head==null)
		{
			head=new LinkedListEntity();
			head.setData(data);
			head.setNext(null);
			
		}
		else
		{
			root=head;
			while(root.getNext()!=null)
				root=root.getNext();
			node=new LinkedListEntity();
			node.setNext(null);
			node.setData(data);
			root.setNext(node);
			return root;
		}
		return head;
	}
	public LinkedListEntity ReverseAddNode(LinkedListEntity head,int data)
	{
		LinkedListEntity node;
		if(head==null)
		{
			head=new LinkedListEntity();
			head.setData(data);
			head.setNext(null);
		}
		else
		{
			node=new LinkedListEntity();
			node.setData(data);
			node.setNext(head);
			head=node;
		}
		return head;
	}
	
	
	
}
