package com.ds.al.TreeUtility;

import com.ds.al.tree.TreeEntity;

/**
 * @author nandannayak
 * This is the main class of queue holding tree data
 */
public class QueueEntity {

	private LinkedLstEntity front, rear;

	private int length;

	
	
	/**
	 *  initialization
	 */
	public QueueEntity() {
		front = rear = null;
		length = 0;

	}

	
	
	/**
	 * @param treeNode is the tree data to be pushed into the queue
	 * 
	 */
	public void Enqueue(TreeEntity treeNode) {
		LinkedLstEntity node = new LinkedLstEntity();
		if (front == null) {
			front = node.AddNode(front, treeNode);
			rear = front;

		} else
			rear = node.AddNode(front, treeNode);

		length++;

	}

	/**
	 * @return deletes the first member of the queue
	 * @throws Exception
	 */
	public TreeEntity Dequeue() throws Exception {
		LinkedLstEntity nxtNode;
		TreeEntity currNodeData;

		if (length != 0) {

			currNodeData = front.getNode();
			nxtNode = front.getNext();
			front = nxtNode;
			length--;

			return currNodeData;
		} else {

			throw new Exception("queue is empty");
		}

	}

	/**
	 * @returns the first member of the queue
	 * @throws Exception
	 */
	public TreeEntity getFirst() throws Exception {
		if (length != 0) {
			return front.getNode();
		} else

		{
			throw new Exception("queue is empty");
		}
	}

	/**
	 * @returns the last member of the queue
	 * @throws Exception
	 */
	public TreeEntity getLast() throws Exception {

		if (length != 0) {

			return rear.getNode();
		} else {

			throw new Exception("queue is empty");
		}

	}

}
