package com.ds.al.graph.Entity;

import java.util.ArrayList;

public class WeightedNodeGraph {

	private int vertices;

	private ArrayList<ArrayList<Pair>> adjLstMatrix;

	private int AdjMatrix[][];

	public void addEdge(int source, int destination, int weight) {
		adjLstMatrix.get(source).add(new Pair(destination, weight));
		adjLstMatrix.get(destination).add(new Pair(source, weight));
		AdjMatrix[source][destination] = weight;
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
		adjLstMatrix = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			adjLstMatrix.add(new ArrayList<Pair>());
		}
		AdjMatrix = new int[vertices][vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (i == j)
					AdjMatrix[i][j] = 0;
				else
					AdjMatrix[i][j] = Integer.MAX_VALUE;
			}

		}
	}

	public ArrayList<ArrayList<Pair>> getAdjLst() {
		return adjLstMatrix;
	}

	public int[][] getAdjMatrix() {
		return AdjMatrix;
	}

}
