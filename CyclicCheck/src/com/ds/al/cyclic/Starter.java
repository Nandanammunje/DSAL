package com.ds.al.cyclic;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Scanner sc=new Scanner(System.in);
           System.out.println(" Enter the length of the Node");
           int m=sc.nextInt();
           int data;
           LinkedLi head=null;
          
           LinkedOps op=new LinkedOpsImpl();
           for(int i=0;i<m;i++)
           {
        	   System.out.println(" Enter the data into the node");
        	   data=sc.nextInt();
        	   head=op.CircularNode(data, head);
           }
           System.out.println(op.CyclicDetector(head)); 
           System.out.println(op.CyclicFloydDetector(head));
           if(op.CyclicFloydDetector(head))
           {
        	   System.out.println(op.DetectCyclicNode(head).getData());      
        	   
           }
           sc.close();
	}

}
