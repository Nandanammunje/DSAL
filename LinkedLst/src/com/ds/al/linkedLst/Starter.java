package com.ds.al.linkedLst;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      LinkedLstEntity head=null,newhead=null;
      LinkedLstEntity root,root2;
      int data,m,size;
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the length of list 1");
      m=sc.nextInt();
      LinkedLstOps op=new LinkedLstOpsImpl();
       for(int i=0;i<m;i++)
       {
    	   System.out.println("Enter the data into the nodes");
    	   data=sc.nextInt();
    	   head=op.AddNode(head, data);
       }
       System.out.println("Enter the length of the list 2 ");
       size=sc.nextInt();
       for(int i=0;i<size;i++)
       {
    	   System.out.println("Enter the data into the nodes");
    	   data=sc.nextInt();
    	   newhead=op.AddNode(newhead, data);
       }
       root=newhead;
      while(root.getNext()!=null)
    	root=root.getNext();
      root2=head.getNext().getNext().getNext();
      root.setNext(root2);
     if(op.FindCommonNode(head, newhead)!=null) 
     System.out.println("The common node is"+op.FindCommonNode(head, newhead).getData());
       sc.close();
	}

}
