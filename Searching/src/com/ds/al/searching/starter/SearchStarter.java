package com.ds.al.searching.starter;

import java.util.Scanner;

import com.ds.al.searching.ops.SearchingOps;
import com.ds.al.searching.ops.SearchingOpsImpl;

public class SearchStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size, arr[], searchElement;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		size = sc.nextInt();
		arr = new int[size];
		System.out.println("Enter the array elements");
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();

		SearchingOps ops = new SearchingOpsImpl();
		ops.findBitonicIndex(arr);
		sc.close();

		

	}

}
