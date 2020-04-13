package com.ds.al.starter;

import java.util.Scanner;

import com.ds.al.Op.LinkedLstOp;
import com.ds.al.Op.LinkedLstOpImpl;
import com.ds.al.entity.LinkedLstEntity;

public class Starter {

	public static void main(String[] args) {
     		// TODO Auto-generated method stub
           int data,m;
           LinkedLstEntity head=null;
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter the size of the list");
           m=sc.nextInt();
           LinkedLstOp op=new LinkedLstOpImpl();
           for(int i=0;i<m;i++)
           {
        	   System.out.println("Enter the data into the nodes");
        	   data=sc.nextInt();
        	   head=op.AddNode(head, data);
        	   
           }
           LinkedLstEntity fast,slow;
           fast=slow=head;
        
           System.out.println(slow.getData());
           sc.close();
	}

}
