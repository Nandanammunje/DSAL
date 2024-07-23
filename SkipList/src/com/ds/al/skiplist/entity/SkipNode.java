package com.ds.al.skiplist.entity;

public class SkipNode<T extends Comparable<T>> {

	T data;
	SkipNode[] nextRefNode = new SkipNode[5];

	public SkipNode(T data) {

		this.data = data;
	}

	public void setNextNode(SkipNode next, int level) {
		this.nextRefNode[level] = next;
	}

	public SkipNode getNextSkipNode(int level) {
		return this.nextRefNode[level];
	}

	public void insertSkipNode(SkipNode node, int level) {
		boolean isFit = false;
		SkipNode currSkipNode = this.getNextSkipNode(level);
		if (currSkipNode == null) {
			this.setNextNode(node, level);
			return;
		}
		if (node.data.compareTo(currSkipNode.data) < 1) {
			this.setNextNode(node, level);
			node.setNextNode(currSkipNode, level);
			return;
		} else {
			while (currSkipNode.getNextSkipNode(level) != null) {
				if (currSkipNode.data.compareTo(node.data) < 1
						&& node.data.compareTo(currSkipNode.getNextSkipNode(level).data) < 1) {
					SkipNode nextSkipNode = currSkipNode.getNextSkipNode(level);
					currSkipNode.setNextNode(node, level);
					node.setNextNode(nextSkipNode, level);
					isFit = true;
					break;
				}
				currSkipNode = currSkipNode.getNextSkipNode(level);

			}
			if (!isFit) {
				currSkipNode.setNextNode(node, level);
				node.setNextNode(null, level);
			}
		}
	}

	public SkipNode<T> searchSkipNode(T data, int level) {
		SkipNode<T> currNode = this.getNextSkipNode(level);
		while (currNode != null) {
			if (currNode.data.compareTo(data) == 0) {
				break;
			}
			if (data.compareTo(currNode.data) < 1) {
				currNode = null;
				break;
			}
			currNode = currNode.getNextSkipNode(level);
		}
		return currNode;

	}

	public boolean deleteFirstSkipNode(int level, T data) {
		SkipNode nextSkipNode = this.getNextSkipNode(level);
		SkipNode prevSkipNode = this;
		boolean isFound = false;
		while (nextSkipNode != null) {
			if (nextSkipNode.data.compareTo(data) == 0) {

				isFound = true;
				break;

			} else if (nextSkipNode.data.compareTo(data) > 0) {
				break;
			}

			else {
				prevSkipNode = nextSkipNode;
				nextSkipNode = nextSkipNode.getNextSkipNode(level);
			}

		}
		if (isFound) {
			prevSkipNode.setNextNode(nextSkipNode.getNextSkipNode(level), level);
			nextSkipNode = null;
		}
		return isFound;
	}

	public boolean deleteAllSkipNode(int level, T data) {
		boolean isFound = false;
		SkipNode nextSkipNode = this.getNextSkipNode(level);
		SkipNode prevSkipNode = this;
		SkipNode nextnode;

		while (nextSkipNode != null) {
			if (nextSkipNode.data.compareTo(data) == 0) {
				isFound = true;
				while (nextSkipNode != null && nextSkipNode.data.compareTo(data) == 0)
					nextSkipNode = nextSkipNode.getNextSkipNode(level);
				break;

			} else if (nextSkipNode.data.compareTo(data) > 0) {
				break;
			} else {
				prevSkipNode = nextSkipNode;
				nextSkipNode = nextSkipNode.getNextSkipNode(level);
			}

		}
		if (isFound)
			prevSkipNode.setNextNode(nextSkipNode, level);

		return isFound;

	}

	public void printSkipNodes(int level) {
		SkipNode<T> currNode = this.getNextSkipNode(level);

		while (currNode != null) {
			System.out.println(" data in level " + level + " " + currNode.data);
			currNode = currNode.getNextSkipNode(level);

		}

	}

}
