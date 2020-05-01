package com.ds.al.starter;

import java.util.Scanner;

import com.ds.al.Entity.EvalList;
import com.ds.al.ops.EvalListOps;
import com.ds.al.ops.EvalListOpsImpl;

public class EvalStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data, m;
		EvalList head = null;
		EvalListOps op = new EvalListOpsImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the stack data sequentially");
		m = sc.nextInt();
		int a[] = new int[m];
		for (int i = 0; i < m; i++) {
			System.out.println("Enter the data");
			data = sc.nextInt();
			head = op.AddNode(head, data);
		}

		for (int i = 0; i < m; i++) {
			System.out.println("Enter push pop combination");
			a[i] = sc.nextInt();
		}
		System.out.println("status of comination is "+op.CheckOps(head, a));
		sc.close();
	}

}
