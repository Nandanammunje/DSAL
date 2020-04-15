package com.ds.al.starter;

import java.util.Scanner;

import com.ds.al.entity.LinkedLstEntity;
import com.ds.al.op.LinkedLstOps;
import com.ds.al.op.LinkedLstOpsImpl;

public class Starter {

	
	
	public static void main(String args[])
	{
		
		int m,data,n;
		LinkedLstEntity head1=null,head2=null,resultnode=null;
		LinkedLstOps op=new LinkedLstOpsImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the list");
		m=sc.nextInt();
		for(int i=0;i<m;i++)
		{
			System.out.println("Enter the data into the nodes");
			data=sc.nextInt();
			head1=op.AddNode(head1, data);
		}
		System.out.println("Enter the  size of the List");
		n=sc.nextInt();
	    for(int i=0;i<n;i++)
	    {
	    	System.out.println("Enter the data into the nodes");
	    	data=sc.nextInt();
	    	head2=op.AddNode(head2,data);
	    }
		resultnode=op.SerialAdd(head1, head2);
		for(LinkedLstEntity i=resultnode;i!=null;i=i.getNext())
			System.out.print(i.getData());
		sc.close();
		
	}
}
