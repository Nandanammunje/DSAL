package com.ds.al.graph.Ops;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.net.ssl.SSLContext;

import com.ds.al.graph.Entity.Graph;
import com.ds.al.graph.Entity.Node;
import com.ds.al.graph.Entity.NodeEdge;
import com.ds.al.graph.Entity.NodeGraph;
import com.ds.al.graph.Entity.Pair;
import com.ds.al.graph.Entity.WeightedGraph;
import com.ds.al.graph.Entity.WeightedNodeGraph;
import com.ds.al.graph.utility.DisjointSets;
import com.ds.al.graph.utility.WeightComparartor;
import static com.ds.al.graph.utility.GraphUtility.isElementinDequeue;

public class GraphOpsImpl implements GraphOps {

	private ArrayList<List<Integer>> bridgeLst;
	private ArrayList<Integer> articulationVertices;
	private int nodeOrderCounter;
	private Deque<Integer> dfsNodeStack;
	private LinkedList<Integer> sccLst[];
	private int sccLstCounter;

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

	private void doDfsMarker(int node, boolean visited[], LinkedList<Integer>[] adjLst, int parentNode,
			int dfsIndexLst[], int lowdfsIndex[]) {
		System.out.println("VisitedNode " + node);
		visited[node] = true;
		nodeOrderCounter++;
		dfsIndexLst[node] = lowdfsIndex[node] = nodeOrderCounter;
		for (Integer it : adjLst[node]) {
			if (it == parentNode)
				continue;
			else {
				if (!visited[it]) {
					doDfsMarker(it, visited, adjLst, node, dfsIndexLst, lowdfsIndex);
					lowdfsIndex[node] = Math.min(lowdfsIndex[node], lowdfsIndex[it]);
					if (lowdfsIndex[it] > dfsIndexLst[node]) {
						bridgeLst.add(Arrays.asList(it, node));
					}

				} else {
					lowdfsIndex[node] = Math.min(lowdfsIndex[node], lowdfsIndex[it]);
				}

			}

		}
	}

	private void DoDFSMarkerChildNodes(int node, int parentNode, boolean visited[], LinkedList<Integer>[] adjLst,
			int dfsIndxLst[], int lowdfsIndex[]) {
		int child = 0;
		System.out.println("Node is " + node);
		visited[node] = true;
		nodeOrderCounter++;
		dfsIndxLst[node] = lowdfsIndex[node] = nodeOrderCounter;
		for (Integer it : adjLst[node]) {
			if (it == parentNode)
				continue;

			else {
				if (!visited[it]) {

					DoDFSMarkerChildNodes(it, node, visited, adjLst, dfsIndxLst, lowdfsIndex);
					child++;
					lowdfsIndex[node] = Math.min(lowdfsIndex[node], lowdfsIndex[it]);
					if (dfsIndxLst[node] <= lowdfsIndex[it] && parentNode != -1) {
						articulationVertices.add(node);
					}
				} else {
					lowdfsIndex[node] = Math.min(lowdfsIndex[node], dfsIndxLst[it]);
				}

			}

		}
		if (parentNode == -1 && child > 1) {
			articulationVertices.add(node);
		}

	}

	private void DoDFSMarkerScc(int node, int parentNode, boolean visited[], LinkedList<Integer>[] adjLst, int dfsLst[],
			int lowdfsIndxLst[]) {

		System.out.println("Current Node is " + node);
		visited[node] = true;
		nodeOrderCounter++;
		lowdfsIndxLst[node] = dfsLst[node] = nodeOrderCounter;
		for (Integer itNode : adjLst[node]) {
			if (itNode == parentNode)
				continue;
			else {
				if (!visited[itNode]) {
					dfsNodeStack.push(itNode);
					DoDFSMarkerScc(itNode, parentNode, visited, adjLst, dfsLst, lowdfsIndxLst);
					lowdfsIndxLst[node] = Math.min(lowdfsIndxLst[node], lowdfsIndxLst[itNode]);
					

				} else {
					if (isElementinDequeue(dfsNodeStack, itNode))
						lowdfsIndxLst[node] = Math.min(lowdfsIndxLst[node], dfsLst[itNode]);

				}

			}

		}
		if (lowdfsIndxLst[node] == dfsLst[node]) {
			sccLst[sccLstCounter] = new LinkedList<Integer>();
			int dfsStackTopNode = 0;
			do {
				dfsStackTopNode = dfsNodeStack.pop();
				sccLst[sccLstCounter].add(dfsStackTopNode);
			} while (dfsStackTopNode != node);
			sccLstCounter++;
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

	@Override
	public int PrimAlgorithmSPT(WeightedNodeGraph g) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Pair>> adjLst = g.getAdjLst();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		int visitedNode[] = new int[g.getVertices()];
		pq.add(new Pair(0, 0));
		int sumWeight = 0;
		while (!pq.isEmpty()) {
			Pair polledNode = pq.poll();
			int nextVertice = polledNode.getVertice();
			int verticeWeight = polledNode.getWeight();
			if (visitedNode[nextVertice] == 1)
				continue;
			sumWeight = sumWeight + verticeWeight;
			visitedNode[nextVertice] = 1;
			for (Pair node : adjLst.get(nextVertice)) {
				if (visitedNode[node.getVertice()] != 1)
					pq.add(new Pair(node.getVertice(), node.getWeight()));

			}

		}
		return sumWeight;
	}

	@Override
	public void FloydWarshallMinDist(WeightedNodeGraph g) {
		// TODO Auto-generated method stub
		int[][] adjMatrix = g.getAdjMatrix();
		for (int k = 0; k < g.getVertices(); k++) {
			for (int i = 0; i < g.getVertices(); i++) {
				for (int j = 0; j < g.getVertices(); j++) {
					adjMatrix[i][j] = Math.max(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
				}

			}

		}

	}

	@Override
	public void GetBridgeTarjansAlgorithm(Graph g) {
		// TODO Auto-generated method stub
		bridgeLst = new ArrayList<List<Integer>>();
		int dfIndeXLst[] = new int[g.getVertices()];
		int lowdfsIndex[] = new int[g.getVertices()];
		boolean visited[] = new boolean[g.getVertices()];
		doDfsMarker(0, visited, g.getAdjLst(), -1, dfIndeXLst, lowdfsIndex);

	}

	@Override
	public void GetArticulationPointTarjansAlgorithm(Graph g) {
		// TODO Auto-generated method stub
		articulationVertices = new ArrayList<Integer>();
		boolean visited[] = new boolean[g.getVertices()];
		int dfsIndexLst[] = new int[g.getVertices()];
		int lowdfsIndexLst[] = new int[g.getVertices()];
		DoDFSMarkerChildNodes(0, -1, visited, g.getAdjLst(), dfsIndexLst, lowdfsIndexLst);

	}

	@Override
	public void GetStronglyComponentsTarjanAlgorithm(Graph g) {
		// TODO Auto-generated method stub
		nodeOrderCounter = -1;
		dfsNodeStack = new ArrayDeque<Integer>();
		dfsNodeStack.push(0);
		sccLst = new LinkedList[g.getVertices()];
		int lowdfsIndxLst[] = new int[g.getVertices()];
		int dfsIndxLst[] = new int[g.getVertices()];
		boolean visited[] = new boolean[g.getVertices()];
		DoDFSMarkerScc(0, -1, visited, g.getAdjLst(), dfsIndxLst, lowdfsIndxLst);

	}

}
