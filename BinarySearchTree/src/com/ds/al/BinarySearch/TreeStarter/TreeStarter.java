package com.ds.al.BinarySearch.TreeStarter;

import java.util.Scanner;

import com.ds.al.BinarySearch.TreeEntity.BinarySearchTreeEntity;
import com.ds.al.BinarySearch.TreeOps.TreeOps;
import com.ds.al.BinarySearch.TreeOps.TreeOpsImpl;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of BST one");
		size = sc.nextInt();
		String bstString = "";
		System.out.println("Enter data for BST one");
		for (int i = 0; i < size; i++)
			bstString = bstString + sc.next() + ",";
		String[] bstnodes = bstString.split(",");
		TreeOps operation = new TreeOpsImpl();
		try {
			operation.createLinkedBinarySearchTree(bstnodes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();

	}

}
