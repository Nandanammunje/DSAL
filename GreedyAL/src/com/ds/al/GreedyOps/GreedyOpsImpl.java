package com.ds.al.GreedyOps;

import java.util.PriorityQueue;

import com.ds.al.GreedyEntity.HuffmanNode;

public class GreedyOpsImpl implements GreedyOps {

	@Override
	public HuffmanNode createHuffmanTree(PriorityQueue<HuffmanNode> huffmanNodeQueue) {
		// TODO Auto-generated method stub'
		HuffmanNode newNode;
		while (huffmanNodeQueue.size() > 1) {
			HuffmanNode pollNodeMinOne = huffmanNodeQueue.peek();
			huffmanNodeQueue.poll();
			HuffmanNode pollNodeMinTwo = huffmanNodeQueue.peek();
			huffmanNodeQueue.poll();
			newNode = new HuffmanNode();
			newNode.setData(pollNodeMinOne.getData() + pollNodeMinTwo.getData());
			newNode.setLeft(pollNodeMinOne);
			newNode.setRight(pollNodeMinTwo);

		}
		return null;
	}

}
