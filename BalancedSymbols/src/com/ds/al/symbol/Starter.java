package com.ds.al.symbol;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
		System.out.println("Enter the symbols");
		String in=sc.next();
		SymbolBalanceChecker check=new SymbolBalanceCheckerImpl();
		System.out.println(check.CheckBalance(in));
		sc.close();
	}

}
