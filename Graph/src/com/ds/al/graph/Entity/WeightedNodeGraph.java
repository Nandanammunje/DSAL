package com.ds.al.graph.Entity;

import java.util.ArrayList;



public class WeightedNodeGraph {

	private int vertices;

	private ArrayList<ArrayList<Pair>> adjPairMatrix;

	public void addEdge(int source, int destination, int weight) {
		adjPairMatrix.get(source).add(new Pair(destination, weight));
		adjPairMatrix.get(destination).add(new Pair(source, weight));
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
		adjPairMatrix = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			adjPairMatrix.add(new ArrayList<Pair>());
		}
	}

	public ArrayList<ArrayList<Pair>> getAdjLst() {
		return adjPairMatrix;
	}

}
