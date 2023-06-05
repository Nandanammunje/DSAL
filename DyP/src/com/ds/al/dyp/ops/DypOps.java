package com.ds.al.dyp.ops;

public interface DypOps {

	public int getLcs(char a[], char b[]);
	
	public int knapSackBinary(int capacity,int weights[],int profits[],int index);
	
	public void setDPArr(int x, int y, int defaultValue);
	
}
