package com.ds.al.TreeUtility;

import com.ds.al.tree.TreeEntity;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * @author nandannayak This is the main class of queue holding tree data
 */
public class QueueEntity {

	private LinkedLstEntity front, rear, head;

	private int length;

	/**
	 * initialization of front and rear objects and setting length to zero
	 */
	public QueueEntity() {
		head=front = rear = null;
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
            head=front;
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
    
	/**
	 * @returns True if Queue is empty
	 */
	public  boolean isEmpty() {
		if (length == 0) {
			return TRUE;
		}

		return FALSE;

	}

	/**
	 * @returns the size of the Queue
	 */
	public int getSize()
	{
		return length;
	}
	
	
	
	
	
	
    /**
     * @returns the next node of the queue
     */
    public TreeEntity getNextNode()
    {
    	if(head==null)
    	{
    		head=front;
    	}
    	else
    	{
    		head=head.getNext();
    	}
    	return  head.getNode();
    	
    }
      
	

}
