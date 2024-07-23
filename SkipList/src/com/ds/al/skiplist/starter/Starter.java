package com.ds.al.skiplist.starter;

import java.util.Scanner;

import com.ds.al.skiplist.entity.SkipList;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sListSize,searchNode;
		Scanner sc = new Scanner(System.in);
		SkipList<Integer> sList = new SkipList<>();
		System.out.println("Enter the size of skip list");
		sListSize = sc.nextInt();
		int inArr[] = new int[sListSize];

		for (int i = 0; i < sListSize; i++) {
			System.out.println("Enter the elements of skip list");
			inArr[i] = sc.nextInt();

		}
	

		for (int i : inArr)
		{
			
			sList.insert(i);
		}
		sList.printNodes();
		System.out.println("Enter the search node  ");
		searchNode=sc.nextInt();
		sList.searchNode(searchNode);
		sList.deleteAllNode(searchNode);
		sList.printNodes();
		sc.close();

	}

}
