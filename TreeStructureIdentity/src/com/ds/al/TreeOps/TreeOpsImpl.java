package com.ds.al.TreeOps;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;

import com.ds.al.TreeUtility.QueueEntity;
import com.ds.al.tree.TreeEntity;;

/**
 * @author nandannayak
 * This class implements the interface TreeOps 
 */
public class TreeOpsImpl implements TreeOps {

	static int Diameter = 0;
	static int maxSum = 0;

	/**
	 *This function compares the structure of two BST returns true if identical else returns false
	 */
	@Override
	public boolean CompareTreeStructure(TreeEntity root1, TreeEntity root2) {
		// TODO Auto-generated method stub
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null || root2 == null)
			return false;

		return CompareTreeStructure(root1.getLeft(), root2.getLeft())
				&& CompareTreeStructure(root1.getRight(), root2.getRight());
	}

	/**
	 * This function returns diameter of the tree i.e the maximum distance from one node to another by recursively calculating leftheight 
	 * + right height +1 for each node  
	 * 
	 */
	@Override
	public int GetTreeDiameter(TreeEntity root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		int maxheight = GetTreeHeight(root.getLeft()) + GetTreeHeight(root.getRight()) + 1;
		Diameter = max(Diameter, maxheight);
		GetTreeDiameter(root.getLeft());
		GetTreeDiameter(root.getRight());
		return Diameter;
	}
   
	/**
	 * @param root takes input of root node and calculates height node of the tree 
	 * @return the height of the tree maximum of left height and right height
	 */
	private int GetTreeHeight(TreeEntity root) {
		// TODO Auto-generated method stub

		if (root == null)
			return 0;

		int leftheight = GetTreeHeight(root.getLeft());
		int rightheight = GetTreeHeight(root.getRight());

		return (leftheight > rightheight) ? leftheight + 1 : rightheight + 1;
	}
    
	/** optimized version of the code to calculate diameter of the tree
	 * @param root takes input root of the tree to calculate height of the tree
	 * @returns the diameter of the tree by calculating height and diameter for each node in the same recursive call
	 */
	private int GetTreeDiameterOptimized(TreeEntity root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return 0;
		}
		int left = 0, right = 0;

		left = GetTreeDiameterOptimized(root.getLeft());
		right = GetTreeDiameterOptimized(root.getRight());
		if (left + right + 1 > Diameter) {
			Diameter = left + right + 1;
		}
		return (left > right) ? left + 1 : right + 1;
	}

	
	
	/**
	 *calls the optimized function to calculate diameter of the tree
	 */
	@Override
	public int GetTeeDiamterUtility(TreeEntity root) {
		// TODO Auto-generated method stub\
		Diameter = 0;
		GetTreeDiameterOptimized(root);
		return Diameter;
	}

	/**
	 *This function calculates the maximum  level order sum by using null as seperator for each level 
	 */
	@Override
	public int getMaxLevelSum(TreeEntity root) {
		// TODO Auto-generated method stub
		TreeEntity node = null;
		int sum = 0;
		maxSum = MIN_VALUE;
		QueueEntity treeQueue = new QueueEntity();
		treeQueue.Enqueue(root);
		treeQueue.Enqueue(null);
		while (!treeQueue.isEmpty()) {
			try {
				node = treeQueue.getFirst();
				if (node == null) {
					if (sum > maxSum) {
						maxSum = sum;
					}
					sum = 0;
					treeQueue.Enqueue(null);
					treeQueue.Dequeue();
				} else {
					sum = sum + node.getData();
					if (node.getLeft() != null)
						treeQueue.Enqueue(node.getLeft());
					if (node.getRight() != null)
						treeQueue.Enqueue(node.getRight());
					treeQueue.Dequeue();

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return maxSum;
	}

}
