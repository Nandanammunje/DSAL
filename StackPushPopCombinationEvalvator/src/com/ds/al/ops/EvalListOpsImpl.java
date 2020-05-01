package com.ds.al.ops;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

import com.ds.al.Entity.EvalList;

public class EvalListOpsImpl implements EvalListOps {

	@Override
	public EvalList AddNode(EvalList head, int data) {
		// TODO Auto-generated method stub
		EvalList root, newnode;
		if (head == null) {
			head = new EvalList();
			head.setData(data);
			head.setNext(null);

		} else {
			root = head;
			while (root.getNext() != null)
				root = root.getNext();
			newnode = new EvalList();
			newnode.setData(data);
			newnode.setNext(null);
			root.setNext(newnode);

		}

		return head;
	}

	@Override
	public boolean CheckOps(EvalList head, int a[]) {

		Stack<Integer> Possibility = new Stack<Integer>();
		EvalList headpt = head;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean possibility = true;
		for (int i = 0; i < a.length; i++) {
			if (headpt != null) {
				if (head.getData() == a[i]) {

					headpt = headpt.getNext();
					continue;
				}

				if (!Possibility.empty()&&Possibility.peek() == a[i]) {

					Possibility.pop();
					headpt=headpt.getNext();

				} else if (!map.containsKey(a[i])) {
					Possibility.push(headpt.getData());
					map.put(headpt.getData(), i);
					headpt = headpt.getNext();
				} else if (map.containsKey(a[i])) {
					possibility = false;
					break;
				}

			}
		}

		return possibility;
	}

}
