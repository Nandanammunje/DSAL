package com.ds.al.TreeOps;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;

import com.ds.al.TreeUtility.QueueEntity;
import com.ds.al.tree.TreeEntity;;

/**
 * @author nandannayak This class implements the interface TreeOps
 */
public class TreeOpsImpl implements TreeOps {

	static int Diameter = 0;
	static int maxSum = 0;

	/**
	 * This function compares the structure of two BST returns true if identical
	 * else returns false
	 */
	@Override
	public boolean CompareTreeStructure(TreeEntity root1, TreeEntity root2) {
		// TODO Auto-generated method stub
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}

		return CompareTreeStructure(root1.getLeft(), root2.getLeft())
				&& CompareTreeStructure(root1.getRight(), root2.getRight());
	}

	/**
	 * This function calculates the maximum level order sum by using null as
	 * seperator for each level
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
					if (treeQueue.getFirst() == null) {
						break;
					}
				} else {
					sum = sum + node.getData();
					if (node.getLeft() != null) {
						treeQueue.Enqueue(node.getLeft());
					}
					if (node.getRight() != null) {
						treeQueue.Enqueue(node.getRight());
					}
					treeQueue.Dequeue();

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return maxSum;
	}

	/**
	 * This function uses inorder Traversal to create a path form root to leaf
	 */
	@Override
	public void getRoottoLeafPath(TreeEntity root, String dataString) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			printArray(dataString, root.getData());
		} else {

			dataString = dataString + root.getData() + "->";
			getRoottoLeafPath(root.getLeft(), dataString);
			getRoottoLeafPath(root.getRight(), dataString);
		}

	}

	/**
	 * calls the optimized function to calculate diameter of the tree
	 */
	@Override
	public int GetTeeDiamterUtility(TreeEntity root) {
		// TODO Auto-generated method stub\
		Diameter = 0;
		GetTreeDiameterOptimized(root);
		return Diameter;
	}

	/**
	 * This function returns diameter of the tree i.e the maximum distance from one
	 * node to another by recursively calculating leftheight + right height +1 for
	 * each node
	 *
	 */
	@Override
	public int GetTreeDiameter(TreeEntity root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}
		int maxheight = GetTreeHeight(root.getLeft()) + GetTreeHeight(root.getRight()) + 1;
		Diameter = max(Diameter, maxheight);
		GetTreeDiameter(root.getLeft());
		GetTreeDiameter(root.getRight());
		return Diameter;
	}

	/**
	 * optimized version of the code to calculate diameter of the tree
	 *
	 * @param root takes input root of the tree to calculate height of the tree
	 * @returns the diameter of the tree by calculating height and diameter for each
	 *          node in the same recursive call
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
	 * @param root takes input of root node and calculates height node of the tree
	 * @return the height of the tree maximum of left height and right height
	 */
	private int GetTreeHeight(TreeEntity root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return 0;
		}

		int leftheight = GetTreeHeight(root.getLeft());
		int rightheight = GetTreeHeight(root.getRight());

		return (leftheight > rightheight) ? leftheight + 1 : rightheight + 1;
	}

	/**
	 * recursively subtracts the node from the path sum
	 */
	@Override
	public boolean isSumPathExist(TreeEntity root, int pathSum) {
		// TODO Auto-generated method stub
		if (root == null)
			return false;
		if (pathSum == root.getData())
			return true;
		else
			return isSumPathExist(root.getLeft(), pathSum - root.getData())
					|| isSumPathExist(root.getRight(), pathSum - root.getData());

	}

	/**
	 * @param data
	 * @param node prints the path from root to leaf from the datastring
	 */
	private void printArray(String data, int node) {
		if (data != null && !data.isEmpty()) {
			System.out.println("The path to the node " + node + " is " + data + " " + node);

		}

	}

	/**
	 * @param data recursive function that calculates sum of all nodes in BST
	 */
	@Override
	public int getBTSum(TreeEntity root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		else
			return root.getData() + getBTSum(root.getLeft()) + getBTSum(root.getRight());
	}

	/**
	 * @param root takes input the root of the tree to calculate 5 sum of all nodes
	 *             in BT using level order traversal
	 */
	@Override
	public int getBTSumIterative(TreeEntity root) {
		// TODO Auto-generated method stub
		TreeEntity node = null;
		int sum = 0;
		if (root == null)
			return 0;
		QueueEntity queue = new QueueEntity();
		queue.Enqueue(root);
		while (!queue.isEmpty()) {
			try {
				node = queue.getFirst();
				sum = sum + node.getData();
				if (node.getLeft() != null)
					queue.Enqueue(node.getLeft());
				if (node.getRight() != null)
					queue.Enqueue(node.getRight());
				queue.Dequeue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sum;
	}

	@Override
	public TreeEntity MirrorTree(TreeEntity root) {
		// TODO Auto-generated method stub
		TreeEntity temp;
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return root;
		if (root != null) {
			MirrorTree(root.getLeft());
			MirrorTree(root.getRight());
			temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
		return root;
	}

	@Override
	public void InorderTravsersal(TreeEntity root) {
		// TODO Auto-generated method stub
		if (root != null) {
			InorderTravsersal(root.getLeft());
			System.out.println(root.getData());
			InorderTravsersal(root.getRight());
		} else
			return;
	}

}
