package com.ds.al.BinarySearch.TreeStarter;

import java.util.Scanner;

import com.ds.al.BinarySearch.TreeOps.TreeOps;
import com.ds.al.BinarySearch.TreeOps.TreeOpsImpl;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of BST");
		size = sc.nextInt();
		String bstString = "";
		String bstNode = "";
		String bstNodeFirst="";
		String bstNodeSecond="";
		System.out.println("Enter data for BST");
		for (int i = 0; i < size; i++)
			bstString = bstString + sc.next() + "";
		TreeOps operation = new TreeOpsImpl();
		operation.createBST(bstString);
		System.out.println("Enter the first BST Node");
		bstNodeFirst=sc.next();
		System.out.println("Enter the second BST Node");
		bstNodeSecond=sc.next();
		operation.findShortestPath(bstNodeFirst, bstNodeSecond);
		/*
		 * System.out.println("Enter the node to search"); bstNode = sc.next();
		 * operation.findNode(bstNode);
		 */
		//operation.findMinimumNode();
		//operation.findMaximumNode();
		sc.close();

	}

}
