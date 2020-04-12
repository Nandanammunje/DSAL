package com.ds.al.ll;

import java.util.HashMap;

public class LinkedLstOpsImpl implements LinkedLstOps {

	@Override
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
		}
		return head;
	}

	@Override
	public LinkedListEntity RotatedList(LinkedListEntity head, int rotindex) {
		// TODO Auto-generated method stub
		LinkedListEntity node,prev = null;
		int index=0,length;
		length=GetListLength(head);
	
		int rotatedindex=0;
		HashMap<Integer, LinkedListEntity> map=new HashMap<>();
		for(LinkedListEntity i=head;i!=null;i=i.getNext())
		{
		rotatedindex=(index+rotindex)%length;
	
		map.put(rotatedindex,i);
		index++;
		}
		
		for(int i=0;i<length;i++)
		{
			node=map.get(i);
			
			if(i==0)
			{
				head=node;
				
			}
			else
			{
				prev.setNext(node);
			}
			prev=node;
		}
		prev.setNext(null);
		return head;
		
	}

	@Override
	public int GetListLength(LinkedListEntity head) {
		// TODO Auto-generated method stub
		int index=0;
		for(LinkedListEntity i=head;i!=null;i=i.getNext())
			index++;
		return index;
	}

}
