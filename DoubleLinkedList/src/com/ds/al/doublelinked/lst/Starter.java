package com.ds.al.doublelinked.lst;

import java.util.Scanner;

public class Starter {

	
	public static void main(String[] args) {
				ListOpertaions io;
		io=new ListOperationsImpl();
	int m,data,pos;	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter no of nodes");
     m=sc.nextInt();
     StructuredList head;
     head=null;
   for(int i=0;i<m;i++)
   {
	   System.out.println("Enter data ino the node");
	   data=sc.nextInt();
	   head=io.AddNode(head, data);
   }
		for(StructuredList point=head;point!=null;point=point.getNext())
		{
			System.out.println(point.getData());
		}
		System.out.println("Enter the data");
		data=sc.nextInt();
		head=io.AddnodeatBeg(head, data);
		
		for(StructuredList point=head;point!=null;point=point.getNext())
		{
			System.out.println(point.getData());
		}
		System.out.println("Enter the data");
		data=sc.nextInt();
		
		io.AddnodeatEnd(head, data);
		for(StructuredList point=head;point!=null;point=point.getNext())
		{
			System.out.println(point.getData());
		}
		System.out.println("Enter the position");
		pos=sc.nextInt();
		System.out.println("Enter the data");		
		data=sc.nextInt();
		head=io.Addnodeatinter(head, data, pos);
		
		for(StructuredList point=head;point!=null;point=point.getNext())
		{
			System.out.println(point.getData());
		}
		head=io.DeleteBeg(head);
		System.out.println("After deletion 1");
		for(StructuredList point=head;point!=null;point=point.getNext())
		{
			System.out.println(point.getData());
		}
		System.out.println("After deletion 2");
		head=io.DeleteEnd(head);
		for(StructuredList point=head;point!=null;point=point.getNext())
		{
			System.out.println(point.getData());
		}
		System.out.println("Enter the position");
		pos=sc.nextInt();
		head=io.DeleteInter(head, pos);
		System.out.println("After deletion 3");
		for(StructuredList point=head;point!=null;point=point.getNext())
		{
			System.out.println(point.getData());
		}
		sc.close();
	}
}
