package com.safziy.service.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		map.put(1, 2);
		map.put(2, 4);
		map.put(3, 6);
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			map.remove(entry.getKey());
		}
	}

}
