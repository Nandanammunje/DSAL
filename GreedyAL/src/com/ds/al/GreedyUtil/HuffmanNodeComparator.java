package com.ds.al.GreedyUtil;

import java.util.Comparator;

import com.ds.al.GreedyEntity.HuffmanNode;

public class HuffmanNodeComparator implements Comparator<HuffmanNode> {

	@Override
	public int compare(HuffmanNode t1, HuffmanNode t2) {
		// TODO Auto-generated method stub
		return t1.getData()-t2.getData();
	}

}
