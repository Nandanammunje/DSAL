package com.ds.al.stringalgo.starter;

import java.util.Scanner;

import org.xml.sax.helpers.XMLReaderAdapter;

import com.ds.al.stringalgo.entity.TernarySearchTree;
import com.ds.al.stringalgo.entity.TrieNode;
import com.ds.al.stringalgo.ops.StringAlgoOps;
import com.ds.al.stringalgo.ops.StringAlgoOpsImpl;

public class StringStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String textIn[], searchPattern[];
		int strLstSize;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the ternary search tree  ");
		strLstSize = sc.nextInt();
		textIn = new String[strLstSize];
		searchPattern = new String[strLstSize];
		System.out.println("Enter string");
		for (int i = 0; i < strLstSize; i++) {
			textIn[i] = sc.next();
		}
		/*
		 * System.out.println("Enter the pattern "); searchPattern = sc.next();
		 */
		TernarySearchTree<String> createTer = new TernarySearchTree();
		int i=0;
		for (String str : textIn) {
			i++;
			createTer.addWord(str,"nandan"+i);

		}
		/*
		 * System.out.println("Enter search string"); for (int i = 0; i < strLstSize;
		 * i++) { searchPattern[i] = sc.next(); }
		 * 
		 * for (String str : searchPattern) { createTer.containsWord(str);
		 * 
		 * }
		 */
		
		System.out.println(createTer.containsKey("cart"));
		sc.close();

	}

}
