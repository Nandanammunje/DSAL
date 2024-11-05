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

	public static int subArrRange(int nums[]) {
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
		System.out.println(totalElement - subArrMinSum);
		return totalElement - subArrMinSum;

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

	public Deque<Integer> AsteroidCollision(int asteroid[]) {
		Deque<Integer> monStack = new LinkedList<Integer>();
		boolean isPop = false, isPushed = false;
		for (int i = 0; i < asteroid.length; i++) {
			isPop = false;
			isPushed = false;
			if (monStack.isEmpty()) {
				monStack.push(asteroid[i]);
			} else {
				if (monStack.peek() * asteroid[i] > 0 || monStack.peek() < 0) {
					monStack.push(asteroid[i]);
				} else {
					while (!monStack.isEmpty() && Math.abs(monStack.peek()) <= Math.abs(asteroid[i])) {
						if (monStack.peek() * asteroid[i] > 0) {
							monStack.push(asteroid[i]);
							isPushed = true;
							break;
						} else {
							int topVal = monStack.peek();
							monStack.pop();
							if (topVal + asteroid[i] == 0) {
								isPop = true;
								break;
							}
						}
					}
					if ((monStack.isEmpty() && !isPop)
							|| (monStack.isEmpty() && (monStack.peek() * asteroid[i]) > 0) && !isPushed && !isPop) {
						monStack.push(asteroid[i]);
					}
				}

			}
		}
		return monStack;

	}

	public int FindGreatestRectangleHistogram(int histogram[]) {
		int totalArr = 0, leftWidth = 0, rightWidth = 0, area = 0;
		int rightArr[] = nextSmallerElementRightIndex(histogram);
		int leftArr[] = previousSmallElementleftIndex(histogram);
		leftArr[0] = -2;
		rightArr[histogram.length - 1] = -2;

		for (int i = 0; i < histogram.length; i++) {
			if (leftArr[i] == -1)
				leftWidth = i;
			if (rightArr[i] == -1)
				rightWidth = histogram.length - i - 1;

			if (leftArr[i] == -2)
				leftWidth = 0;
			else if (leftArr[i] != -1 && leftArr[i] != -2)
				leftWidth = i - leftArr[i] - 1;
			if (rightArr[i] == -2)
				rightWidth = 0;
			else if (rightArr[i] != -1 && rightArr[i] != -2)
				rightWidth = rightArr[i] - i - 1;

			area = ((leftWidth + rightWidth) * histogram[i]) + histogram[i];
			totalArr = Math.max(area, totalArr);
		}
		return totalArr;

	}

	public int FindGreatestRectangleHistogramOptimized(int histogram[]) {
		int totalArr = 0, leftWidth = 0, rightWidth = 0, area = 0;
		Deque<Integer> previousSmallerStack = new LinkedList<Integer>();
		for (int i = 0; i < histogram.length; i++) {
			if (previousSmallerStack.isEmpty()) {
				previousSmallerStack.push(i);
			} else {
				while (!previousSmallerStack.isEmpty() && histogram[previousSmallerStack.peek()] >= histogram[i]) {
					int nextVal = previousSmallerStack.pop();
					int prevVal = (previousSmallerStack.isEmpty()) ? -1 : previousSmallerStack.peek();
					if (prevVal == -1)
						leftWidth = nextVal;
					else
						leftWidth = nextVal - prevVal - 1;
					rightWidth = i - nextVal - 1;

					area = ((leftWidth + rightWidth) * histogram[nextVal]) + histogram[nextVal];
					totalArr = Math.max(area, totalArr);

				}
				previousSmallerStack.push(i);

			}

		}
		while (!previousSmallerStack.isEmpty()) {

			int currentIndex = previousSmallerStack.pop();
			int nextIndex = (previousSmallerStack.isEmpty()) ? -1 : previousSmallerStack.peek();
			rightWidth = histogram.length - currentIndex - 1;
			if (nextIndex == -1)
				leftWidth = currentIndex;
			else
				leftWidth = currentIndex - nextIndex - 1;
			area = ((leftWidth + rightWidth) * histogram[currentIndex]) + histogram[currentIndex];
			totalArr = Math.max(area, totalArr);
		}

		return totalArr;
	}

	public int findMaximumRectangleMatrix(int rectMarix[][]) {
		int maxArea = 0, area = 0;
		int rowArr[] = new int[rectMarix[0].length];
		for (int i = 0; i < rectMarix.length; i++) {
			for (int j = 0; j < rectMarix[0].length; j++) {
				if (rectMarix[i][j] == 0)
					rowArr[j] = 0;
				else {
					rowArr[j] = rowArr[j]+1;
				}
			}
			area = FindGreatestRectangleHistogramOptimized(rowArr);
			maxArea = Math.max(area, maxArea);
		}

		return maxArea;
	}

}
