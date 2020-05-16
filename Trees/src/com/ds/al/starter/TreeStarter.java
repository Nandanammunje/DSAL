package com.ds.al.starter;

import java.util.Scanner;

import com.ds.al.entity.TreeEntity;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size,data;
		TreeEntity root;
		TreeEntity entity=new TreeEntity();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the tree");
		size = sc.nextInt();
		
		for(int i=0;i<size;i++)
		{
		System.out.println("Enter the data into tree ");
		data=sc.nextInt();
		entity.AddNode(data);
		}
		root=entity.GetRoot();
		System.out.println("data of the root"+root.getData());
		System.out.println("data of the left node"+root.getLeft().getData());
		System.out.println("data of the right is"+root.getRight().getData());
		System.out.println("data of the left node "+root.getLeft().getLeft().getData());
		System.out.println("data of the left node"+ root.getLeft().getLeft().getLeft().getData());
		sc.close();

	}

}
