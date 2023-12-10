package com.ds.al.dysp.util;

public class DypUtil {

	public static int getMaxInt(int a, int b) {
		int max = (a > b) ? a : b;

		return max;
	}

	public static boolean isCharArrayPallindrome(char strArr[],int start ,int end) {
            
		for(int i=0;i<end/2;i++)
		{
			if(strArr[i]!=strArr[end-i])
				return false;
			
		}
		
		return true;
		
		
	}

}
