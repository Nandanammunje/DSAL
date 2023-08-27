package com.ds.al.dyp.starter;

import java.util.Scanner;

import com.ds.al.dyp.ops.DyOpsImpl;
import com.ds.al.dyp.ops.DypOps;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l1, l2, cap;
		Scanner sc = new Scanner(System.in);
		/*
		 * System.out.println("Enter the length of char array 1"); l1 = sc.nextInt();
		 * System.out.println("Enter the length of char array 2"); l2=sc.nextInt(); char
		 * seqOne[]=new char[l1]; char seqTwo[]=new char[l2];
		 * System.out.println("Enter the char into sequence one"); for(int i=0;i
		 * <l1;i++) seqOne[i]=sc.next().trim().charAt(0);
		 * System.out.println("Enter the char into sequence two"); for(int i=0;i
		 * <l2;i++) seqTwo[i]=sc.next().trim().charAt(0);
		 */

		/*
		 * System.out.println("Enter the coins array length"); l1 = sc.nextInt(); int[]
		 * coinsArr = new int[l1]; System.out.println("Enter the coins"); for (int i =
		 * 0; i < l1; i++) { coinsArr[i] = sc.nextInt(); }
		 * System.out.println("Enter the amount"); cap = sc.nextInt(); DypOps dyOps =
		 * new DyOpsImpl(); dyOps.setDPArr(l1,cap, -1);
		 * 
		 * System.out.println("no of coins change " +
		 * dyOps.makeChangeDpMinMemoize(cap,0, coinsArr));
		 */
		/* dyOps.knapSackUnbounded(cap, wght, profit, wght.length-1); */
		/* dyOps.knapSackBinary(cap, wght, profit, 0); */

		/* dyOps.getLcs(seqOne, seqTwo); */

		System.out.println("Enter the length of the array ");
		l1 = sc.nextInt();
		int arr[] = new int[l1];
		System.out.println("Enter the input to array");
		for (int i = 0; i < l1; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the  subset sum");
		cap = sc.nextInt();

		DypOps ops = new DyOpsImpl();
		ops.setDPArr(l1,cap, 0);
		System.out.println("Count of subset sum is  " + ops.getCountOfSubset(arr, 0, cap));
		sc.close();
	}

}
