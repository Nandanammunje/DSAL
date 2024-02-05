package com.ds.al.graph.Ops;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Stack;

import com.ds.al.graph.Entity.Graph;
import com.ds.al.graph.Entity.Node;
import com.ds.al.graph.Entity.NodeEdge;
import com.ds.al.graph.Entity.NodeGraph;
import com.ds.al.graph.Entity.WeightedGraph;
import com.ds.al.graph.utility.DisjointSets;
import com.ds.al.graph.utility.WeightComparartor;

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

	@Override
	public void TopologicalSort(Graph g) {
		// TODO Auto-generated method stub

		boolean visited[] = new boolean[g.getVertices()];
		Stack<Integer> nodeStack = new Stack<Integer>();
		for (int i = 0; i < g.getVertices(); i++) {
			if (!visited[i])
				doTopologicalSort(i, g.getAdjLst(), visited, nodeStack);
		}
		while (!nodeStack.isEmpty()) {
			System.out.println(nodeStack.pop());
		}
	}

	@Override
	public void findUnweightedShortestPath(Graph g, int source) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[g.getVertices()];
		dofindUnweightedShortestPath(source, g.getAdjLst(), visited);
	}

	private void doBfs(int v, LinkedList<Integer> adj[], boolean visited[]) {

		Deque<Integer> nodeQueue = new ArrayDeque<Integer>();
		visited[v] = true;
		nodeQueue.add(v);

		while (!nodeQueue.isEmpty()) {
			int nodeVert = nodeQueue.poll();
			System.out.println("Visited node " + nodeVert);
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

	private void doTopologicalSort(int v, LinkedList<Integer> adj[], boolean visited[], Stack<Integer> nodeTopoStack) {
		visited[v] = true;
		ListIterator<Integer> nodeListIterator = adj[v].listIterator();
		while (nodeListIterator.hasNext()) {
			int nearNode = nodeListIterator.next();
			if (!visited[nearNode])
				doTopologicalSort(nearNode, adj, visited, nodeTopoStack);
		}
		nodeTopoStack.push(v);
	}

	private void dofindUnweightedShortestPath(int source, LinkedList<Integer> adj[], boolean visited[]) {

		int distanceArr[] = new int[adj.length];
		for (int i = 0; i < distanceArr.length; i++)
			distanceArr[i] = -1;
		distanceArr[source] = 0;
		Deque<Integer> nodeQueue = new ArrayDeque<Integer>();
		nodeQueue.push(source);
		while (!nodeQueue.isEmpty()) {
			int popNode = nodeQueue.poll();
			ListIterator<Integer> listIterator = adj[popNode].listIterator();
			while (listIterator.hasNext()) {
				int childNode = listIterator.next();
				if (distanceArr[childNode] == -1) {
					distanceArr[childNode] = distanceArr[popNode] + 1;
					nodeQueue.add(childNode);
				}

			}
		}
	}

	@Override
	public void Dijkstra(WeightedGraph g, int source) {
		// TODO Auto-generated method stub
		int dist[] = new int[g.getVertices()];

		for (int i : dist)
			dist[i] = Integer.MAX_VALUE;
		dist[source] = 0;

		PriorityQueue<NodeGraph> nodeLst = new PriorityQueue<NodeGraph>();
		nodeLst.add(new NodeGraph(source, 0));
		while (!nodeLst.isEmpty()) {
			NodeGraph currSourceNode = nodeLst.poll();

			for (NodeGraph it : g.getAdjLst().get(currSourceNode.getVertice())) {
				if (dist[it.getVertice()] > dist[currSourceNode.getVertice()] + it.getWeight()) {
					dist[it.getVertice()] = dist[currSourceNode.getVertice()] + it.getWeight();
					nodeLst.add(new NodeGraph(it.getVertice(), dist[it.getVertice()]));
				}

			}
		}

	}

	@Override
	public void BellmanFord(NodeEdge g, int source) {
		// TODO Auto-generated method stub
		int dist[] = new int[g.getVertices()];
		for (int i : dist)
			dist[i] = Integer.MAX_VALUE;
		dist[source] = 0;

		ArrayList<Node> edgeLst = g.getEdgeLst();
		for (int i = 0; i < g.getVertices() - 1; i++) {

			for (Node node : edgeLst) {
				int start = node.getSource();
				int dest = node.getDest();
				int weight = node.getWeight();
				if (dist[start] + weight < dist[dest]) {
					dist[dest] = dist[start] + weight;
				}
			}
		}

	}

	@Override
	public int KruskalMinimalSPT(NodeEdge g) {
		// TODO Auto-generated method stub

		ArrayList<Node> edgeLst = g.getEdgeLst();
		edgeLst.sort(new WeightComparartor());
		DisjointSets set = new DisjointSets(g.getVertices());
		int weight = 0;
		for (Node node : edgeLst) {
			if (set.findUparent(node.getSource()) != set.findUparent(node.getDest())) {

				set.unionbySize(node.getSource(), node.getDest());
				weight = weight + node.getWeight();

			}
		}
		return weight;

	}

}
