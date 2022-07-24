package com.ds.al.BinarySearch.TreeEntity;



public class LinkedListEntity {

	private LinkedBinarySearchTree node;
	private LinkedListEntity next;
	
	public LinkedBinarySearchTree getNode() {
		return node;
	}
	public void setNode(LinkedBinarySearchTree node) {
		this.node = node;
	}
	

	public LinkedListEntity getNext() {
		return next;
	}
	public void setNext(LinkedListEntity next) {
		this.next = next;
	}
	
	public LinkedListEntity AddNode(LinkedListEntity head, LinkedBinarySearchTree Treenode) {
		// TODO Auto-generated method stub
		LinkedListEntity root,node;
		
		if(head==null)
		{
			head=new LinkedListEntity();
			head.setNode(Treenode);
			head.setNext(null);
			
		}
		else
		{
			root=head;
			while(root.getNext()!=null)
				root=root.getNext();
			node=new LinkedListEntity();
			node.setNext(null);
			node.setNode(Treenode);
			root.setNext(node);
			return root;
		}
		return head;
	}
	
	
	
	
}
