package com.ds.al.starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeStarter {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		List<Integer> PreorderList = new ArrayList<Integer>();
		List<Integer> InorderList=new ArrayList<Integer>();
		int data, length;
		System.out.println("Enter the size of the tree");
		length = sc.nextInt();
		for(int i=0;i<length;i++)
		{
		System.out.println("Enter the Preorder Traversal Data");
		data=sc.nextInt();
		PreorderList.add(data);
		}
		for(int i=0;i<length;i++)
		{
		System.out.println("Enter the Inorder Traversal Data");
		data=sc.nextInt();
	    InorderList.add(data);
		}
		
		sc.close();
	}

}
