package com.ds.al.graph.Starter;

import java.util.Scanner;

import com.ds.al.graph.Entity.Graph;
import com.ds.al.graph.Ops.GraphOps;
import com.ds.al.graph.Ops.GraphOpsImpl;

public class GraphStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vertices;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices");
		vertices = sc.nextInt();
		Graph g = new Graph(vertices);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 0);
		g.addEdge(2, 5);
		g.addEdge(3,5);
		g.addEdge(3,6);
		g.addEdge(4,6);
		g.addEdge(5,6);
		GraphOps ops = new GraphOpsImpl();
		ops.findUnweightedShortestPath(g,0);

	}

}
