package com.ds.al.skiplist.entity;

import java.util.Random;

public class SkipList<T extends Comparable<T>> {

	private SkipNode<T> headNode = new SkipNode<T>(null);
	private Random rand = new Random();

	public void insert(T data) {
		SkipNode<T> node = new SkipNode<T>(data);
		for (int i = 0; i < 5; i++) {
			if (rand.nextInt((int) Math.pow(2, i)) == 0) {
				headNode.insertSkipNode(node, i);
			}
		}
	}

	public void printNodes() {
		for (int i = 4; i >= 0; i--) {

			headNode.printSkipNodes(i);
		}

	}

	public boolean searchNode(T data) {
		boolean isFound = false;
		for (int i = 4; i >= 0; i--) {

			SkipNode<T> searchSkipNode = headNode.searchSkipNode(data, i);
			if (searchSkipNode != null) {
				System.out.println("data " + searchSkipNode.data + " found at level " + i);
				isFound = true;
			}

		}
		if (!isFound) {
			System.out.println("data " + data + " not present in skip list ");
		}
		return isFound;

	}

	public boolean deleteFirstNode(T data) {
		boolean isDeleted = false;
		for (int i = 4; i >= 0; i--) {
			isDeleted = headNode.deleteFirstSkipNode(i, data);

		}
		return isDeleted;
	}
	public boolean deleteAllNode(T data)
	{
		boolean isDeleted = false;
		for (int i = 4; i >= 0; i--) {
			isDeleted = headNode.deleteAllSkipNode(i, data);

		}
		return isDeleted;
	}

}
