package com.ds.al.traversal;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;

import java.util.Stack;

import com.ds.al.entity.QueueEntity;
import com.ds.al.entity.TreeEntity;

public class TraversalOpsImpl implements TraversalOps {

	@Override
	public void PreorderTraversal(TreeEntity root) {
		// TODO Auto-generated method stub
		if (root != null) {
			System.out.println(root.getData());
			PreorderTraversal(root.getLeft());
			PreorderTraversal(root.getRight());
		} else
			return;
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

	@Override
	public int MaxTreeElement(TreeEntity root) {
		// TODO Auto-generated method stub
		int max = MIN_VALUE;
		if (root != null) {

			int leftmax = MaxTreeElement(root.getLeft());
			int rightmax = MaxTreeElement(root.getRight());
			if (leftmax > rightmax)
				max = leftmax;
			else
				max = rightmax;

			if (max < root.getData()) {
				max = root.getData();
			}
		}
		return max;
	}

	@Override
	public int MaxTreeElementIterative(TreeEntity root) {
		// TODO Auto-generated method stub
		int max = MIN_VALUE;
		TreeEntity node = null;
		QueueEntity TreeQueue = new QueueEntity();
		TreeQueue.Enqueue(root);

		while (!TreeQueue.IsEmpty()) {
			try {
				node = TreeQueue.Dequeue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (node != null) {
				max = (max < node.getData()) ? node.getData() : max;
				if (node.getLeft() != null)

					TreeQueue.Enqueue(node.getLeft());
				if (node.getRight() != null)
					TreeQueue.Enqueue(node.getRight());
			}

		}
		return max;
	}

	@Override
	public boolean SearchTreeElement(TreeEntity root, int data) {
		// TODO Auto-generated method stub
		if (root == null) {
			return false;
		}

		if (root.getData() == data) {
			return true;
		}

		return SearchTreeElement(root.getLeft(), data) || SearchTreeElement(root.getRight(), data);
	}

	@Override
	public boolean SearchTreeElementIterative(TreeEntity root, int data) {
		// TODO Auto-generated method stub
		boolean IsFound = TRUE;
		TreeEntity node = null;
		QueueEntity TreeQueue = new QueueEntity();
		TreeQueue.Enqueue(root);

		while (!TreeQueue.IsEmpty()) {
			try {
				node = TreeQueue.Dequeue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (node != null) {
				IsFound = (node.getData() == data) ? TRUE : FALSE;
				if (IsFound)
					break;
				if (node.getLeft() != null)
					TreeQueue.Enqueue(node.getLeft());
				if (node.getRight() != null)
					TreeQueue.Enqueue(node.getRight());
			}

		}
		return IsFound;
	}

	@Override
	public int TreeSizeCalculator(TreeEntity root) {
		// TODO Auto-generated method stub
		int count = 0;
		if (root != null) {
			count++;
			count = count + TreeSizeCalculator(root.getLeft()) + TreeSizeCalculator(root.getRight());
		}
		return count;
	}

	@Override
	public int TreeSizeCalculatorIterartive(TreeEntity root) {
		// TODO Auto-generated method stub
		int count = 0;
		TreeEntity node = null;
		QueueEntity TreeQueue = new QueueEntity();
		TreeQueue.Enqueue(root);
		while (!TreeQueue.IsEmpty()) {
			try {
				node = TreeQueue.Dequeue();

			} catch (Exception e) {
				System.out.println(e);
			}
			if (node != null) {
				count++;
				if (node.getLeft() != null)
					TreeQueue.Enqueue(node.getLeft());
				if (node.getRight() != null)
					TreeQueue.Enqueue(node.getRight());
			}
		}

		return count;
	}

	@Override
	public int GetTreeHeight(TreeEntity root) {
		// TODO Auto-generated method stub
		int leftheight = 0, rightheight = 0;
		if (root == null)
			return 0;
		if (root != null) {

			leftheight = leftheight + GetTreeHeight(root.getLeft());
			rightheight = rightheight + GetTreeHeight(root.getRight());
		}

		return max(leftheight + 1, rightheight + 1);
	}

	@Override
	public int GetTreeHeightIterative(TreeEntity root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		Stack<TreeEntity> TreeStack = new Stack<TreeEntity>();
		int height = 0;
		TreeEntity curr = null, nxt = null;
		TreeStack.add(root);
		while (!TreeStack.empty()) {
			if (root.getLeft() != null && root.getLeft() != curr && root.getLeft() != nxt && root.getRight() != curr) {
				root = root.getLeft();
				TreeStack.add(root);
			} else if (root.getRight() != null && root.getRight() != curr && root.getRight() != nxt) {
				root = root.getRight();
				TreeStack.add(root);
			} else {
				if (!TreeStack.isEmpty()) {
					nxt = curr;
					if (TreeStack.size() > height)
						height = TreeStack.size();
					curr = TreeStack.pop();
					if (!TreeStack.isEmpty())
						root = TreeStack.peek();

				}

			}
		}

		return height;
	}

	@Override
	public int TreeGetDeepestNode(TreeEntity root) {
		// TODO Auto-generated method stub
		TreeEntity node = null;
		int data = 0;
		QueueEntity LevelQueue = new QueueEntity();
		LevelQueue.Enqueue(root);
		while (!LevelQueue.IsEmpty()) {
			try {
				node = LevelQueue.Dequeue();
				data = node.getData();
				if (node.getLeft() != null)
					LevelQueue.Enqueue(node.getLeft());
				if (node.getRight() != null)
					LevelQueue.Enqueue(node.getRight());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return data;

	}

	@Override
	public int GetHalfNodes(TreeEntity root) {
		// TODO Auto-generated method stub
		int count = 0;

		if (root == null) {
			return count;
		} else {
			if ((root.getLeft() == null && root.getRight() != null)
					|| (root.getRight() == null && root.getLeft() != null))
				count++;
			count = count + GetHalfNodes(root.getLeft()) + GetHalfNodes(root.getRight());
		}

		return count;
	}

	@Override
	public int GetLeafNodes(TreeEntity root) {
		// TODO Auto-generated method stub
		int count = 0;

		if (root == null) {
			return count;
		} else {
			if (root.getLeft() == null && root.getRight() == null)
				count++;
			count = count + GetLeafNodes(root.getLeft()) + GetLeafNodes(root.getRight());

		}

		return count;
	}

	@Override
	public int GetFullNodes(TreeEntity root) {
		// TODO Auto-generated method stub
		int count = 0;
		if (root == null) {
			return count;
		} else {
			if (root.getLeft() != null && root.getRight() != null)
				count++;
			count = count + GetFullNodes(root.getLeft()) + GetFullNodes(root.getRight());
		}
		return count;
	}

}
