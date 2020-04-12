package com.ds.al.ll;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int m,data,rotindex;
       LinkedListEntity head=null;
       LinkedLstOps linkedLstOps=new LinkedLstOpsImpl();
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the length of the list");
       m=sc.nextInt();
       
       for(int i=0;i<m;i++)
       {
    	   System.out.println("Enter the data into the list");
    	   data=sc.nextInt();
    	   head=linkedLstOps.AddNode(head, data);
       }
       
       System.out.println("Enter the rotation index");
       rotindex=sc.nextInt();
      head=linkedLstOps.RotatedList(head, rotindex); 
       sc.close();
       for(LinkedListEntity i=head;i!=null;i=i.getNext())
       {
    	  System.out.println(i.getData());
       }
	}

}
