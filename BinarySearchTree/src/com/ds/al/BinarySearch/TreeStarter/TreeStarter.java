package com.ds.al.BinarySearch.TreeStarter;

import java.util.Scanner;

import com.ds.al.BinarySearch.TreeEntity.BinarySearchTreeEntity;
import com.ds.al.BinarySearch.TreeOps.TreeOps;
import com.ds.al.BinarySearch.TreeOps.TreeOpsImpl;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 0, lowRange = 0, highRange = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of BST one");
		size = sc.nextInt();
		String bstString = "";
		System.out.println("Enter data for BST one");
		for (int i = 0; i < size; i++)
			bstString = bstString + sc.next() + ",";
		String[] bstnodes = bstString.split(",");
		TreeOps operation = new TreeOpsImpl();
		BinarySearchTreeEntity root = operation.createBST(bstnodes);
		System.out.println("Enter the low range number");
		lowRange = sc.nextInt();
		System.out.println("Enter the high range number");
		highRange = sc.nextInt();
		BinarySearchTreeEntity prunedRoot = operation.pruneBST(root, lowRange, highRange);

		sc.close();

	}

}
