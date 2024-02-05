package com.ds.al.graph.Entity;

import java.util.Comparator;

public class NodeGraph implements Comparable<NodeGraph> {

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
	public int compareTo(NodeGraph o1) {
		// TODO Auto-generated method stub
		return weight-o1.weight;
	}

}
