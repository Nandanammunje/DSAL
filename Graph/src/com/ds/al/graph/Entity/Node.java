package com.ds.al.graph.Entity;

public class Node {

	private int source;

	private int dest;

	private int weight;

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Node(int source, int dest, int weight) {

		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}

}
