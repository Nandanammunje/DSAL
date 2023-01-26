package com.ds.al.graph.Ops;

import com.ds.al.graph.Entity.Graph;

public interface GraphOps {

	public void DFS(Graph g, int v);

	public void BFS(Graph g);

	public void TopologicalSort(Graph g);

}
