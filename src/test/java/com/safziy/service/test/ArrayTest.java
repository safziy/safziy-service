package com.safziy.service.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		System.out.println(list.getClass().isArray());
		
		List<String> list1 = new LinkedList<String>();
		System.out.println(list1.getClass().isArray());
	}
}
