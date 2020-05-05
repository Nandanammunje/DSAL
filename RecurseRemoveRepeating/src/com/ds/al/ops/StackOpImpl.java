package com.ds.al.ops;

import java.util.Stack;

import com.ds.al.entity.StackEntity;

public class StackOpImpl implements StackOp {

	@Override
	public Stack<StackEntity> RecurseRemove(StackEntity a[]) {
		// TODO Auto-generated method stub
		Stack<StackEntity> stack = new Stack<StackEntity>();
		stack.push(a[0]);
		int temp=a[0].getData();
		for (int i = 1; i < a.length; i++) {
			if(!stack.empty())
			{
				
				if(stack.peek().getData()==a[i].getData())
				{
					
					temp=stack.pop().getData();
					
				    continue; 
				}
				else if(temp==a[i].getData())
				{
					continue;
				}
				else
				{
					stack.push(a[i]);
					temp=stack.peek().getData();
				}
				
				
			}

		}

		return stack;
	}

}
	