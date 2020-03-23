package com.ds.al.doublelinked.lst;

public interface ListOpertaions {
  
	public StructuredList AddNode(StructuredList head,int data);
	public StructuredList AddnodeatBeg(StructuredList head,int data);
	public StructuredList AddnodeatEnd(StructuredList head,int data);
	public StructuredList Addnodeatinter(StructuredList head,int data,int pos);
	public StructuredList DeleteBeg(StructuredList head);
	public StructuredList DeleteEnd(StructuredList head);
	public StructuredList DeleteInter(StructuredList head,int pos);
}
