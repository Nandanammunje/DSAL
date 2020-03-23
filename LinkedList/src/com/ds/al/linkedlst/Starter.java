package com.ds.al.linkedlst;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	System.out.println("Enter no of nodes");
    int m=sc.nextInt();
    ListNode head=null;
    ListNode root;
    ListNode prev = null;
    int data;
    for(int i=0;i<m;i++)
    {
    	System.out.println("Enter the data");
    	data=sc.nextInt();
        head=CreateLinkedLst.addnode(head, data);   	
    	}
     System.out.println("Enter data to new node at the begining");
     data=sc.nextInt();
     head=CreateLinkedLst.addbegining(head, data);
     for(ListNode tail=head;tail!=null;tail=tail.getNext())
     {
    
     	System.out.println(tail.getData());
     } 
     System.out.println(" Linked list after data removal");
     head=CreateLinkedLst.deletebegigning(head);
     for(ListNode tail=head;tail!=null;tail=tail.getNext())
     {
    
     	System.out.println(tail.getData());
     } 
     System.out.println("Enter the index of the node to be deleted");
     data=sc.nextInt();
     sc.close();
     head=CreateLinkedLst.deletenode(head,data);
     System.out.println(" Linked list after data removal");
     for(ListNode tail=head;tail!=null;tail=tail.getNext())
     {
    
     	System.out.println(tail.getData());
     } 
     
	}

}
