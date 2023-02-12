package com.ds.al.GreedyOps;

import java.util.HashMap;
import java.util.PriorityQueue;

import com.ds.al.GreedyEntity.HuffmanNode;

public interface GreedyOps {

	
	public HuffmanNode createHuffmanTree(PriorityQueue<HuffmanNode> huffmanNodeQueue);
	
	public void printHuffmanCode(HuffmanNode root,HashMap<Integer, String> codeMap,String code,Boolean isLeft);
	
	
}
