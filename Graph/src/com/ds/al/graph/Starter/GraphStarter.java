package com.ds.al.graph.Starter;

import java.util.Scanner;

import com.ds.al.graph.Entity.Graph;
import com.ds.al.graph.Entity.NodeEdge;
import com.ds.al.graph.Ops.GraphOps;
import com.ds.al.graph.Ops.GraphOpsImpl;

public class GraphStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vertices;
		/*Scanner sc = new Scanner(System.in);*/
	   NodeEdge edgeNode=new NodeEdge();
	   edgeNode.setVertices(4);
	   edgeNode.addEdge(0,1,10);
	   edgeNode.addEdge(0,2,6);
	   edgeNode.addEdge(0,3,5);
	   edgeNode.addEdge(1,3,15);
	   edgeNode.addEdge(2,3,4);
	   GraphOps ops=new GraphOpsImpl();
	   ops.KruskalMinimalSPT(edgeNode);

	}

}
