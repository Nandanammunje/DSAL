package com.ds.al.starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ds.al.entity.TreeEntity;
import com.ds.al.traversal.TraversalOps;
import com.ds.al.traversal.TraversalOpsImpl;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int Treesize = 0, data = 0, SearchData = 0;
		TreeEntity root = null;
		String isfound = "Element exist in the tree";
		String notfound = "Element does not exist in the tree";
	     List<String> filename = null;
		TreeEntity tree = new TreeEntity();
		System.out.println("Enter the size of the tree");
		Scanner sc = new Scanner(System.in);
		Treesize = sc.nextInt();
		for (int i = 0; i < Treesize; i++) {
			System.out.println("Enter the data into the tree");
			data = sc.nextInt();
			tree.AddNode(data);
		}
		System.out.println("Enter the element to be searched ");
		SearchData = sc.nextInt();
		sc.close();
		root = tree.GetRoot();
		TraversalOps op = new TraversalOpsImpl();
		
		op.InorderTravsersal(root);
		op.PreorderTraversal(root);
		System.out.println("Maximum Tree Element is " + op.MaxTreeElement(root));
		System.out.println("Maximum Tree Element is " + op.MaxTreeElementIterative(root));
		String status = (op.SearchTreeElement(root, SearchData)) ? isfound : notfound;
		System.out.println("" + status);
		status = (op.SearchTreeElementIterative(root, SearchData)) ? isfound : notfound;
		System.out.println(""+status);
		System.out.println("The size of the Tree is "+op.TreeSizeCalculator(root));
		System.out.println("The size of the Tree is "+op.TreeSizeCalculatorIterartive(root));
		System.out.println("The height of the Tree is "+op.GetTreeHeight(root));
		System.out.println("The height of the Tree is "+op.GetTreeHeightIterative(root));
	}

}
