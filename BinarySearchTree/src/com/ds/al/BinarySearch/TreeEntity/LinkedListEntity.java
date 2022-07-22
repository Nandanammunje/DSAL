package com.ds.al.BinarySearch.TreeEntity;



public class LinkedListEntity {

	private BinarySearchTreeEntity node;
	private LinkedListEntity next;
	
	public BinarySearchTreeEntity getNode() {
		return node;
	}
	public void setNode(BinarySearchTreeEntity node) {
		this.node = node;
	}
	

	public LinkedListEntity getNext() {
		return next;
	}
	public void setNext(LinkedListEntity next) {
		this.next = next;
	}
	
	public LinkedListEntity AddNode(LinkedListEntity head, BinarySearchTreeEntity Treenode) {
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
