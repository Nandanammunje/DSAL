package com.ds.al.Threaded.TreeStarter;

import java.util.Scanner;

import com.ds.al.Threaded.TreeOps.TreeOps;
import com.ds.al.Threaded.TreeOps.TreeOpsImpl;

public class ThreadedStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the tree");
		size=sc.nextInt();
		System.out.println("Enter the pre-order sequence");
		String preOrderDataString = "";
		String inOrderDataString = "";
		for(int i=0;i<size;i++)
		{
			preOrderDataString = preOrderDataString + sc.next() + "";
			
		}
		System.out.println("Enter the in-order sequence");
		
		for(int i=0;i<size;i++)
		{
			inOrderDataString = inOrderDataString + sc.next() + "";
			
		}
		TreeOps ops=new TreeOpsImpl();
		ops.CreateThreadedBinary(inOrderDataString, preOrderDataString);
		

	}

}
