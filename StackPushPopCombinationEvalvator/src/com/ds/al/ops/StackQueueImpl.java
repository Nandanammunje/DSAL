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
					rowArr[j] = rowArr[j] + 1;
				}
			}
			area = FindGreatestRectangleHistogramOptimized(rowArr);
			maxArea = Math.max(area, maxArea);
		}

		return maxArea;
	}

	public Deque<Integer> removeKDigits(String numbSequence, int k) {
		Deque<Integer> numbDigit = new LinkedList<Integer>();
		for (int i = 0; i < numbSequence.length(); i++) {

			if (numbDigit.isEmpty())

				numbDigit.push((numbSequence.charAt(i) - 48));
			else {
				while (numbDigit.peek() > (numbSequence.charAt(i) - 48) && k > 0) {
					k--;
					numbDigit.pop();
				}
				numbDigit.push((numbSequence.charAt(i) - 48));

			}

		}
		while (!numbDigit.isEmpty() && numbDigit.peekLast() == 0) {
			numbDigit.pollLast();
		}
		StringBuilder sb = new StringBuilder();
		while (!numbDigit.isEmpty()) {
			int digit = numbDigit.pop();
			if (k > 0) {
				if (digit == 0)
					sb.append(digit);
				else {
					k--;
					continue;
				}
			} else {
				sb.append(digit);
			}
		}
		if (sb.capacity() <= 0) {
			sb.append("0");
		}

		return numbDigit;

	}

	public int stockMaxSpan(int stockPlan[]) {
		int span, maxSpan = 1;
		Deque<Integer> stockQueue = new LinkedList<Integer>();
		for (int i = 0; i < stockPlan.length; i++) {
			if (stockQueue.isEmpty())
				stockQueue.push(i);
			else {
				while (!stockQueue.isEmpty() && stockPlan[stockQueue.peek()] <= stockPlan[i]) {
					stockQueue.pop();
				}
				span = (stockQueue.isEmpty()) ? i : i - stockQueue.peek();
				maxSpan = Math.max(span, maxSpan);
				stockQueue.push(i);
			}

		}
		return maxSpan;
	}

	public static int[] slidingWindow(int numberWin[], int winLen) {
		int slidingWindow[] = new int[numberWin.length - winLen + 1];
		int slidingWindowItr = 0;
		Deque<Integer> windowDeque = new LinkedList<Integer>();
		for (int i = 0; i < numberWin.length; i++) {
			if (windowDeque.isEmpty())
				windowDeque.add(i);
			else {
				System.out.println(numberWin[windowDeque.peek()]);
				while (!windowDeque.isEmpty() && numberWin[windowDeque.peekLast()] < numberWin[i]) {
					windowDeque.pollLast();
				}
				windowDeque.add(i);
				if ((i + 1) >= winLen) {
					int index = windowDeque.getFirst();
					slidingWindow[slidingWindowItr] = numberWin[index];
					if (index <= i - winLen + 1)
						windowDeque.pollFirst();
					slidingWindowItr++;
				}

			}

		}

		return slidingWindow;

	}

	public int findCelebrity(int celebMatrix[][]) {
		Deque<Integer> knownLst = new LinkedList<Integer>();
		boolean isCelebrity = false;
		boolean isCelebriyPresent = true;
		int processedIndex = 0;
		for (int i = 0; i < celebMatrix.length; i++) {
			isCelebrity = true;
			isCelebriyPresent = true;
			if (!knownLst.isEmpty())
				break;
			processedIndex = i;
			for (int j = 0; j < celebMatrix[0].length; j++) {
				if (i == j)
					continue;
				if (celebMatrix[i][j] == 0 && isCelebrity) {
					if (celebMatrix[j][i] == 0) {
						isCelebrity = false;
						isCelebriyPresent = false;

					}
				} else {

					if (celebMatrix[i][j] == 1) {
						knownLst.add(j);
						isCelebrity = false;
						isCelebriyPresent = true;
					}

				}
				if (j == celebMatrix[0].length - 1 && isCelebrity) {
					return i;
				}

			}
			if (!isCelebriyPresent)
				return -1;

		}
		int celebIndex = findCelebrityKnownListy(knownLst, processedIndex, celebMatrix);
		return celebIndex;
	}

	private int findCelebrityKnownListy(Deque<Integer> knownLst, int processedIndex, int celebMatrix[][]) {
		int celebIndex = -1;
		while (!knownLst.isEmpty()) {
			int index = knownLst.pop();
			for (int i = processedIndex + 1; i < celebMatrix[0].length; i++) {
				celebIndex = index;
				if (i == index)
					continue;
				if (celebMatrix[index][i] != 0 && celebMatrix[i][index] != 1) {
					celebIndex = -1;
					break;
				}
			}
			if (celebIndex != -1)
				break;
		}
		return celebIndex;
	}

	
	public boolean isValidBinaryTree(String sequence) {
		Deque<Integer> preOrderDq = new LinkedList<Integer>();
		String treeNode[] = sequence.split(",");
		int nodeArr[] = new int[treeNode.length];
		boolean isValidBT = true;
		if (treeNode[0].equals("#")) {
			return false;
		}
		preOrderDq.push(0);
		for (int i = 1; i < treeNode.length; i++) {
			if (preOrderDq.isEmpty()) {
				isValidBT = false;
				break;
			} else {
				int parentIndex = preOrderDq.peek();
				nodeArr[parentIndex] = nodeArr[parentIndex] + 1;

				if (nodeArr[parentIndex] == 2)
					preOrderDq.pop();

				if (!treeNode[i].equals("#")) {
					preOrderDq.push(i);

				}

			}

		}
		if (!preOrderDq.isEmpty()) {
			isValidBT = false;
		}

		return isValidBT;

	}

	public String decodeString(String s) {

		Deque<String> charStack = new LinkedList<String>();
		Deque<Integer> intStack = new LinkedList<Integer>();
		Deque<String> rStrBlock=new LinkedList<String>();
		boolean isNumStart = true;
		int startIndex = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {

			char charAtIndex = s.charAt(i);
			switch (charAtIndex) {

			case '[':
				isNumStart = true;
				Integer alphaCount = Integer.parseInt(s.substring(startIndex, i));
				intStack.push(alphaCount);
				charStack.push("[");
				break;
			case ']':
				StringBuffer strRpt = new StringBuffer();
				while (!charStack.isEmpty() && !charStack.peek().equals("[")) {
					rStrBlock.push(charStack.pop());
				}
				while(!rStrBlock.isEmpty())
				{
					strRpt.append(rStrBlock.pop());
				}
				charStack.pop();
				String rpt = strRpt.toString();
				int repeatIndex = intStack.pop();
				for (int j = 0; j < repeatIndex - 1; j++)
					strRpt.append(rpt);
				if (charStack.isEmpty())
					sb.append(strRpt);
				else
					charStack.push(strRpt.toString());
				break;
			default:
				int charInt = (int) charAtIndex;
				if ((charInt >= 97 && charInt <= 122)) {
					if (charStack.isEmpty()) {
						sb.append(charAtIndex);
					} else {

						charStack.push(Character.toString(charAtIndex));
					}

				} else {
					if (isNumStart) {
						startIndex = i;
						isNumStart = false;
					}

				}

			}

		}
		return sb.toString();
	}

	public static boolean isNum(String s) {
		int charInt = (int) s.charAt(0);
		if (charInt >= 48 && charInt <= 57)
			return true;
		else
			return false;
	}
}