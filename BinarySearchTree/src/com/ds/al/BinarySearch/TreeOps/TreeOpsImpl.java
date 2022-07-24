package com.ds.al.BinarySearch.TreeOps;

import static com.ds.al.util.Utility.compareCharacter;
import static com.ds.al.util.Utility.compareCharacterInt;
import static com.ds.al.util.Utility.compareStrInt;
import static com.ds.al.util.Utility.getMaxInt;
import static com.ds.al.util.Utility.getMedian;
import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.Stack;

import com.ds.al.BinarySearch.TreeEntity.BinarySearchTreeEntity;
import com.ds.al.BinarySearch.TreeEntity.LinkedBinarySearchTree;
import com.ds.al.BinarySearch.TreeEntity.QueueEntity;
import com.ds.al.Circular.DoubleLinkedLstEntity.CircularDoubleLinkedLstEntity;
import com.ds.al.DoubleLinkedLstEntity.DoubleLinkedLst;
import com.ds.al.Threaded.TreeEntity.ThreadedBinaryTreeEntity;
import com.ds.al.util.Utility;

public class TreeOpsImpl implements TreeOps {

	private BinarySearchTreeEntity root;
	private BinarySearchTreeEntity foundNode;
	private BinarySearchTreeEntity minNode;
	private BinarySearchTreeEntity maxNode;
	private CircularDoubleLinkedLstEntity head;
	private CircularDoubleLinkedLstEntity prevLstNode;
	private DoubleLinkedLst prevNodeLst;
	private DoubleLinkedLst headLinked;
	private ThreadedBinaryTreeEntity threadedRoot;
	private Stack<ThreadedBinaryTreeEntity> predessorNode;
	private Stack<ThreadedBinaryTreeEntity> successorNode;

	public DoubleLinkedLst getHeadLinked() {
		return headLinked;
	}

	public void setHeadLinked(DoubleLinkedLst headLinked) {
		this.headLinked = headLinked;
	}

	private int count = 0;
	private Utility util;

	public TreeOpsImpl() {

		util = new Utility();
	}

	public void createBinarySearchTree(String data) {

		if (root == null) {
			root = new BinarySearchTreeEntity();
			threadedRoot = new ThreadedBinaryTreeEntity();
			threadedRoot.setData(data);
			threadedRoot.setlTag(0);
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
			return;
		}

		else {
			predessorNode = new Stack<ThreadedBinaryTreeEntity>();
			successorNode = new Stack<ThreadedBinaryTreeEntity>();
			predessorNode.push(null);
			successorNode.push(null);
			mkBinaryTree(root, root, data, true);
			/*
			 * mkBinaryThreadedTree(threadedRoot, threadedRoot, data, true);
			 * createThreadedlinks(threadedRoot);
			 */
		}

	}

	public void createThreadedBinarySearchTree(String data) {

		if (threadedRoot == null) {

			threadedRoot = new ThreadedBinaryTreeEntity();
			threadedRoot.setData(data);
			threadedRoot.setlTag(0);
			threadedRoot.setrTag(0);
			return;
		}

		else {

			predessorNode = new Stack<ThreadedBinaryTreeEntity>();
			successorNode = new Stack<ThreadedBinaryTreeEntity>();
			predessorNode.push(null);
			successorNode.push(null);
			mkBinaryThreadedTree(threadedRoot, threadedRoot, data, true);

		}

	}

	private void mkBinaryTree(BinarySearchTreeEntity parent, BinarySearchTreeEntity node, String data, boolean isLeft) {

		if (node != null) {

			if (compareCharacter(node.getData(), data)) {
				mkBinaryTree(node, node.getLeft(), data, true);
			} else {
				mkBinaryTree(node, node.getRight(), data, false);
			}
		} else {
			node = new BinarySearchTreeEntity();
			node.setData(data);
			node.setLeft(null);
			node.setRight(null);
			if (isLeft)
				parent.setLeft(node);
			else
				parent.setRight(node);

		}

	}

	private void mkBinaryThreadedTree(ThreadedBinaryTreeEntity parent, ThreadedBinaryTreeEntity node, String data,
			boolean isLeft) {

		if (node != null) {

			if (compareCharacter(node.getData(), data)) {
				mkBinaryThreadedTree(node, node.getLeft(), data, true);
			} else {
				mkBinaryThreadedTree(node, node.getRight(), data, false);
			}
		} else {
			node = new ThreadedBinaryTreeEntity();
			node.setData(data);
			node.setLeft(null);
			node.setRight(null);
			node.setlTag(0);
			node.setrTag(0);
			if (isLeft) {
				parent.setlTag(1);
				parent.setLeft(node);
			} else {
				parent.setRight(node);
				parent.setrTag(1);
			}
		}

	}

	private void createThreadedlinks(ThreadedBinaryTreeEntity node) {

		if (node != null) {
			if (node.getlTag() == 1) {
				successorNode.push(node);
				createThreadedlinks(node.getLeft());
			}

			if (node.getlTag() == 0) {
				node.setLeft(predessorNode.peek());
			}

			if (successorNode.peek() == node)
				successorNode.pop();

			if (node.getrTag() == 0) {

				node.setRight(successorNode.peek());
			}
			predessorNode.push(node);

			if (node.getrTag() == 1) {

				createThreadedlinks(node.getRight());

			}
		}
		return;

	}

	public void searchBSTNode(BinarySearchTreeEntity node, String data) {

		if (node == null)
			return;
		if (node.getData().equalsIgnoreCase(data)) {
			foundNode = node;
			return;
		} else {
			if (compareCharacter(node.getData().charAt(0), data.charAt(0)))
				searchBSTNode(node.getLeft(), data);
			else
				searchBSTNode(node.getRight(), data);

		}

	}

	public void setMinimumNode(BinarySearchTreeEntity node) {
		if (node != null) {
			minNode = node;
			setMinimumNode(node.getLeft());
		}

		else
			return;
	}

	public void setMaximumNode(BinarySearchTreeEntity node) {
		if (node != null) {
			maxNode = node;
			setMaximumNode(node.getRight());
		} else
			return;

	}

	public String createPathString(String bstNode, String dataStr, BinarySearchTreeEntity node) {
		if (node == null)
			return dataStr;
		int charComparVal = compareCharacterInt(bstNode.charAt(0), node.getData().charAt(0));
		if (charComparVal > 0) {
			dataStr = dataStr + node.getData() + createPathString(bstNode, dataStr, node.getRight());

		} else if (charComparVal < 0) {
			dataStr = dataStr + node.getData() + createPathString(bstNode, dataStr, node.getLeft());
		} else {
			dataStr = dataStr + node.getData();
		}

		return dataStr;
	}

	public int getDistFromLCA(String nodePath1, String nodePath2) {
		int loopLength = (nodePath1.length() > nodePath2.length()) ? nodePath2.length() : nodePath1.length();
		int comparIndex = 0;
		for (int i = 0; i < loopLength; i++) {
			if (compareCharacterInt(nodePath1.charAt(i), nodePath2.charAt(i)) == 0) {
				comparIndex = i;

			}
		}
		comparIndex = 2 * comparIndex;
		int nodeDistance = nodePath1.length() + nodePath2.length() - comparIndex - 2;
		return nodeDistance;

	}

	public void inorderTraverseConvert(CircularDoubleLinkedLstEntity prevNode, BinarySearchTreeEntity root) {

		if (root != null) {
			inorderTraverseConvert(prevNode, root.getLeft());
			initializeLst(root.getData());
			inorderTraverseConvert(prevNode, root.getRight());
		}

	}

	public void initializeLst(String data)

	{
		CircularDoubleLinkedLstEntity currNode;
		if (head == null) {
			head = new CircularDoubleLinkedLstEntity();
			head.setData(data);
			head.setNext(head);
			head.setPrev(null);
			currNode = head;
		} else {
			CircularDoubleLinkedLstEntity node = new CircularDoubleLinkedLstEntity();
			node.setData(data);
			node.setPrev(prevLstNode);
			prevLstNode.setNext(node);
			node.setNext(head);
			currNode = node;

		}
		prevLstNode = currNode;

	}

	public void generateBalancedBST(BinarySearchTreeEntity node, DoubleLinkedLst head, boolean isLeft) {
		if (head == null)
			return;

		DoubleLinkedLst midNode = getMedian(head);
		BinarySearchTreeEntity parentNode;
		if (root == null) {
			root = new BinarySearchTreeEntity();
			root.setData(midNode.getData());
			root.setLeft(null);
			root.setRight(null);
			parentNode = root;
		} else {
			BinarySearchTreeEntity treeNode = new BinarySearchTreeEntity();
			treeNode.setData(midNode.getData());
			if (isLeft)
				node.setLeft(treeNode);
			else
				node.setRight(treeNode);
			parentNode = treeNode;
		}
		DoubleLinkedLst leftHead = head;
		DoubleLinkedLst rightHead = midNode.getNxt();

		if (rightHead != null)
			midNode.getNxt().setPrev(null);

		if (midNode == leftHead)
			leftHead = null;
		else
			midNode.getPrev().setNxt(null);

		generateBalancedBST(parentNode, leftHead, true);
		generateBalancedBST(parentNode, rightHead, false);

	}

	public int getDoubleLinkedLstLength(DoubleLinkedLst head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.getNxt();
		}
		return count;
	}

	public BinarySearchTreeEntity createBinaryTreeOptimized(int start, int end, DoubleLinkedLst node) {

		if (start > end)
			return null;
		int midCorrector = (end - start) % 2;
		int mid = start + (end - start + midCorrector) / 2;
		BinarySearchTreeEntity treeLeft = createBinaryTreeOptimized(start, mid - 1, node);
		BinarySearchTreeEntity treeRoot = new BinarySearchTreeEntity();
		treeRoot.setData(node.getData());
		if (node.getNxt() != null) {
			DoubleLinkedLst nxt = node.getNxt();
			node.setData(nxt.getData());
			node.setNxt(nxt.getNxt());
		}
		treeRoot.setLeft(treeLeft);
		BinarySearchTreeEntity treeRight = createBinaryTreeOptimized(mid + 1, end, node);
		treeRoot.setRight(treeRight);

		return treeRoot;
	}

	public void smallestKthNode(BinarySearchTreeEntity node, int count, int rank) {
		if (node == null || count > rank)
			return;
		smallestKthNode(node.getLeft(), this.count, rank);
		this.count++;
		if (this.count == rank) {
			foundNode = node;
			return;
		}
		smallestKthNode(node.getRight(), this.count, rank);

	}

	public BinarySearchTreeEntity getCeil(int key, BinarySearchTreeEntity node) {
		BinarySearchTreeEntity ceilNode = null;
		if (node == null || key == Integer.parseInt(node.getData()))
			return node;
		if (key < Integer.parseInt(node.getData()))
			ceilNode = getCeil(key, node.getLeft());
		else
			ceilNode = getCeil(key, node.getRight());

		if (ceilNode == null && key < Integer.parseInt(node.getData())) {

			ceilNode = node;

		}

		return ceilNode;

	}

	public BinarySearchTreeEntity getFloorNode(BinarySearchTreeEntity node, int key) {

		BinarySearchTreeEntity floorNode = null;
		if (node == null || Integer.parseInt(node.getData()) == key)
			return node;
		if (key < Integer.parseInt(node.getData()))
			floorNode = getFloorNode(node.getLeft(), key);
		else
			floorNode = getFloorNode(node.getRight(), key);

		if (floorNode == null && key > Integer.parseInt(node.getData())) {
			floorNode = node;
		}

		return floorNode;
	}

	public boolean findSearchNode(BinarySearchTreeEntity node, int searchNode) {
		boolean nodeExist = false;
		if (node == null)
			return false;
		int bstNode = Integer.parseInt(node.getData());
		if (searchNode == bstNode)
			return true;

		if (searchNode > bstNode)
			nodeExist = findSearchNode(node.getRight(), searchNode);
		else
			nodeExist = findSearchNode(node.getLeft(), searchNode);

		return nodeExist;
	}

	public void inorderTraverse(BinarySearchTreeEntity nodeA, BinarySearchTreeEntity nodeB,
			ArrayList<String> commonNodes) {

		if (nodeA == null)
			return;
		inorderTraverse(nodeA.getLeft(), nodeB, commonNodes);
		if (findSearchNode(nodeB, Integer.parseInt(nodeA.getData())))
			commonNodes.add(nodeA.getData());
		inorderTraverse(nodeA.getRight(), nodeB, commonNodes);

	}

	public void convert2DLL(BinarySearchTreeEntity node) {
		if (node == null)
			return;

		convert2DLL(node.getLeft());
		if (headLinked == null) {
			headLinked = new DoubleLinkedLst();
			headLinked.setData(node.getData());
			headLinked.setPrev(prevNodeLst);
			headLinked.setNxt(null);
			prevNodeLst = headLinked;
		} else {
			DoubleLinkedLst linkedNode = new DoubleLinkedLst();
			linkedNode.setData(node.getData());
			linkedNode.setPrev(prevNodeLst);
			prevNodeLst.setNxt(linkedNode);
			prevNodeLst = linkedNode;
		}
		convert2DLL(node.getRight());

	}

	private ThreadedBinaryTreeEntity findInorderSuccessor(ThreadedBinaryTreeEntity node,
			ThreadedBinaryTreeEntity root) {
		if (node == null)
			return null;
		if (node.getrTag() == 0) {
			return node.getRight();
		}
		node = node.getRight();
		while (node.getlTag() != 0) {
			node = node.getLeft();
		}

		return node;

	}

	private ThreadedBinaryTreeEntity findInorderPredessor(ThreadedBinaryTreeEntity node,
			ThreadedBinaryTreeEntity root) {
		if (node == null)
			return null;
		if (node.getlTag() == 0)
			return node.getLeft();
		ThreadedBinaryTreeEntity successorInorderNode = node.getLeft();
		ThreadedBinaryTreeEntity currentInorderNode = null;
		while (node != successorInorderNode) {
			currentInorderNode = successorInorderNode;
			successorInorderNode = findInorderSuccessor(successorInorderNode, root);
		}

		return currentInorderNode;

	}

	private void findNodesinRange(ThreadedBinaryTreeEntity node, int k1, int k2) {

		if (node == null)
			return;

		ThreadedBinaryTreeEntity rangeNode = node;
		int nodeData = Integer.parseInt(node.getData());
		while (nodeData >= k1) {

			if (nodeData < k2)
				System.out.println(nodeData);
			rangeNode = findInorderPredessor(rangeNode, node);
			nodeData = (rangeNode == null) ? k1 - 1 : Integer.parseInt(rangeNode.getData());

		}

		rangeNode = findInorderSuccessor(node, rangeNode);
		nodeData = (rangeNode == null) ? k2 + 1 : Integer.parseInt(rangeNode.getData());
		while (nodeData < k2) {
			if (nodeData > k1)
				System.out.println(nodeData);

			rangeNode = findInorderSuccessor(rangeNode, node);
			nodeData = (rangeNode == null) ? k2 + 1 : Integer.parseInt(rangeNode.getData());

		}

	}

	@Override
	public DoubleLinkedLst convertBST2DLL(BinarySearchTreeEntity node) {
		convert2DLL(node);
		return this.getHeadLinked();
	}

	@Override
	public BinarySearchTreeEntity createBST(String dataStr[]) {
		// TODO Auto-generated method stub
		/*
		 * for (int i = 0; i < dataStr.length(); i++) {
		 * createBinarySearchTree(Character.toString(dataStr.charAt(i))); }
		 */
		for (String itr : dataStr)
			createBinarySearchTree(itr);

		return root;
	}

	@Override
	public int findShortestPath(String bstNodeFirst, String bstNodeSecond) {
		// TODO Auto-generated method stub
		String nodePath1 = "";
		String nodePath2 = "";
		nodePath1 = nodePath1 + createPathString(bstNodeFirst, nodePath1, root);
		nodePath2 = nodePath2 + createPathString(bstNodeSecond, nodePath2, root);
		int shortestPath = getDistFromLCA(nodePath1, nodePath2);

		return shortestPath;
	}

	@Override
	public BinarySearchTreeEntity findNode(String dataStr) {
		// TODO Auto-generated method stub
		searchBSTNode(root, dataStr);
		return foundNode;
	}

	@Override
	public BinarySearchTreeEntity findMinimumNode() {
		// TODO Auto-generated method stub
		setMinimumNode(root);

		return minNode;
	}

	@Override
	public BinarySearchTreeEntity findMaximumNode() {
		// TODO Auto-generated method stub
		setMaximumNode(root);
		return maxNode;
	}

	@Override
	public CircularDoubleLinkedLstEntity convertBST2CDLL() {
		// TODO Auto-generated method stub
		inorderTraverseConvert(head, root);

		return head;
	}

	@Override
	public BinarySearchTreeEntity convertDLL2BST(DoubleLinkedLst head) {
		// TODO Auto-generated method stub
		generateBalancedBST(root, head, false);
		return root;
	}

	@Override
	public BinarySearchTreeEntity convertDLL2BSTOptimized(DoubleLinkedLst head) {

		int doubleLinkedLstLength = getDoubleLinkedLstLength(head);
		BinarySearchTreeEntity createBinaryTreeOptimized = createBinaryTreeOptimized(0, doubleLinkedLstLength - 1,
				head);
		// TODO Auto-generated method stub
		return createBinaryTreeOptimized;
	}

	@Override
	public BinarySearchTreeEntity findKthSmallestNode(int rank) {
		// TODO Auto-generated method stub
		smallestKthNode(root, 0, rank);
		return foundNode;
	}

	@Override
	public BinarySearchTreeEntity findCeilNode(int key) {
		// TODO Auto-generated method stub
		return getCeil(key, root);
	}

	@Override
	public BinarySearchTreeEntity findFloorNode(int key) {
		// TODO Auto-generated method stub
		return getFloorNode(root, key);
	}

	@Override
	public ArrayList<String> findIntersection(BinarySearchTreeEntity nodeA, BinarySearchTreeEntity nodeB) {
		// TODO Auto-generated method stub
		ArrayList<String> bstCommonNodeLst = new ArrayList<String>();
		inorderTraverse(nodeA, nodeB, bstCommonNodeLst);
		return bstCommonNodeLst;
	}

	@Override
	public void findIntersectionOptimized(DoubleLinkedLst nodeA, DoubleLinkedLst nodeB, ArrayList<String> nodeLst) {
		// TODO Auto-generated method stub
		if (nodeA == null || nodeB == null)
			return;
		if (Integer.parseInt(nodeA.getData()) == Integer.parseInt(nodeB.getData())) {
			nodeLst.add(nodeA.getData());
			findIntersectionOptimized(nodeA.getNxt(), nodeB.getNxt(), nodeLst);
		} else {
			if (Integer.parseInt(nodeA.getData()) > Integer.parseInt(nodeB.getData()))
				findIntersectionOptimized(nodeA, nodeB.getNxt(), nodeLst);
			else
				findIntersectionOptimized(nodeA.getNxt(), nodeB, nodeLst);

		}

	}

	@Override
	public void printBSTRange(BinarySearchTreeEntity root, int K1, int K2) {
		// TODO Auto-generated method stub

		if (root == null)
			return;
		int rootData = Integer.parseInt(root.getData());
		if (rootData < K1)
			printBSTRange(root.getRight(), K1, K2);
		if (rootData >= K1 && rootData < K2) {

			printBSTRange(root.getLeft(), K1, K2);
			System.out.println(rootData);
			printBSTRange(root.getRight(), K1, K2);
		}
		if (rootData >= K2)
			printBSTRange(root.getLeft(), K1, K2);

	}

	@Override
	public ThreadedBinaryTreeEntity getThreadedBSTRoot(String[] bstnodes) {
		// TODO Auto-generated method stub
		for (String itr : bstnodes)
			createThreadedBinarySearchTree(itr);

		createThreadedlinks(threadedRoot);

		return threadedRoot;
	}

	@Override
	public void printThreadedBinaryTree(ThreadedBinaryTreeEntity root, int k1, int k2) {
		// TODO Auto-generated method stub
		findNodesinRange(root, k1, k2);
	}

	public int getBSTHeight(BinarySearchTreeEntity root) {

		if (root == null)
			return 0;
		else
			return 1 + getMaxInt(getBSTHeight(root.getLeft()), getBSTHeight(root.getRight()));

	}

	@Override
	public boolean isAVLTree(BinarySearchTreeEntity node) {
		// TODO Auto-generated method stub
		if (node == null)
			return true;

		int leftHeight = getBSTHeight(node.getLeft());
		int rightHeight = getBSTHeight(node.getRight());

		if (abs(leftHeight - rightHeight) > 1) {
			return false;
		} else {
			if (isAVLTree(node.getLeft()) && isAVLTree(node.getRight()))
				return true;
			else
				return false;
		}

	}

	@Override
	public BinarySearchTreeEntity pruneBST(BinarySearchTreeEntity node, int startNumber, int endNumber) {
		// TODO Auto-generated method stub
		if (node == null)
			return null;
		node.setLeft(pruneBST(node.getLeft(), startNumber, endNumber));
		node.setRight(pruneBST(node.getRight(), startNumber, endNumber));
		if (compareStrInt(node.getData(), startNumber) == -1)
			return node.getRight();
		if (compareStrInt(node.getData(), endNumber) == 1)
			return node.getLeft();
		return node;
	}

	private LinkedBinarySearchTree createBaseBst(String data, LinkedBinarySearchTree node) {
		if (node == null) {
			node = new LinkedBinarySearchTree();
			node.setData(data);
			return node;
		} else {
			if (compareCharacter(data, node.getData()))
				node.setRight(createBaseBst(data, node.getRight()));
			else
				node.setLeft(createBaseBst(data, node.getLeft()));
			return node;
		}

	}

	private LinkedBinarySearchTree createBSTLink(LinkedBinarySearchTree node) throws Exception {
		QueueEntity bstNodeQueue = new QueueEntity();
		bstNodeQueue.Enqueue(node);
		bstNodeQueue.Enqueue(null);
		while (!bstNodeQueue.IsEmpty() && bstNodeQueue.getLength() > 1) {
			LinkedBinarySearchTree dequeuedNode = bstNodeQueue.Dequeue();
			if (dequeuedNode != null) {
				if (dequeuedNode.getLeft() != null)
					bstNodeQueue.Enqueue(dequeuedNode.getLeft());
				if (dequeuedNode.getRight() != null)
					bstNodeQueue.Enqueue(dequeuedNode.getRight());
				dequeuedNode.setNext(bstNodeQueue.getFirst());

			} else
				bstNodeQueue.Enqueue(null);
		}

		return node;
	}

	@Override
	public LinkedBinarySearchTree createLinkedBinarySearchTree(String[] bstNodes) throws Exception {
		// TODO Auto-generated method stub
		LinkedBinarySearchTree root = null;
		for (String node : bstNodes)
			root = createBaseBst(node, root);
		root = createBSTLink(root);
		return root;
	}
}