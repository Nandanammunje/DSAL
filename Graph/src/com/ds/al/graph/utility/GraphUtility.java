package com.ds.al.graph.utility;

import java.util.Deque;

public class GraphUtility {

	public static boolean isElementinDequeu(Deque<Integer> nodeStack, int node) {

		for (Integer it : nodeStack) {
			if (it == node) {
				return true;
			}

		}
		return false;

	}

}
