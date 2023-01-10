package com.ds.al.graph.Ops;

import java.util.LinkedList;
import java.util.ListIterator;

import com.ds.al.graph.Entity.Graph;

public class GraphOpsImpl implements GraphOps {

	@Override
	public void DFS(Graph g, int v) {
		// TODO Auto-generated method stub

		boolean visited[] = new boolean[g.getVertices()];
		doDfs(0, g.getAdjLst(), visited);
	}

	@Override
	public void BFS(Graph g) {
		// TODO Auto-generated method stub

	}

	private void doDfs(int v, LinkedList<Integer> adj[], boolean visited[]) {

		visited[v] = true;
		System.out.println(v + " ");
		ListIterator<Integer> vertexIterator = adj[v].listIterator();
		while (vertexIterator.hasNext()) {
			int vertex = vertexIterator.next();
			if (!visited[vertex]) {
				doDfs(vertex, adj, visited);
			}
		}

	}

}
