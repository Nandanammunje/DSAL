package com.ds.al.stringalgo.utility;

public class StringAlgoUtility {

	public static int areCharactersSame(String srcStr, String destStr) {
		int diffValue=0;
		for (int i = 0; i < destStr.length(); i++) {
			
			diffValue=(destStr.charAt(i)==srcStr.charAt(i))?0:destStr.charAt(i)>srcStr.charAt(i)?1:-1;
			if(diffValue!=0)
				break;

		}
		return diffValue;

	}

}
