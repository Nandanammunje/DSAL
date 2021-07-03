package com.ds.al.TreeStarter;

import java.util.List;
import java.util.Scanner;

import com.ds.al.TreeOps.TreeOps;
import com.ds.al.TreeOps.TreeOpsImpl;
import com.ds.al.tree.TreeEntity;

public class TreeStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Node Limit");
		size = sc.nextInt();
        TreeOps ops=new TreeOpsImpl();
        List<TreeEntity> bstList=ops.makeTrees(size);
        System.out.println("No of BST Possible are "+ bstList.size());
        for(TreeEntity it:bstList)
        {
        	System.out.println();
        	if(it==null)
        	System.out.println("null");
        	ops.PreorderTraversal(it);
        	
        }
        
        sc.close();
	}

}
