package com.ds.al.dyp.ops;

import static com.ds.al.dysp.util.DypUtil.getMaxInt;

public class DyOpsImpl implements DypOps {

	int[][] memArr;
	int mod = 1000000007;
	int minDiff;
	int memMultiArr[][][];

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
	public void setDPArr(int x, int y, int z, int defaultValue, int multi) {
		if (multi == 0) {
			memArr = new int[x + 1][y + 1];
			for (int i = 0; i < memArr.length; i++) {
				for (int j = 0; j < memArr[i].length; j++) {
					memArr[i][j] = defaultValue;
				}

			}
		} else {

			memMultiArr = new int[x + 1][y + 1][z + 1];
			for (int i = 0; i < x + 1; i++) {
				for (int j = 0; j < y + 1; j++) {
					for (int k = 0; k < z + 1; k++) {
						memMultiArr[i][j][k] = defaultValue;
					}
				}

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

	public boolean isPartitionSum(int arr[], int index, int sum) {
		boolean isPartitionExist = true;
		if (index >= arr.length)
			return false;

		if (arr[index] == sum)
			return true;

		isPartitionExist = isPartitionSum(arr, index + 1, sum) || isPartitionSum(arr, index + 1, sum - arr[index]);

		return isPartitionExist;

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
	public int makeChangeDPTabulation(int[] coins, int capacity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int makeChangeDpMin(int capacity, int index, int[] coins, int coinCount) {
		// TODO Auto-generated method stub
		int inclCount, notInclCount;
		if (capacity < 0 || index >= coins.length || (index == 0 && capacity == 0 && coinCount <= 0))
			return -1;
		if (capacity == 0)
			return coinCount;
		if (coins[index] <= capacity) {
			if (index == coins.length - 1) {
				if (capacity % coins[index] == 0)
					return capacity / coins[index] + coinCount;
				else
					return -1;

			}

			inclCount = makeChangeDpMin(capacity - coins[index], index, coins, coinCount + 1);
			notInclCount = makeChangeDpMin(capacity, index + 1, coins, coinCount);
		} else {

			return makeChangeDpMin(capacity, index + 1, coins, coinCount);
		}

		if (inclCount > 0 && notInclCount > 0)
			return Math.min(inclCount, notInclCount);
		else
			return Math.max(inclCount, notInclCount);

	}

	@Override
	public int makeChangeDpMinMemoize(int capacity, int index, int[] coins, int coinCount) {
		// TODO Auto-generated method stub
		int inclCount, notInclCount;
		if (capacity < 0 || index >= coins.length || (index == 0 && capacity == 0 && coinCount <= 0))
			return -1;

		if (capacity == 0) {
			memMultiArr[index][capacity][coinCount] = coinCount;
			return coinCount;
		}
		if (memMultiArr[index][capacity][coinCount] != -1)
			return memMultiArr[index][capacity][coinCount];

		if (coins[index] <= capacity) {
			inclCount = makeChangeDpMinMemoize(capacity - coins[index], index, coins, coinCount + 1);
			notInclCount = makeChangeDpMinMemoize(capacity, index + 1, coins, coinCount);
		} else {
			memMultiArr[index][capacity][coinCount] = makeChangeDpMinMemoize(capacity, index + 1, coins, coinCount);
			return memMultiArr[index][capacity][coinCount];
		}
		if (inclCount > 0 && notInclCount > 0)
			memMultiArr[index][capacity][coinCount] = Math.min(inclCount, notInclCount);
		else
			memMultiArr[index][capacity][coinCount] = Math.max(inclCount, notInclCount);

		return memMultiArr[index][capacity][coinCount];

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

	@Override
	public boolean isSubsetSumExist(int[] arr, int index, int sum) {
		// TODO Auto-generated method stub
		boolean inclElem = false, notIncElem = false;
		if (index >= arr.length)
			return false;
		if (sum == arr[index])
			return true;
		notIncElem = isSubsetSumExist(arr, index + 1, sum);
		if (arr[index] < sum)
			inclElem = isSubsetSumExist(arr, index + 1, sum - arr[index]);

		return (notIncElem || inclElem);
	}

	@Override
	public boolean isPartitionSumExist(int[] arr) {
		// TODO Auto-generated method stub
		boolean existStatus = true;
		int sum = 0;
		for (int itr : arr)
			sum = sum + itr;
		if (sum % 2 == 1)
			return false;
		sum = sum / 2;
		existStatus = isPartitionSum(arr, 0, sum);

		return existStatus;
	}

	@Override
	public int getCountOfSubset(int[] arr, int index, int sum) {
		// TODO Auto-generated method stub
		int inclCount = 0;
		if (index >= arr.length)
			return 0;
		if (memArr[index][sum] != -1)
			return memArr[index][sum];

		else if (sum == arr[index]) {
			return memArr[index][sum] = (1 + getCountOfSubset(arr, index + 1, sum)
					+ getCountOfSubset(arr, index + 1, 0)) % mod;
		}
		int notInclCount = getCountOfSubset(arr, index + 1, sum);
		if (sum > arr[index])
			inclCount = getCountOfSubset(arr, index + 1, sum - arr[index]);
		memArr[index][sum] = (notInclCount + inclCount) % mod;
		return memArr[index][sum];
	}

	@Override
	public void MinDifferenceSubset(int[] arr, int index, int totalSum, int sum) {
		// TODO Auto-generated method stub

		if (Math.abs((totalSum - sum) - sum) < minDiff) {
			minDiff = Math.abs((totalSum - sum) - sum);
		}
		if (index >= arr.length)
			return;
		if (memArr[index][sum] != -1) {
			return;
		}
		MinDifferenceSubset(arr, index + 1, totalSum, sum + arr[index]);
		MinDifferenceSubset(arr, index + 1, totalSum, sum);

	}

	@Override
	public int getMinDiff() {
		// TODO Auto-generated method stub
		return minDiff;
	}

	@Override
	public void setMinDifference(int minDiff) {
		// TODO Auto-generated method stub
		this.minDiff = minDiff;

	}

	@Override
	public int getLeastCommonSubstring(char[] a, char[] b, int i, int j, int count) {
		// TODO Auto-generated method stub
		int incFirst = 0, incSecond = 0;
		if (i >= a.length || j >= b.length)
			return count;

		if (a[i] == b[j])
			return getLeastCommonSubstring(a, b, i + 1, j + 1, count + 1);
		else {
			incFirst = getLeastCommonSubstring(a, b, i + 1, j, 0);
			incSecond = getLeastCommonSubstring(a, b, i, j + 1, 0);

		}

		return Math.max(count, Math.max(incFirst, incSecond));
	}

	@Override
	public int getLeastCommonSubstringTabulation(char[] a, char[] b) {
		// TODO Auto-generated method stub
		int maxLength = 0;
		for (int i = 0; i < memArr.length; i++)
			memArr[i][0] = 0;
		for (int j = 0; j < memArr[0].length; j++)
			memArr[0][j] = 0;
		for (int i = 1; i < memArr.length; i++) {

			for (int j = 1; j < memArr[i].length; j++) {
				if (a[i - 1] == b[j - 1]) {
					memArr[i][j] = memArr[i - 1][j - 1] + 1;
					maxLength = Math.max(maxLength, memArr[i][j]);
				} else {
					memArr[i][j] = 0;
				}
			}
		}
		return maxLength;
	}

	

}
