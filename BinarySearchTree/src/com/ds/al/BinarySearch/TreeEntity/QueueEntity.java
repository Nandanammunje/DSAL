package com.ds.al.BinarySearch.TreeEntity;

public class QueueEntity {

	private LinkedListEntity front, rear;
	private int length;

	public QueueEntity() {
		length = 0;
		front = rear = null;
	}

	public int getLength() {
		return length;
	}

	

	public void Enqueue(BinarySearchTreeEntity TreeNode) {
		LinkedListEntity node = new LinkedListEntity();
		if (front == null) {
			front = node.AddNode(front,TreeNode);
			rear = front;
			
		}

		else
			rear = node.AddNode(front,TreeNode);
		
		length++;
	}
	public BinarySearchTreeEntity Dequeue() throws Exception
	{
		BinarySearchTreeEntity result;
		
		LinkedListEntity nxt;
		if(length!=0)
		{
			result=front.getNode();
	         nxt=front.getNext();
	         front=null;
	         front=nxt;
	         length--;
	         return result;
		}
		else
		throw new Exception("queue empty");
	
	}
	public BinarySearchTreeEntity getFirst() throws Exception
	{
		if(length!=0)
		{
			return front.getNode();
		}
		else
		throw new Exception("queue empty");	
	}
	public boolean IsEmpty()
	{
		if(length==0)
		{
			return true;
		}
		
		return false;
	}
}