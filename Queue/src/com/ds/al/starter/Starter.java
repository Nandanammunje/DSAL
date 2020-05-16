package com.ds.al.starter;

import java.util.Scanner;

import com.ds.al.queue.QueueEntity;
import com.ds.al.queue.StackEntity;

public class Starter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length,block,data=0;
		System.out.println("Enter the length of the data");
		length=sc.nextInt();
		System.out.println("Enter the Partition length");
		block=sc.nextInt();
		QueueEntity q = new QueueEntity();
		System.out.println("Enter the data into the queue");
		for(int i=0;i<length;i++)
		{
			data=sc.nextInt();
			q.Enqueue(data);
		}
		sc.close();
		StackEntity stck=new StackEntity();
		for(int i=0;i<block;i++)
		stck.Push(q.Dequeue());
		for(int i=0;i<block;i++)
		q.Enqueue(stck.Pop());
		for(int i=0;i<length-block;i++)
		q.Enqueue(q.Dequeue());
		
		
		for(int i=0;i<length;i++)
			System.out.println(q.Dequeue());
		
	}
}
