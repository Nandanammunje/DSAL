package com.ds.al.TreeStarter;

import java.util.Scanner;

import com.ds.al.TreeOps.TreeOps;
import com.ds.al.TreeOps.TreeOpsImpl;

public class StartTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Tree ");
		size = sc.nextInt();
		String preOrderDataString = "";
		String inOrderDataString = "";
		System.out.println("Enter the PreOrder Sequence");
		for (int i = 0; i < size; i++) {

			preOrderDataString = preOrderDataString + sc.next() + "";

		}
		System.out.println("Enter the Inorder Sequence");
		for (int i = 0; i < size; i++) {

			inOrderDataString = inOrderDataString + sc.next() + "";

		}
		TreeOps op = new TreeOpsImpl();
		op.getCreateTreeInorderPreorder(inOrderDataString, preOrderDataString);
		System.out.println("Enter the Node for Ancestral Path");
		String node = sc.next();
		String nodes[] = op.getAncestors(node);
		if (nodes != null && nodes.length > 0) {
			for (String itr : nodes)
				System.out.println("Nodes are " + itr);
		} else {
			System.out.println("No ancestral Nodes exist");
		}

		sc.close();
	}

}
