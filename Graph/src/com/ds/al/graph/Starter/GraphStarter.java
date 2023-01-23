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
		Graph g=new Graph(vertices);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(2,0);
		g.addEdge(2,3);
		g.addEdge(3,3);
		GraphOps ops=new GraphOpsImpl();
		ops.BFS(g);

	}

}
