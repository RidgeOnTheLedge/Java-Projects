package edu.frcc.csc1061j.MyHashMap;

import java.util.Map;

public class MyHashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new MyHashMap<>();
		
		map.put("3", 3);
		map.put("5", 5);
		map.put("1", 1);
		
		
		System.out.println(map.keySet());
		for(String key : map.keySet())
		{
			System.out.println(key + " ");
		}
		System.out.println();
	}

}
