package com.ds.al.util;

import com.ds.al.DoubleLinkedLstEntity.DoubleLinkedLst;

public class Utility {

	public static boolean compareCharacter(char a, char b) {
		int charFirst = (int) a;

		int charSecond = (int) b;

		return charFirst > charSecond;
	}

	public static boolean compareCharacter(String a, String b) {
		int charFirst = Integer.parseInt(a);

		int charSecond = Integer.parseInt(b);

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

	public static int compareDoubleLinkedLst(DoubleLinkedLst nodeA, DoubleLinkedLst nodeB) {
		if (nodeA == null && nodeB == null)
			return 0;
		if (nodeA != null && nodeB == null)
			return 1;
		else if (nodeA == null && nodeB != null)
			return -1;

		return compareDoubleLinkedLst(nodeA.getNxt(), nodeB.getNxt());

	}

	public static DoubleLinkedLst mergeSortedDll(DoubleLinkedLst nodeA, DoubleLinkedLst nodeB) {

		DoubleLinkedLst tail = nodeA;
		DoubleLinkedLst node = nodeB;
		while (node != null && tail.getNxt() != null) {
			if (Integer.parseInt(tail.getData()) > Integer.parseInt(node.getData())) {
				if (tail.getPrev() != null
						&& Integer.parseInt(tail.getPrev().getData()) <= Integer.parseInt(node.getData())) {
					DoubleLinkedLst temp = node;
					node = node.getNxt();
					temp.setNxt(tail);
					temp.setPrev(tail.getPrev());
					tail.setPrev(temp);
					tail.getPrev().setNxt(temp);
				}
				if (tail.getPrev() == null) {
					nodeA = node;
					DoubleLinkedLst temp = node;
					node = node.getNxt();
					temp.setNxt(tail);
					temp.setPrev(tail.getPrev());
					tail.setPrev(temp);

				}

			} else if (Integer.parseInt(tail.getData()) < Integer.parseInt(node.getData())) {

				tail = tail.getNxt();
			} else {
				tail = tail.getNxt();
				node = node.getNxt();
			}

		}
		if (tail.getNxt() == null && node != null
				&& Integer.parseInt(tail.getData()) == Integer.parseInt(node.getData()))
			node = node.getNxt();

		if (tail.getNxt() == null && node != null
				&& Integer.parseInt(tail.getData()) != Integer.parseInt(node.getData())) {
			tail.setNxt(node);
			node.setPrev(tail);

		}

		return nodeA;
	}
}
