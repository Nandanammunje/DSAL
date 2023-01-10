package com.ds.al.graph.Starter;

import java.util.Scanner;

import com.ds.al.graph.Entity.Graph;

public class GraphStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vertices;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices");
		vertices = sc.nextInt();
		Graph g=new Graph(vertices);
		g.addEdge(0, vertices);

	}

}
