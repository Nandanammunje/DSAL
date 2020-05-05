package com.ds.al.starter;

import java.util.Scanner;
import java.util.Stack;

import com.ds.al.entity.StackEntity;
import com.ds.al.ops.StackOp;
import com.ds.al.ops.StackOpImpl;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int m,data;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the numeric list");
		m=sc.nextInt();
		StackEntity a[]=new StackEntity [m];
	    StackOp op=new StackOpImpl();
		for(int i=0;i<m;i++)
		{
			System.out.println("Enter data into the nodes");
			data=sc.nextInt();
			StackEntity num=new StackEntity();
			num.setData(data);
			num.setRepeated(false);
			a[i]=num;
		}
		sc.close();
		Stack<StackEntity> stack=op.RecurseRemove(a);
		for(int i=0;i<stack.size();i++)
		{
			System.out.println(stack.get(i).getData());
		}
		
		

	}

}
