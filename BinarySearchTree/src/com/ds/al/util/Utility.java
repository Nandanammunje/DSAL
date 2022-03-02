package com.ds.al.util;

public class Utility {

	public static boolean compareCharacter(char a, char b) {
		int charFirst = (int) a;

		int charSecond = (int) b;

		return charFirst > charSecond;
	}

	public static int compareCharacterInt(char a, char b) {
		int charFirst = (int) a;
		int charSecond = (int) b;
		int compareInt = (charFirst == charSecond) ? 0 : (charFirst > charSecond) ? 1 : -1;
		return compareInt;

	}

}
