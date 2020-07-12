package com.ds.al.starter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.ds.al.traversal.TraversalOps;
import com.ds.al.traversal.TraversalOpsImpl;
import com.ds.al.trees.TreeCreateHelper;
import com.ds.al.trees.TreeEntity;

public class TreeStarter {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		TreeCreateHelper help=new TreeCreateHelper();
		TreeEntity Tree=new TreeEntity();
		List<Integer> PreorderList = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<>();
		TraversalOps op=new TraversalOpsImpl();
		int data, length;
		System.out.println("Enter the size of the tree");
		length = sc.nextInt();
		for (int i = 0; i < length; i++) {
			System.out.println("Enter the Preorder Traversal Data");
			data = sc.nextInt();
			PreorderList.add(data);
		}

		for (int i = 0; i < length; i++) {
			System.out.println("Enter the Inorder Traversal Data");
			data = sc.nextInt();
			map.put(data, i);
		}
		sc.close();
		help.SetRankMap(map);
		
		for (Integer i : PreorderList) {
          Tree.AddNode(i);
		}
     System.out.println("Inorder Traversal is ");
     op.InorderTravsersal(Tree.getRoot());
     System.out.println("Preorder Traversal is ");
     op.PreorderTraversal(Tree.getRoot());
	}

}
