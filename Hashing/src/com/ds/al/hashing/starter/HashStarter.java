package com.ds.al.hashing.starter;

import java.util.Scanner;

import com.ds.al.hashing.ops.HashingOps;
import com.ds.al.hashing.ops.HashingOpsImpl;

public class HashStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String charIn = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String Stream ");
		charIn = sc.next();
		HashingOps ops = new HashingOpsImpl();
		ops.findFirstNonRepeatingChar(charIn);

		sc.close();

	}

}
