package com.ds.al.dyp.ops;

import static com.ds.al.dysp.util.DypUtil.getMaxInt;

public class DyOpsImpl implements DypOps {

	int memArr[][];

	private int getLcsArr(int i, int j, char[] a, char[] b) {
		if (i >= a.length || j >= b.length)
			return 0;

		if (memArr[i][j] != -1) {
			System.out.println("Memoized part");
			return memArr[i][j];
		}
		if (a[i] == b[j]) {

			return memArr[i][j] = getLcsArr(i + 1, j + 1, a, b) + 1;
		} else {
			int first = getLcsArr(i, j + 1, a, b);
			memArr[i][j + 1] = first;
			int second = getLcsArr(i + 1, j, a, b);
			memArr[i + 1][j] = second;
			memArr[i][j] = (first > second) ? first : second;
			return memArr[i][j];
		}

	}

	@Override
	public void setDPArr(int x, int y, int defaultValue) {
		memArr = new int[x + 1][y + 1];
		for (int i = 0; i < memArr.length; i++) {
			for (int j = 0; j < memArr[i].length; j++) {
				memArr[i][j] = defaultValue;
			}

		}
	}

	private void getLcsArrTab(char[] a, char[] b) {
		for (int i = 0; i < memArr.length; i++)
			memArr[i][0] = 0;
		for (int j = 0; j < memArr[0].length; j++)
			memArr[0][j] = 0;
		for (int i = 1; i < memArr.length; i++) {
			for (int j = 1; j < memArr[i].length; j++) {

				if (a[i - 1] == b[j - 1]) {
					memArr[i][j] = memArr[i - 1][j - 1] + 1;
				} else {

					memArr[i][j] = (memArr[i - 1][j] > memArr[i][j - 1]) ? memArr[i - 1][j] : memArr[i][j - 1];
				}
			}

		}

	}

	private void getKnapsackBinary(int capacity, int[] weights, int[] profits) {
		int dp[] = new int[capacity + 1];
		for (int i = 1; i <= weights.length; i++) {
			for (int j = capacity; j >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + profits[i - 1]);
			}
		}

	}

	public int getUnboundedKnapsackBinaryMemoiz(int capacity, int[] weights, int[] profits, int index) {
		if (index < 0 || capacity <= 0 || index >= weights.length) {
			return 0;
		}
		if (weights[index] > capacity) {
			getUnboundedKnapsackBinaryMemoiz(capacity, weights, profits, index - 1);
		}
		if (memArr[index][capacity] != -1)
			return memArr[index][capacity];
		else {

			int firstUnbounded = profits[index]
					+ getUnboundedKnapsackBinaryMemoiz(capacity - weights[index], weights, profits, index);
			int secondUnbounded = getUnboundedKnapsackBinaryMemoiz(capacity, weights, profits, index - 1);
			int maxVal = getMaxInt(firstUnbounded, secondUnbounded);
			memArr[index][capacity] = maxVal;

			return memArr[index][capacity];

		}

	}

	@Override
	public int makeChangeDPMemoize(int capacity, int index, int coins[]) {
		if (index < 0 || capacity <= 0 || index >= coins.length)
			return 0;
		else if (capacity < coins[index])
			return makeChangeDPMemoize(capacity, index - 1, coins);
		if (memArr[index][capacity] != -1)
			return memArr[index][capacity];
		if (capacity == coins[index]) {
			memArr[index][capacity] = 1 + makeChangeDPMemoize(capacity, index - 1, coins);
			return memArr[index][capacity];
		} else {
			memArr[index][capacity] = makeChangeDPMemoize(capacity - coins[index], index, coins)
					+ makeChangeDPMemoize(capacity, index - 1, coins);
			return memArr[index][capacity];
		}

	}

	@Override
	public int getLcs(char[] a, char[] b) {
		// TODO Auto-generated method stub

		memArr = new int[a.length + 1][b.length + 1];
		getLcsArrTab(a, b);
		for (int i = 0; i < memArr.length; i++) {
			for (int j = 0; j < memArr[i].length; j++) {
				memArr[i][j] = -1;
			}
		}

		getLcsArrTab(a, b);

		int lcsArr = getLcsArr(0, 0, a, b);
		return lcsArr;

	}

	@Override
	public int knapSackBinary(int capacity, int[] weights, int[] profits, int index) {
		// TODO Auto-generated method stub

		if (index >= weights.length || capacity <= 0)
			return 0;
		else if (capacity < weights[index])
			return knapSackBinary(capacity, weights, profits, index + 1);
		if (memArr[capacity][index] != -1)
			return memArr[capacity][index];

		else {
			int maxFirst = profits[index] + knapSackBinary(capacity - weights[index], weights, profits, index + 1);
			int maxSecond = knapSackBinary(capacity, weights, profits, index + 1);
			memArr[capacity][index] = (maxFirst > maxSecond) ? maxFirst : maxSecond;
			return memArr[capacity][index];
		}
	}

	@Override
	public int knapSackUnbounded(int capacity, int[] weights, int[] profits, int index) {
		// TODO Auto-generated method stub
		if (index >= weights.length || index < 0 || capacity <= 0)
			return 0;
		if (index == 0)
			return (capacity / weights[0]) * profits[0];
		if (weights[index] > capacity)
			return knapSackUnbounded(capacity, weights, profits, index - 1);
		else {

			return getMaxInt(profits[index] + knapSackUnbounded(capacity - weights[index], weights, profits, index),
					knapSackUnbounded(capacity, weights, profits, index - 1));
		}

	}

	@Override
	public int makeChangeDP(int capacity, int index, int[] coins) {
		// TODO Auto-generated method stub
		if (index < 0 || capacity <= 0 || index >= coins.length)
			return 0;

		else if (capacity < coins[index])
			return makeChangeDP(capacity, index - 1, coins);

		if (capacity == coins[index])
			return 1 + makeChangeDP(capacity, index - 1, coins);
		else {

			return makeChangeDP(capacity - coins[index], index, coins) + makeChangeDP(capacity, index - 1, coins);
		}

	}

	@Override
	public int makeChangeDpMin(int capacity, int index, int[] coins) {
		// TODO Auto-generated method stub
		if (capacity <= 0 || index < 0 || index >= coins.length)
			return 0;
		if (coins[index] > capacity)
			return (makeChangeDpMin(capacity, index + 1, coins));
		else {

			int coinFirst = 1 + makeChangeDpMin(capacity - coins[index], index, coins);
			int coinSecond = makeChangeDpMin(capacity, index + 1, coins);
			if (coinFirst > 0 && coinSecond > 0)
				return Math.min(coinFirst, coinSecond);
			else
				return Math.max(coinFirst, coinSecond);
		}

	}

	@Override
	public int makeChangeDpMinMemoize(int capacity, int index, int[] coins) {
		// TODO Auto-generated method stub
		if (capacity <= 0 || index < 0 || index >= coins.length)
			return 0;
		if (coins[index] > capacity)
			return (makeChangeDpMin(capacity, index + 1, coins));
		if (memArr[index][capacity] != -1)
			return memArr[index][capacity];
		else {
			int coinFirst = 1 + makeChangeDpMin(capacity - coins[index], index, coins);
			int coinSecond = makeChangeDpMin(capacity, index + 1, coins);
			if (coinFirst > 0 && coinSecond > 0)
				memArr[index][capacity] = Math.min(coinFirst, coinSecond);
			else
				memArr[index][capacity] = Math.max(coinFirst, coinSecond);

			return memArr[index][capacity];

		}

	}

	@Override
	public int getLengthIncreasingSequence(int[] arr, int currIndex, int prevIndex) {
		// TODO Auto-generated method stub
		int incLength = 0, notIncLength = 0;
		if (currIndex >= arr.length || prevIndex >= arr.length)
			return 0;
		notIncLength = getLengthIncreasingSequence(arr, currIndex + 1, prevIndex);
		if (prevIndex == -1 || arr[currIndex] > arr[prevIndex])
			incLength = 1 + getLengthIncreasingSequence(arr, currIndex + 1, currIndex);

		return Math.max(notIncLength, incLength);

	}

}
