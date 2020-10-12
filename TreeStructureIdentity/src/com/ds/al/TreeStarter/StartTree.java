package com.ds.al.TreeStarter;

import java.util.Scanner;

import com.ds.al.TreeOps.TreeOps;
import com.ds.al.TreeOps.TreeOpsImpl;
import com.ds.al.constants.TreeConstants;
import com.ds.al.tree.TreeEntity;

public class StartTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data, size, pathSum = 0;

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
		System.out.println("Enter the path sum to be checked");
		pathSum = sc.nextInt();
		sc.close();

		String dataStr = "";
		root1 = root1.GetRootNode();
		root2 = root2.GetRootNode();
		op.getRoottoLeafPath(root1, dataStr);
		System.out.println("The sum of all the nodes in binary tree " + op.getBTSum(root1));
		System.out.println("The sum of all the nodes in binary Tree " + op.getBTSumIterative(root1));
		System.out.println("Output on Comparing TreeStructure " + op.CompareTreeStructure(root1, root2));
		System.out.println("Diameter of the Tree " + op.GetTreeDiameter(root1));
		System.out.println("Diameter of the Tree is " + op.GetTeeDiamterUtility(root1));
		System.out.println("maximum level order sum is " + op.getMaxLevelSum(root1));
		System.out.println("status of the path sum checker is " + op.isSumPathExist(root1, pathSum));

	}

}
