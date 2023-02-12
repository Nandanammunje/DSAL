package com.ds.al.GreedyStarter;

import java.util.HashMap;
import java.util.PriorityQueue;

import com.ds.al.GreedyEntity.HuffmanNode;
import com.ds.al.GreedyOps.GreedyOps;
import com.ds.al.GreedyOps.GreedyOpsImpl;
import com.ds.al.GreedyUtil.HuffmanNodeComparator;

public class GreedyStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };
		HuffmanNodeComparator nodeCompar = new HuffmanNodeComparator();
		PriorityQueue<HuffmanNode> nodeQueue = new PriorityQueue<HuffmanNode>(nodeCompar);
		for (int i = 0; i < charArray.length; i++) {
			HuffmanNode hn = new HuffmanNode();
			hn.setData(charfreq[i]);
			hn.sethuffmanChar(charArray[i]);
			nodeQueue.add(hn);
		}

		HashMap<Integer,String> codeMap=new HashMap<>();
		GreedyOps ops = new GreedyOpsImpl();
		HuffmanNode createHuffmanTree = ops.createHuffmanTree(nodeQueue);
		for (int i = 0; i < charArray.length; i++) {
             int charInt=(int)charArray[i];
             System.out.println(charInt);
             if(!codeMap.containsKey(charInt))
             {
            	 codeMap.put(charInt,"null");
             }
		}
        String code="";
		ops.printHuffmanCode(createHuffmanTree, codeMap, code, null);
	}

}
