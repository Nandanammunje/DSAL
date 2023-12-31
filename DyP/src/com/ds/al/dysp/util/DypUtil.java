package com.ds.al.dysp.util;

public class DypUtil {

	public static int getMaxInt(int a, int b) {
		int max = (a > b) ? a : b;

		return max;
	}

	public static boolean isCharArrayPallindrome(char strArr[], int start, int end) {

		for (int i = 0; i < end / 2; i++) {
			if (strArr[i] != strArr[end - i])
				return false;

		}

		return true;

	}

	public static char[] getExpressionArr(char boolSeq[], char operatorSeq[]) {

		int expressionArrLen = boolSeq.length + operatorSeq.length;

		char expressionArr[] = new char[expressionArrLen];
		int i = 0, j = 1, k = 0;
		while (i < expressionArrLen) {
			expressionArr[i] = boolSeq[k];
			i++;
			if (k < operatorSeq.length)
				expressionArr[i] = operatorSeq[k];
			i++;
			k++;

		}
		return expressionArr;

	}

}
