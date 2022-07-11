package com.ds.al.generic.TreeStarter;

import java.util.Scanner;

public class GenericTreeStarter {

	public static void Main(String args[]) {

		int size;
		String preOrderString = "";
		String inorderString = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the generic tree");
		size = sc.nextInt();

		System.out.println("Enter the pre order BT Sequence of generic tree");
		for (int i = 0; i < size; i++) {
			preOrderString = preOrderString + sc.next() + "";
		}
		System.out.println("Enter inorder BT Sequence of generic tree");
		for (int i = 0; i < size; i++) {
			inorderString = inorderString + sc.next() + "";
		}
		
	}

}
