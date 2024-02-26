package com.ds.al.graph.Entity;

import java.util.LinkedList;

public class Graph {

	private int vertices;

	private LinkedList<Integer> adjLst[];

	public int getVertices() {
		return vertices;
	}

	public Graph(int vertices) {

		this.vertices = vertices;
		adjLst = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++)
			adjLst[i] = new LinkedList<Integer>();

	}

	public LinkedList<Integer>[] getAdjLst() {
		return adjLst;
	}

	public void addEdge(int v, int w, boolean isDirected) {
		adjLst[v].add(w);
		if(!isDirected)
		adjLst[w].add(v);

	}

}
