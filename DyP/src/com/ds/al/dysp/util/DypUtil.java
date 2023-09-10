package com.ds.al.dysp.util;

public class DypUtil {

	public static int getMaxInt(int a, int b) {
		int max = (a > b) ? a : b;

		return max;
	}

	public static int getDiff(int a, int b) {
		int diff = a - b;
		diff = (diff > 0) ? diff : -diff;
		return diff;

	}
}
