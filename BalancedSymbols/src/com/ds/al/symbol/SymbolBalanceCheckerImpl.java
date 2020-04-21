package com.ds.al.symbol;

import java.util.HashMap;
import java.util.Stack;

import com.ds.al.constants.Constants;


public class SymbolBalanceCheckerImpl  implements SymbolBalanceChecker{

	@Override
	public boolean CheckBalance(String s) {
		// TODO Auto-generated method stub
		
		Stack<Character> adt=new Stack<Character>();
		int count=0;
		HashMap<Character,Character> kmap=new HashMap<Character, Character>();
		kmap.put( Constants.CLOSEBRACKET,Constants.OPENBRACKET);
		kmap.put(Constants.CLOSEFLOWERBRACKET,Constants.OPENFLOWERBRACKET);
		kmap.put(Constants.CLOSESQUAREBRACKET,Constants.OPENSQUAREBRACKET);
		char arr[]=s.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
	        if(Compare(arr[i])==1)
	        {
	        	adt.push(arr[i]);
	        	count++;
	        }
	        else if(Compare(arr[i])==-1)
	        {
	        	if(adt.isEmpty())
	        	 return false;
	        	else if(adt.peek()==kmap.get(arr[i]))
	        	{
	        		adt.pop();
	        		count--;
	        	}
	        	else 
	        	return false;	
	        }
			
			
			
		}
		if(count!=0)
		return false;
		
		return true;
	}

	public int Compare(char c)
	{
		int balance=0;
	  if(c==Constants.OPENBRACKET||c==Constants.OPENFLOWERBRACKET||c==Constants.OPENSQUAREBRACKET)
	  {
		 balance=1;
	  }
	  else if(c==Constants.CLOSEBRACKET||c==Constants.CLOSEFLOWERBRACKET||c==Constants.CLOSESQUAREBRACKET)
	  {
		  balance=-1;
	  }
	    
	return balance;
		
		
	}


	
	
}
