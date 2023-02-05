package com.ds.al.GreedyStarter;

import java.util.PriorityQueue;

import com.ds.al.GreedyEntity.HuffmanNode;
import com.ds.al.GreedyUtil.HuffmanNodeComparator;

public class GreedyStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 12, 2, 7, 13, 14, 85 };
		HuffmanNodeComparator nodeCompar = new HuffmanNodeComparator();
		PriorityQueue<HuffmanNode> nodeQueue = new PriorityQueue<HuffmanNode>(nodeCompar);
		for (int i = 0; i < charArray.length; i++) {
			HuffmanNode hn = new HuffmanNode();
			hn.setData(charfreq[i]);
			hn.sethuffmanChar(charArray[i]);
			nodeQueue.add(hn);
		}

	}

}
