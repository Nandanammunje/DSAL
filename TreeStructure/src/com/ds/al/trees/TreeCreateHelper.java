package com.ds.al.trees;

import java.util.HashMap;

public class TreeCreateHelper {

	private static HashMap<Integer, Integer> RankMap;

	public void SetRankMap(HashMap<Integer, Integer> map) {
		if (RankMap == null)
			this.RankMap = map;

	}

	public int GetRank(int node) {
		return RankMap.get(node);
	}

}
