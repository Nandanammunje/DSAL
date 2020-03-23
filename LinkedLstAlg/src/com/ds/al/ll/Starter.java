package com.ds.al.ll;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int m,data;
       LinkedLst head=null,median;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the size of the node");
       m=sc.nextInt();
       LinkedLstOps op=new LinkedOpsImpl();
       for(int i=0;i<m;i++)
       {
    	   System.out.println("Enter the data into the node");
    	   data=sc.nextInt();
    	   head=op.AddNode(head, data);
       }
       median=op.GetMedian(head);
       System.out.println("Median Node is "+median.getData());
     String status=(op.EvenOdd(head)!=null)?"Odd":"Even";
     System.out.println("The List is of "+status +" length");
       head=op.SwapList(head);
       for(LinkedLst i=head;i!=null;i=i.getNext())
       {
    	   System.out.println("Data In The Node Is "+i.getData());
       }
       sc.close();
	}

}
