package com.ds.al.avl.TreeStarter;

import java.util.Scanner;

import com.ds.al.avl.TreeOps.TreeOps;
import com.ds.al.avl.TreeOps.TreeOpsImpl;

public class AvlTreeStarter {

	public static void main(String args[]) {

		int size = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of AVL Tree");
		size = sc.nextInt();
		int avlArr[] = new int[size];
		System.out.println("Enter the elements into the AVL Tree");
		for (int i = 0; i < size; i++)
			avlArr[i] = sc.nextInt();
		TreeOps op = new TreeOpsImpl();
		op.createAVLTree(avlArr);

		sc.close();

	}

}
