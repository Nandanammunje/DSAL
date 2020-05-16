package com.ds.al.queue;

public class StackEntity {
private LinkedListEntity head;
int length;

public StackEntity()
{
	head=null;
	length=0;
}
public void Push(int data)
{
	LinkedListEntity node=new LinkedListEntity();
	head=node.ReverseAddNode(head, data);
	length++;
	
}
public int Pop() throws Exception
{
	LinkedListEntity nxt;
	if(length!=0)
	{
		int result=head.getData();
		nxt=head.getNext();
		head=null;
		head=nxt;
		length--;
		return result;
	}
	else
		throw new Exception("Empty Stack");
}
public int Peek() throws Exception
{
	if(length!=0)
	{
		int result=head.getData();
		
		
		return result;
	}
	else
		throw new Exception("stack is empty");
}

}
