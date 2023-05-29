package com.ds.al.divcon.util;

public class DivConUtil {

	public static int getMedian(int start, int end, int arr[]) {
		int median = 0;
		int arrLen = end - start + 1;
		if (arrLen % 2 == 0) {
			median = arr[start+(arrLen / 2)] + arr[start+(arrLen / 2) - 1];
			median = median / 2;
		} else {
			median = arr[(arrLen) / 2];
		}

		return median;
	}
	
	

}
