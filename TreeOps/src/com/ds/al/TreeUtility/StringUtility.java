package com.ds.al.TreeUtility;

public class StringUtility {

	public static String StrReverse(String in) {
		char temp;
		char arr[] = in.toCharArray();
		int arrLen = arr.length;
		for (int i = 0; i < arrLen / 2; i++) {

			temp = arr[i];
			arr[i] = arr[arrLen - i - 1];
			arr[arrLen - i - 1] = temp;
		}

		return String.valueOf(arr);
	}

}
