package com.ds.al.starter;

import java.util.List;
import java.util.Scanner;

import com.ds.al.Op.LinkedLstOp;
import com.ds.al.Op.LinkedLstOpImpl;
import com.ds.al.entity.LinkedLstEntity;

public class Starter {

	public static void main(String[] args) {
     		// TODO Auto-generated method stub
           int data,m;
          
           LinkedLstEntity head=null,start=null,end=null;
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
          
       List<LinkedLstEntity> list=op.SplitNode(head, start, end);
        head=list.get(0);
        start=list.get(1);
        //op.CheckPallindrome(head, start);
      
        System.out.println(op.CheckPallindrome(head, start));
        
        
           sc.close();
	}

}
