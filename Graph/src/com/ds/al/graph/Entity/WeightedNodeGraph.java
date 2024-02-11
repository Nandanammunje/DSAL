package com.ds.al.graph.Entity;

import java.util.ArrayList;

import javafx.util.Pair;

public class WeightedNodeGraph {

	private int vertices;

	private ArrayList<ArrayList<Pair<Integer, Integer>>> adjPairMatrix;

	public void addEdge(int source, int destination, int weight) {
		adjPairMatrix.get(source).add(new Pair<Integer, Integer>(destination, weight));
		adjPairMatrix.get(destination).add(new Pair<Integer, Integer>(source, weight));
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
		adjPairMatrix = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			adjPairMatrix.add(new ArrayList<Pair<Integer, Integer>>());
		}
	}

	public ArrayList<ArrayList<Pair<Integer, Integer>>> getAdjLst() {
		return adjPairMatrix;
	}

}
