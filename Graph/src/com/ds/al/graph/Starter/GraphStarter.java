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
		WeightedNodeGraph nodeGraph=new WeightedNodeGraph();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of vertices");
		int vertices=sc.nextInt();
		nodeGraph.setVertices(vertices);
		nodeGraph.addEdge(0,1,5);
		nodeGraph.addEdge(1,2,3);
		nodeGraph.addEdge(0,2,1);
		
	}

}
