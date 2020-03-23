package com.ds.al.LinkedLst;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             int m,data;
             LinkedLstEntity head=null;
             LinkedLstEntity prev=null;
             LinkedLstEntity point=null;
             LinkedLstOps op=new LinkedLstOpsImpl();
             Scanner sc=new Scanner(System.in);
             System.out.println("Enter the size of the node");
             m=sc.nextInt();
             for(int i=0;i<m;i++)
             {
            	 System.out.println("Enter the data into the node");
            	 data=sc.nextInt();
            	 head=op.AddNode(head, data);
             }
             point=head;
             head=LinkedLstOpsImpl.RecurseReverse(head, prev);
       
            // op.DispReverseNode(head);
           //  head=op.ReverseNode(head);
             for(LinkedLstEntity root=head;root!=null;root=root.getNext())
            	 System.out.println(root.getData());
             
             sc.close();
	}

}
