package com.ds.al.graph.utility;

import java.util.ArrayList;

public class DisjointSets {

	private int vertices;

	private ArrayList<Integer> parent = new ArrayList<>();

	private ArrayList<Integer> sizeArr = new ArrayList<>();

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public DisjointSets(int vertices) {
		super();
		this.vertices = vertices;
		for (int i = 0; i < vertices; i++) {
			parent.set(i, i);
			sizeArr.set(i, 1);
		}

	}

	public int findUparent(int node) {
		if (node == parent.get(node))
			return node;
		else {
			int ulp = findUparent(parent.get(node));
			parent.set(node, ulp);
			return ulp;
		}

	}
	
	public void unionbySize(int u,int v)
	{
	
		
		int u_Parent=findUparent(u);
		int v_Parent=findUparent(v);
		if(u_Parent==v_Parent) 
		return;
		int size_u_Parent=sizeArr.get(u_Parent);
		int size_v_Parent=sizeArr.get(v_Parent);
		if(size_u_Parent > size_v_Parent)
		{
			parent.set(v_Parent,u_Parent);
			sizeArr.set(u_Parent,size_u_Parent+size_v_Parent);
		}
		else 
		{
			parent.set(u_Parent,v_Parent);
			sizeArr.set(v_Parent,size_u_Parent+size_v_Parent);
		}
		
		
		
		
	}

}
