package com.ds.al.graph.Ops;

import com.ds.al.graph.Entity.Graph;
import com.ds.al.graph.Entity.NodeEdge;
import com.ds.al.graph.Entity.WeightedGraph;
import com.ds.al.graph.Entity.WeightedNodeGraph;

public interface GraphOps {

	public void DFS(Graph g, int v);

	public void BFS(Graph g);

	public void TopologicalSort(Graph g);
	
	public void findUnweightedShortestPath(Graph g,int source);
	
	public void Dijkstra(WeightedGraph g,int source);
	
	public void BellmanFord(NodeEdge g,int source);
	
	public int KruskalMinimalSPT(NodeEdge g);
	
	public int PrimAlgorithmSPT(WeightedNodeGraph g);
	
	public void FloydWarshallMinDist(WeightedNodeGraph g);
	
	public void GetBridgeTarjansAlgorithm(Graph g);
	
	public void GetArticulationPointTarjansAlgorithm(Graph g);

}
