package com.ds.al.graph.Entity;

import java.util.Comparator;

public class NodeGraph implements Comparator<NodeGraph> {

	private int vertice;

	private int weight;

	public int getVertice() {
		return vertice;
	}

	public void setVertice(int vertice) {
		this.vertice = vertice;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public NodeGraph(int vertice, int weight) {
		super();
		this.vertice = vertice;
		this.weight = weight;
	}

	@Override
	public int compare(NodeGraph o1, NodeGraph o2) {
		// TODO Auto-generated method stub
		if (o1.weight == o2.weight)
			return 0;
		int order = (o1.weight > o2.weight) ? 1 : -1;

		return order;
	}

}
