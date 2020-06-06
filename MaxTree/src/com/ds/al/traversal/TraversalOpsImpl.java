package com.ds.al.traversal;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
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
		boolean IsFound=Boolean.TRUE;
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
			      IsFound=(node.getData()==data)?Boolean.TRUE:Boolean.FALSE;
			      if(IsFound)
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
    	 int count=0;
    	 if(root!=null)
    	 {
    		 count++;
    		 count=count+TreeSizeCalculator(root.getLeft())+TreeSizeCalculator(root.getRight());
    	 }
		return count;
	}

	@Override
	public int TreeSizeCalculatorIterartive(TreeEntity root) {
		// TODO Auto-generated method stub
		int count=0;
		TreeEntity node=null;
		QueueEntity TreeQueue=new QueueEntity();
		TreeQueue.Enqueue(root);
		while(!TreeQueue.IsEmpty())
		{
			try
			{
				node=TreeQueue.Dequeue();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			if(node!=null)
			{
				count++;
				if(node.getLeft()!=null)
				TreeQueue.Enqueue(node.getLeft());
				if(node.getRight()!=null)
				TreeQueue.Enqueue(node.getRight());	
			}
		}
		
		return count;
	}

	@Override
	public int GetTreeHeight(TreeEntity root) {
		// TODO Auto-generated method stub
		int leftheight=0,rightheight=0;
		if(root!=null)
		{
	       leftheight++;
	       rightheight++;
	       leftheight=leftheight+GetTreeHeight(root.getLeft());
	       rightheight=rightheight+GetTreeHeight(root.getRight());
		}
		
		return max(leftheight, rightheight);
	}

}
