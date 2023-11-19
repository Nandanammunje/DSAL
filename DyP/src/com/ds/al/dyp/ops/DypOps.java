package com.ds.al.dyp.ops;

public interface DypOps {

	public int getLcs(char a[], char b[]);

	public StringBuffer getLcsString(char a[], char b[]);

	public int knapSackBinary(int capacity, int weights[], int profits[], int index);

	public void setDPArr(int x, int y, int z, int defaultValue, int multi);

	public int knapSackUnbounded(int capacity, int weights[], int profits[], int index);

	public int makeChangeDP(int capacity, int index, int coins[]);

	int makeChangeDPMemoize(int capacity, int index, int[] coins);

	int makeChangeDPTabulation(int coins[], int capacity);

	int makeChangeDpMin(int capacity, int index, int[] coins, int coinCount);

	int makeChangeDpMinMemoize(int capacity, int index, int[] coins, int coinCount);

	int getLengthIncreasingSequence(int arr[], int currIndex, int prevIndex);

	boolean isSubsetSumExist(int arr[], int index, int sum);

	boolean isPartitionSumExist(int arr[]);

	int getCountOfSubset(int arr[], int index, int sum);

	void MinDifferenceSubset(int arr[], int index, int totalSum, int sum);

	void setMinDifference(int minDiff);

	int getMinDiff();

	int getLeastCommonSubstring(char a[], char b[], int i, int j, int count);

	int getLeastCommonSubstringTabulation(char a[], char b[]);

	StringBuffer getShortestCommonSuperstring(char a[], char b[]);

	int getMinInsertionDeletion(char a[], char b[], int lcsLen);

	void setMinCoin(int noCoins);

	int getLengthLongestPallindrome(char a[],int i, int j );
	
	int getLengthLongestPallindromeTab(char a[],char b[]);
	
	int getLongestRepeatingSubSequence(char a[],int i,int j);
	
	boolean isSequenceMatching(char a[],char b[],int i,int j);

}
