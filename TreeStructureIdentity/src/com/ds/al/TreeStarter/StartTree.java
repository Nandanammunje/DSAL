package com.ds.al.TreeStarter;

import java.util.Scanner;

import com.ds.al.TreeOps.TreeOps;
import com.ds.al.TreeOps.TreeOpsImpl;
import com.ds.al.constants.TreeConstants;
import com.ds.al.tree.TreeEntity;

public class StartTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data, size;
		TreeEntity root1 = new TreeEntity();
		TreeEntity root2 = new TreeEntity();
		TreeOps op = new TreeOpsImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Tree size");
		size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			System.out.println("Enter data into the Tree");
			data = sc.nextInt();
			root1.AddNode(data, TreeConstants.BST);
			root2.AddNode(data, TreeConstants.BST);
		}
		sc.close();
		root1 = root1.GetRootNode();
		root2 = root2.GetRootNode();
		System.out.println(root1.getData());
		System.out.println(root2.getData());
		System.out.println("Output on Comparing TreeStructure " + op.CompareTreeStructure(root1, root2));
		System.out.println("Diameter of the Tree "+op.GetTreeDiameter(root1));
	
	}

}
