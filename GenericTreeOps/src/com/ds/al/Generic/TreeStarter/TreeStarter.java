package com.ds.al.Generic.TreeStarter;

import java.util.Scanner;

import com.ds.al.Generic.TreeEntity.GenericTreeEntity;
import com.ds.al.Generic.TreeOps.TreeOps;
import com.ds.al.Generic.TreeOps.TreeOpsImpl;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// GenericTreeEntity root;
		int treeSize, kNumber;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the tree size");
		treeSize = sc.nextInt();
		System.out.println("Enter the K number");
		kNumber = sc.nextInt();
		/* String inorderSequence = "",String preOrderSequence = "" */;

		TreeOps ops = new TreeOpsImpl();
		/*
		 * TreeOps opsTree1 = new TreeOpsImpl(); TreeOps opsTree2 = new TreeOpsImpl();
		 * System.out.println("Enter the size for first tree");
		 */

		String preOrderSequence[] = new String[treeSize];
		System.out.println("Enter the Preorder sequence");
		for (int i = 0; i < treeSize; i++) {
			preOrderSequence[i] = sc.next();
		}

		GenericTreeEntity root = ops.GenerateGenericTreePreorder(preOrderSequence, kNumber);

		sc.close();
		/*
		 * System.out.println("Enter the inorder sequence ");
		 * 
		 * for (int i = 0; i < treeSize; i++) {
		 * 
		 * inorderSequence = inorderSequence + sc.next() + "";
		 * 
		 * }
		 * 
		 * GenericTreeEntity root1 = opsTree1.mkGenericTree(preOrderSequence,
		 * inorderSequence); inorderSequence = ""; preOrderSequence = "";
		 * System.out.println("Enter the size for second tree"); treeSize =
		 * sc.nextInt();
		 * 
		 * System.out.println("Enter the Preorder sequence"); for (int i = 0; i <
		 * treeSize; i++) {
		 * 
		 * preOrderSequence = preOrderSequence + sc.next() + "";
		 * 
		 * } System.out.println("Enter the inorder sequence ");
		 * 
		 * for (int i = 0; i < treeSize; i++) {
		 * 
		 * inorderSequence = inorderSequence + sc.next() + "";
		 * 
		 * }
		 * 
		 * 
		 * GenericTreeEntity root2 = opsTree2.mkGenericTree(preOrderSequence,
		 * inorderSequence);
		 * //System.out.println("Isomorphic status is "+ops.isIsomorphic(root1, root2));
		 * System.out.println("Quasi morphic status is "+ ops.isQuasiIsomorphic(root1,
		 * root2)); /* int parentArr[] = new int[treeSize];
		 * System.out.println("Enter the tree elements of the parent array"); for (int i
		 * = 0; i < treeSize; i++) { parentArr[i] = sc.nextInt();
		 * 
		 * }
		 * 
		 * System.out.println("Depth of generic Tree is " + ops.getDepth(parentArr));
		 * 
		 * // System.out.println("Enter the preOrder Sequence "); /* for (int i = 0; i <
		 * treeSize; i++) { preOrderSequence = preOrderSequence + sc.next() + ""; }
		 * System.out.println("Enter the inorder Sequence"); for (int i = 0; i <
		 * treeSize; i++) { inorderSequence = inorderSequence + sc.next() + ""; }
		 */
		// root = ops.mkGenericTree(preOrderSequence, inorderSequence);
		// System.out.println("inorder traversal string ");
		// ops.TreeTraversal(root);
		// System.out.println("sum of all nodes is"+ops.getNodeSum(root));

	}

}
