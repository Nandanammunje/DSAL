package com.ds.al.hashing.ops;

import java.util.HashMap;

public class HashingOpsImpl implements HashingOps {

	@Override
	public char findFirstNonRepeatingChar(String InChar) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> linkedMap = new HashMap<Integer, Integer>();
		int arr[] = new int[InChar.length()];
		int key, index = 0;

		for (int i = 0; i < InChar.length(); i++) {
			key = InChar.charAt(i);

			if (linkedMap.containsKey(key)) {
				int markIndex = linkedMap.get(key);
				arr[i] = 1;
				arr[markIndex] = 1;
			} else {
				linkedMap.put(key, i);
			}
		}
		for (index = 0; index < arr.length; index++) {
			if (arr[index] == 0) {

				break;
			}
		}
		if (index > InChar.length())
			return '$';
		else
			return InChar.charAt(index);
	}

}
