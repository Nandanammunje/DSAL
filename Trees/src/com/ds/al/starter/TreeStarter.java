package com.ds.al.starter;

import java.util.List;
import java.util.Scanner;

import com.ds.al.entity.TreeEntity;
import com.ds.al.traversal.TraversalOps;
import com.ds.al.traversal.TraversalOpsImpl;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size, data;
		TreeEntity root;
		TreeEntity entity = new TreeEntity();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the tree");
		size = sc.nextInt();

		for (int i = 0; i < size; i++) {
			System.out.println("Enter the data into tree ");
			data = sc.nextInt();
			entity.AddNode(data);
		}
		sc.close();
		root = entity.GetRoot();
		TraversalOps op = new TraversalOpsImpl();
		//op.PostorderTraversal(root);
		List<Integer> lst = op.PreorderTraversalIterative(root);
		for (Integer i : lst)
			System.out.println(i);

	}

}
