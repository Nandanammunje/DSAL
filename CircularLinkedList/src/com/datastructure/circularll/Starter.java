package com.datastructure.circularll;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int data ,m;
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the size of the nodes");
  m=sc.nextInt();
  CircularLinkedList head=null;
  ListOperations  op=new CircularOperations();
  for(int i=0;i<m;i++)
  {
	  System.out.println("Enter the data into the nodes");
	  data=sc.nextInt();
	 head=op.addNode(head, data);
  }
 op.DisplayNode(head);
 System.out.println("Enter the data");
 
 data=sc.nextInt();
 head=op.addNodeFront(head, data);
 op.DisplayNode(head);
	}

}
