package com.ds.al.graph.Ops;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ListIterator;

import com.ds.al.graph.Entity.Graph;

public class GraphOpsImpl implements GraphOps {

	@Override
	public void DFS(Graph g, int v) {
		// TODO Auto-generated method stub

		boolean visited[] = new boolean[g.getVertices()];
		doDfs(1, g.getAdjLst(), visited);
	}

	@Override
	public void BFS(Graph g) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[g.getVertices()];
		doBfs(2, g.getAdjLst(), visited);

	}

	private void doBfs(int v, LinkedList<Integer> adj[], boolean visited[]) {

		Deque<Integer> nodeQueue = new ArrayDeque<Integer>();
		visited[v] = true;
		nodeQueue.add(v);

		while (!nodeQueue.isEmpty()) {
			int nodeVert = nodeQueue.pop();
			System.out.println("Visited node "+nodeVert);
			ListIterator<Integer> listIterator = adj[nodeVert].listIterator();
			while (listIterator.hasNext()) {
				Integer node = listIterator.next();
				if (!visited[node]) {
					visited[node] = true;
					nodeQueue.add(node);
				}

			}

		}

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
