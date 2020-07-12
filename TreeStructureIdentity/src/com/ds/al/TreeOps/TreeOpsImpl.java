package com.ds.al.TreeOps;

import static java.lang.Math.max;

import com.ds.al.tree.TreeEntity;

public class TreeOpsImpl implements TreeOps {

	
	static int Diameter=0;
	
	@Override
	public boolean CompareTreeStructure(TreeEntity root1, TreeEntity root2) {
		// TODO Auto-generated method stub
		if(root1==null && root2==null)
			return true;
		else if(root1==null || root2==null)
			return false;
		
		return CompareTreeStructure(root1.getLeft(), root2.getLeft()) && CompareTreeStructure(root1.getRight(), root2.getRight());
	}

	@Override
	public int GetTreeDiameter(TreeEntity root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		int maxheight=GetTreeHeight(root.getLeft())+GetTreeHeight(root.getRight())+1;
		                                                        
		Diameter=max(Diameter,maxheight);
		
		return Diameter;
	}
	
	public int GetTreeHeight(TreeEntity root) {
		// TODO Auto-generated method stub
		
		if (root == null)
			return 0;
		

			int leftheight =  GetTreeHeight(root.getLeft());
			int rightheight = GetTreeHeight(root.getRight());
		

		return (leftheight > rightheight)?leftheight+1:rightheight+1;
	}

}
