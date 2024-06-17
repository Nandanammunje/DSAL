package com.ds.al.stringalgo.starter;

import java.util.ArrayList;
import java.util.Scanner;

import org.xml.sax.helpers.XMLReaderAdapter;

import com.ds.al.stringalgo.entity.TernarySearchTree;
import com.ds.al.stringalgo.entity.TrieNode;
import com.ds.al.stringalgo.entity.TrieSuffix;
import com.ds.al.stringalgo.ops.StringAlgoOps;
import com.ds.al.stringalgo.ops.StringAlgoOpsImpl;

public class StringStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String textIn, searchPattern[];
		int strLstSize;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word ");
		textIn=sc.next();
		TrieSuffix trieSuffix=new TrieSuffix();
		trieSuffix.createSuffixTrie(textIn);
		
		
		
		/* ArrayList<String> allWords = createTer.getAllWords(); */
		/*
		 * System.out.println("Enter search string"); for (int i = 0; i < strLstSize;
		 * i++) { searchPattern[i] = sc.next(); }
		 * 
		 * for (String str : searchPattern) { createTer.containsWord(str);
		 * 
		 * }
		 */
		
	
		sc.close();

	}

}
