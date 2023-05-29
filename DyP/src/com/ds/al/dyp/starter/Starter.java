package com.ds.al.dyp.starter;

import java.util.Scanner;

import com.ds.al.dyp.ops.DyOpsImpl;
import com.ds.al.dyp.ops.DypOps;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l1, l2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of char array 1");
		l1 = sc.nextInt();
        System.out.println("Enter the length of char array 2");
        l2=sc.nextInt();
        char seqOne[]=new char[l1];
        char seqTwo[]=new char[l2];
        System.out.println("Enter the char into sequence one");
        for(int i=0;i <l1;i++)
        seqOne[i]=sc.next().trim().charAt(0);
        System.out.println("Enter the char into sequence two");
        for(int i=0;i <l2;i++)
        seqTwo[i]=sc.next().trim().charAt(0);
        
        DypOps dyOps=new DyOpsImpl();
        dyOps.getLcs(seqOne, seqTwo);
         
        sc.close();
	}

}
