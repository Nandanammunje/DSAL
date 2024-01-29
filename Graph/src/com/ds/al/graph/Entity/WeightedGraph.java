package com.ds.al.graph.Entity;

import java.util.ArrayList;

public class WeightedGraph {

	private int vertices;

	private ArrayList<ArrayList<NodeGraph>> adj;

	public WeightedGraph(int vertices) {
		super();
		this.vertices = vertices;
		adj = new ArrayList<ArrayList<NodeGraph>>();

		for (int i = 0; i < vertices; i++)
			adj.add(new ArrayList<NodeGraph>());

	}

	public void addEdge(int u, int v, int w) {

		adj.get(u).add(new NodeGraph(v, w));
	}

	public ArrayList<ArrayList<NodeGraph>> getAdjLst() {

		return adj;
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

}
