package com.ds.al.dyp.ops;

public interface DypOps {

	public int getLcs(char a[], char b[]);

	public int knapSackBinary(int capacity, int weights[], int profits[], int index);

	public void setDPArr(int x, int y, int defaultValue);

	public int knapSackUnbounded(int capacity, int weights[], int profits[], int index);

	public int makeChangeDP(int capacity, int index, int coins[]);

	int makeChangeDPMemoize(int capacity, int index, int[] coins);

	int makeChangeDpMin(int capacity, int index, int[] coins);

	int makeChangeDpMinMemoize(int capacity, int index, int[] coins);

}
