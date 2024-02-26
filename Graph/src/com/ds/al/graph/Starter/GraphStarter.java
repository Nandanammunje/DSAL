package com.ds.al.graph.Starter;

import java.util.Scanner;

import com.ds.al.graph.Entity.Graph;
import com.ds.al.graph.Entity.NodeEdge;
import com.ds.al.graph.Entity.WeightedNodeGraph;
import com.ds.al.graph.Ops.GraphOps;
import com.ds.al.graph.Ops.GraphOpsImpl;

public class GraphStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeightedNodeGraph nodeGraph = new WeightedNodeGraph();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices");
		int vertices = sc.nextInt();
		Graph g = new Graph(vertices);
		g.addEdge(0, 1, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(3, 4, true);
		g.addEdge(4, 0, true);
		g.addEdge(4, 5, true);
		g.addEdge(4, 6, true);
		g.addEdge(5, 6, true);
		g.addEdge(5, 2, true);
		g.addEdge(6, 5, true);
		GraphOps ops = new GraphOpsImpl();
		ops.GetStronglyComponentsTarjanAlgorithm(g);
		sc.close();
	}

}
