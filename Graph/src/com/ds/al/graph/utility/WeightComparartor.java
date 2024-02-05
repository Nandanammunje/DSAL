package com.ds.al.graph.utility;

import java.util.Comparator;

import com.ds.al.graph.Entity.Node;

public class WeightComparartor implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return o1.getWeight() - o2.getWeight();
	}

}
