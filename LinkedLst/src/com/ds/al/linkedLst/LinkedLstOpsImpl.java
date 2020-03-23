package com.ds.al.linkedLst;

import java.util.HashMap;

public class LinkedLstOpsImpl implements LinkedLstOps {

	@Override
	public LinkedLstEntity AddNode(LinkedLstEntity head, int data) {
		// TODO Auto-generated method stub
		LinkedLstEntity root,node;
		if(head==null)
		{
			head=new LinkedLstEntity();
			head.setData(data);
			head.setNext(null);
			}
		else
		{
			root=head;
			while(root.getNext()!=null)
				root=root.getNext();
			
			node=new LinkedLstEntity();
			node.setData(data);
			node.setNext(null);
			root.setNext(node);
		}
		
		return head;
	}
	public LinkedLstEntity FindCommonNode(LinkedLstEntity head1,LinkedLstEntity head2)
	{
		int index=0;
		HashMap<LinkedLstEntity,Integer> map=new HashMap<LinkedLstEntity, Integer>();
		for(LinkedLstEntity i=head1;i!=null;i=i.getNext())
		{
			index++;
			map.put(i,index);
		}
		for(LinkedLstEntity j=head2;j!=null;j=j.getNext())
		{
			if(map.containsKey(j))
			{
				return j;
			}
		}
		return null;
	}

}
