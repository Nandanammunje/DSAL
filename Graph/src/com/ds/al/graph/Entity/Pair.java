package com.ds.al.graph.Entity;

public class Pair implements Comparable<Pair> {

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

	public Pair(int vertice, int weight) {
		this.vertice = vertice;
		this.weight = weight;
	}

	@Override
	public int compareTo(Pair node) {
		// TODO Auto-generated method stub

		return this.weight - node.weight;
	}

}
