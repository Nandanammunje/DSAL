package com.ds.al.divcon.starter;

import java.util.Scanner;

import com.ds.al.divcon.ops.DivConOps;
import com.ds.al.divcon.ops.DivConOpsImpl;

public class DivConStarter {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size1,size2;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array");
		size1=sc.nextInt();
		System.out.println("Enter the size of the array");
		size2=sc.nextInt();
		int arr1[]=new int[size1];
		int arr2[]=new int[size2];
		System.out.println("Enter sorted data into the array");
		for(int i=0;i<size1;i++)
		{
			arr1[i]=sc.nextInt();
		}
		System.out.println("Enter sorted data into the array 2");
		for(int i=0;i<size2;i++)
		{
			arr2[i]=sc.nextInt();
		}
		DivConOps ops=new DivConOpsImpl();
		ops.getMedianOfSortedArrUnequalLen(arr1, arr2);
		sc.close();
	}

}
