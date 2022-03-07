package com.ds.al.util;

import com.ds.al.DoubleLinkedLstEntity.DoubleLinkedLst;

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

	public static DoubleLinkedLst getMedian(DoubleLinkedLst head) {

		DoubleLinkedLst slow, fast;
		slow = fast = head;
		while (fast != null && fast.getNxt() != null) {
			slow = slow.getNxt();
			fast = fast.getNxt().getNxt();

		}
		return slow;
	}

}
