package com.ds.al.ll;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int m,data,nodesize;
           LinkedLst head=null;
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter the no of nodes");
           m=sc.nextInt();
           LinkedLstOp op=new LinkedLstOpImpl();
           for(int i=0;i<m;i++)
           {
        	   System.out.println("Enter the data into the nodes");
        	   data=sc.nextInt();
        	   head=op.AddNode(head, data);
           }
           System.out.println("Enter the block number");
           nodesize=sc.nextInt();
           head=op.ReverseNode(head,nodesize);
           
           for(LinkedLst i=head;i!=null;i=i.getNext())
        	   System.out.println(i.getData());
           sc.close();
	}

}
