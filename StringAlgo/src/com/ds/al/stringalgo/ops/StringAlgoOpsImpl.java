package com.ds.al.stringalgo.ops;

import static com.ds.al.stringalgo.utility.StringAlgoUtility.getRepeatCharIndex;

import java.util.ArrayList;
import java.util.Stack;

public class StringAlgoOpsImpl implements StringAlgoOps {

	private String charSeq;

	@Override
	public int findPatternKMP(String textIn, String pattern) {
		// TODO Auto-generated method stub
		int[] prefixPatternTable = createPrefixTable(pattern);
		int i = 0, j = 0;
		while (i < textIn.length()) {
			if (textIn.charAt(i) == pattern.charAt(j)) {

				i++;
				j++;
			}
			if (j == pattern.length()) {
				System.out.println("pattern found at " + (i - j));
				j = prefixPatternTable[j - 1];
			} else if (i < textIn.length() && textIn.charAt(i) == pattern.charAt(j)) {

				if (j > 0)
					j = prefixPatternTable[j - 1];
				else
					i++;

			}

		}
		return 0;
	}

	private int[] createPrefixTable(String pattern) {
		int patArr[] = new int[pattern.length()];
		int len = 0, i = 1;

		while (i < patArr.length) {
			if (pattern.charAt(i) == pattern.charAt(len)) {

				len++;
				patArr[i] = len;
				i++;
			} else {
				if (len > 0)
					len = patArr[len - 1];
				else {
					patArr[i] = len;
					i++;
				}

			}

		}
		return patArr;
	}

	@Override
	public void removeAdjCharacters(String str) {
		// TODO Auto-generated method stub
		Stack<Character> charStack = new Stack<Character>();
		char stackTopChar = '\0';
	    
	  
		for (int i = 0; i < str.length(); i++) {
			char charItr = str.charAt(i);
			if (!charStack.isEmpty())
				stackTopChar = charStack.peek();
			else
				stackTopChar = '\0';
			if (stackTopChar != charItr)
				charStack.push(charItr);
			else {
				if(i==str.length()-1||str.charAt(i+1)!=stackTopChar)
				charStack.pop();
			}

		}
               if(!charStack.isEmpty())
            	   charStack.stream().forEach((itr)->{System.out.println(itr);});
		
	}
}
