package com.ds.al.stringalgo.utility;

public class StringAlgoUtility {

	public static int areCharactersSame(String srcStr, String destStr) {
		int diffValue = 0;
		int minLength = (destStr.length() > srcStr.length()) ? srcStr.length() : destStr.length();
		for (int i = 0; i < minLength; i++) {

			diffValue = (destStr.charAt(i) == srcStr.charAt(i)) ? 0 : destStr.charAt(i) > srcStr.charAt(i) ? 1 : -1;
			if (diffValue != 0)
				break;

		}
		if (diffValue == 0 && destStr.length() > srcStr.length()) {
			diffValue = 1;
		}

		return diffValue;

	}

}
