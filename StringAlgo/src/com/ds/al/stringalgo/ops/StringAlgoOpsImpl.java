package com.ds.al.stringalgo.ops;

public class StringAlgoOpsImpl implements StringAlgoOps {

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
				
				if(j >0)
				j=prefixPatternTable[j-1];	
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
}
