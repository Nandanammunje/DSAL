package com.ds.al.ops;

import java.util.Deque;
import java.util.LinkedList;

public class StackQueueImpl {

	public static int subArrMinSum(int nums[]) {

		int[] nextSmallerElementRightIndexArr = nextSmallerElementRightIndex(nums);
		int[] previousSmallElementleftIndexArr = previousSmallElementleftIndex(nums);
		

		int totalElement = 0;
		for (int i = 0; i < nums.length; i++) {
			int leftIndex = previousSmallElementleftIndexArr[i];
			int rightIndex = nextSmallerElementRightIndexArr[i];

			int leftElement = (leftIndex == -1) ? i + 1 : i - leftIndex;
			int rightElement = (rightIndex == -1) ? nums.length - i : rightIndex - i;
			System.out.println("index " + i + " left " + leftElement + " right " + rightElement);
			totalElement = totalElement + (leftElement * rightElement * nums[i]);
		}

		return totalElement;

	}
	
	public static int subArrRange(int nums[])
	{
		int subArrMinSum = subArrMinSum(nums);
		int[] nextLargerElmentRightIndex = nextLargerElmentRightIndex(nums);
		int[] previousGreaterElementleftIndex = previousGreaterElementleftIndex(nums);
		int totalElement = 0;
		for (int i = 0; i < nums.length; i++) {
			int leftIndex = previousGreaterElementleftIndex[i];
			int rightIndex = nextLargerElmentRightIndex[i];

			int leftElement = (leftIndex == -1) ? i + 1 : i - leftIndex;
			int rightElement = (rightIndex == -1) ? nums.length - i : rightIndex - i;
			System.out.println("index " + i + " left " + leftElement + " right " + rightElement);
			totalElement = totalElement + (leftElement * rightElement * nums[i]);
		}
       System.out.println(totalElement-subArrMinSum);
		return totalElement-subArrMinSum;
		
	}

	private static int[] nextSmallerElementRightIndex(int nums[]) {
		Deque<Integer> nextSmallRightStack = new LinkedList<Integer>();
		int nextSmallRightArr[] = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nextSmallRightStack.isEmpty()) {
				nextSmallRightStack.push(i);
				nextSmallRightArr[i] = -1;
			} else {
				while (!nextSmallRightStack.isEmpty() && nums[nextSmallRightStack.peek()] >= nums[i]) {
					nextSmallRightStack.pop();
				}
				nextSmallRightArr[i] = (nextSmallRightStack.isEmpty()) ? -1 : nextSmallRightStack.peek();
				nextSmallRightStack.push(i);
			}
		}
		return nextSmallRightArr;

	}

	private static int[] previousSmallElementleftIndex(int nums[]) {
		Deque<Integer> nextSmallLeftStack = new LinkedList<Integer>();
		int nextSmallLeftArr[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nextSmallLeftStack.isEmpty()) {
				nextSmallLeftArr[i] = -1;
				nextSmallLeftStack.push(i);
			} else {
				while (!nextSmallLeftStack.isEmpty() && nums[nextSmallLeftStack.peek()] >= nums[i]) {
					nextSmallLeftStack.pop();
				}
				nextSmallLeftArr[i] = (nextSmallLeftStack.isEmpty()) ? -1 : nextSmallLeftStack.peek();
				nextSmallLeftStack.push(i);
			}
		}

		return nextSmallLeftArr;
	}

	private static int[] nextLargerElmentRightIndex(int nums[]) {
		Deque<Integer> nextGreaterRightStack = new LinkedList<Integer>();
		int nextGreaterRightArr[] = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nextGreaterRightStack.isEmpty()) {
				nextGreaterRightStack.push(i);
				nextGreaterRightArr[i] = -1;
			} else {
				while (!nextGreaterRightStack.isEmpty() && nums[nextGreaterRightStack.peek()] <= nums[i]) {
					nextGreaterRightStack.pop();
				}
				nextGreaterRightArr[i] = (nextGreaterRightStack.isEmpty()) ? -1 : nextGreaterRightStack.peek();
				nextGreaterRightStack.push(i);
			}
		}
		return nextGreaterRightArr;
	}

	private static int[] previousGreaterElementleftIndex(int nums[]) {
		Deque<Integer> nextGreaterLeftStack = new LinkedList<Integer>();
		int nextGreaterLeftArr[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nextGreaterLeftStack.isEmpty()) {
				nextGreaterLeftArr[i] = -1;
				nextGreaterLeftStack.push(i);
			} else {
				while (!nextGreaterLeftStack.isEmpty() && nums[nextGreaterLeftStack.peek()] <= nums[i]) {
					nextGreaterLeftStack.pop();
				}
				nextGreaterLeftArr[i] = (nextGreaterLeftStack.isEmpty()) ? -1 : nextGreaterLeftStack.peek();
				nextGreaterLeftStack.push(i);
			}
		}

		return nextGreaterLeftArr;
	}

}
