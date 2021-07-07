package com.ds.al.TreeStarter;

import java.util.Scanner;

import com.ds.al.TreeOps.TreeOps;
import com.ds.al.TreeOps.TreeOpsImpl;
import com.ds.al.tree.TreeEntity;

public class StartTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Tree ");
		size = sc.nextInt();
		String customPreOrderDataString = "";
		System.out.println("Enter the PreOrder Custom Sequence");
		for (int i = 0; i < size; i++) {

			customPreOrderDataString = customPreOrderDataString + sc.next() + "";

		}

		TreeOps op = new TreeOpsImpl();
		TreeEntity root = op.createTreeCustomPreorder(customPreOrderDataString);

		op.PreorderTraversal(root);
		System.out.println();
		op.InorderTravsersal(root);
		sc.close();
	}

}
