package com.ds.al.node;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int m,data;
      LinkedListOperations os=new LinkedListOperationsImpl();
      LinkedListNode head=null;
      LinkedListNode node=null;
      LinkedListNode tail=null;
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter The Node Length");
      m=sc.nextInt();
      for(int i=0;i<m;i++) {
      System.out.println("Enter the data into the Nodes");
      data=sc.nextInt();
      head=os.AddNode(data, head);
      }
      System.out.println("Enter the positions from the end");
      data=sc.nextInt();
      //node=os.FindNthNode(data, head);
      tail=os.FindNthNodeFast(data, head);
     /* if(node!=null)
      System.out.println("Data at the node is "+node.getData());
      else
      System.out.println("node does not exist");*/
      sc.close();
      if(tail!=null)
          System.out.println("Data at the node is "+tail.getData());
          else
          System.out.println("node does not exist");
         
      
	}

}
