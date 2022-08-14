package com.ds.al.BinaryHeap.Starter;

import java.util.Scanner;

import com.ds.al.BinaryHeap.Entity.BinaryHeapEntity;

public class BinaryHeapStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the heap");
		size = sc.nextInt();
		int a[] = new int[size];
		System.out.println("Enter the data into the heap");
		for (int i = 0; i < size; i++)
			a[i] = sc.nextInt();
		BinaryHeapEntity biHeap = new BinaryHeapEntity(size);
		biHeap.heapify(a);
		int[] heapArr = biHeap.getHeapArr();
	
		sc.close();
	}

}
