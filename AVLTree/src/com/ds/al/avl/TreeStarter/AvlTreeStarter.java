package com.ds.al.avl.TreeStarter;

import java.util.Scanner;

import com.ds.al.avl.TreeEntity.AvlTreeEntity;
import com.ds.al.avl.TreeOps.TreeOps;
import com.ds.al.avl.TreeOps.TreeOpsImpl;

public class AvlTreeStarter {

	public static void main(String args[]) {

		int size = 0, startRangeNumber = 0, endRangeNumber = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of AVL Tree");
		size = sc.nextInt();
		int avlArr[] = new int[size];
		System.out.println("Enter the elements into the AVL Tree");
		for (int i = 0; i < size; i++)
			avlArr[i] = sc.nextInt();
		TreeOps op = new TreeOpsImpl();
		AvlTreeEntity createdAVLTreeroot = op.createAVLTree(avlArr);
		System.out.println("Enter the start range number ");
		startRangeNumber = sc.nextInt();
		System.out.println("Enter the end range number");
		endRangeNumber = sc.nextInt();
		op.countNodesinRange(startRangeNumber, endRangeNumber, createdAVLTreeroot);

		sc.close();

	}

}
