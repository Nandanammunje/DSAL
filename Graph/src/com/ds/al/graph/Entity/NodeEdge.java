package com.ds.al.graph.Entity;

import java.util.ArrayList;

public class NodeEdge {

	private int vertices;

	private ArrayList<Node> nodeEdgeLst;

	public NodeEdge() {
		nodeEdgeLst = new ArrayList<Node>();
	}

	public int getVertices() {

		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
		if (nodeEdgeLst == null)
			nodeEdgeLst = new ArrayList<Node>();

	}

	public void addEdge(int u, int v, int w) {
		if (nodeEdgeLst == null)
			nodeEdgeLst = new ArrayList<Node>();
		Node node = new Node(u, v, w);
		nodeEdgeLst.add(node);

	}

	public ArrayList<Node> getEdgeLst() {
		return nodeEdgeLst;
	}

}
