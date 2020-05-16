package com.ds.al.queue;

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

	

	public void Enqueue(int data) {
		LinkedListEntity node = new LinkedListEntity();
		if (front == null) {
			front = node.AddNode(front, data);
			rear = front;
			
		}

		else
			rear = node.AddNode(front, data);
		
		length++;
	}
	public int Dequeue() throws Exception
	{
		int result;
		
		LinkedListEntity nxt;
		if(length!=0)
		{
			result=front.getData();
	         nxt=front.getNext();
	         front=null;
	         front=nxt;
	         length--;
	         return result;
		}
		else
		throw new Exception("queue empty");
	
	}
	public int getFirst() throws Exception
	{
		if(length!=0)
		{
			return front.getData();
		}
		else
		throw new Exception("queue empty");	
	}
}