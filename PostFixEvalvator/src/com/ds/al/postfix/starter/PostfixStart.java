package com.ds.al.postfix.starter;

import java.util.Scanner;

import com.ds.al.postfix.eval.EvalPostFix;
import com.ds.al.postfix.eval.EvalPostFixImpl;

public class PostfixStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the post fix expression");
		String expression = sc.next();
		sc.close();
		EvalPostFix op = new EvalPostFixImpl();
		System.out.println(op.GetResult(expression));

	}

}
