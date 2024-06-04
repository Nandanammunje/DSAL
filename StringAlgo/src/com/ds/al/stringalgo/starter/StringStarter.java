package com.ds.al.stringalgo.starter;

import java.util.Scanner;

import org.xml.sax.helpers.XMLReaderAdapter;

import com.ds.al.stringalgo.entity.TrieNode;
import com.ds.al.stringalgo.ops.StringAlgoOps;
import com.ds.al.stringalgo.ops.StringAlgoOpsImpl;

public class StringStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String textIn[], searchPattern;
		int trieSize;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the trie ");
		trieSize=sc.nextInt();
        textIn=new String[trieSize];
		System.out.println("Enter string");
		for(int i=0;i<trieSize;i++)
		{
			textIn[i]=sc.next();
		}
		/*
		 * System.out.println("Enter the pattern "); searchPattern = sc.next();
		 */
	      TrieNode createTrie = new TrieNode();
	      for(String str:textIn)
	    	  createTrie.addWord(str);
	      
	      System.out.println("Enter the search pattern"); 
	      searchPattern=sc.next();
	      createTrie.startsWith(searchPattern);
	      
	
		
		sc.close();

	}

}
