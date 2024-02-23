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
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(4, 6);
		g.addEdge(6, 5);
		GraphOps ops = new GraphOpsImpl();
		ops.GetArticulationPointTarjansAlgorithm(g);
	}

}
