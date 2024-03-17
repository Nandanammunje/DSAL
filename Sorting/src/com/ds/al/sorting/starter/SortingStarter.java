package com.ds.al.sorting.starter;

import java.util.Scanner;

import com.ds.al.sorting.Ops.SortingOps;
import com.ds.al.sorting.Ops.SortingOpsImpl;

public class SortingStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arrSize;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the  array size");
		arrSize = sc.nextInt();
		int inputArr[] = new int[arrSize];
		System.out.println("Enter the array elements");
		for (int i = 0; i < arrSize; i++) {
			inputArr[i] = sc.nextInt();

		}

		SortingOps ops = new SortingOpsImpl();
		ops.radixSort(inputArr);

		sc.close();

	}

}
