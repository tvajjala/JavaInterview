package com.trvajjala.collection;

import java.util.HashMap;
import java.util.Map;

public class MapWithObjectAsKEY {

	/**
	 * When we use Object As in Hash Based collections. we have to implement
	 * hashCode() and equals() methods. hashMap will check next added element
	 * hashCode is available or not if YES it will execute equals() method if
	 * that returns TRUE. it considers as duplicate.
	 * 
	 */
	public static void main(String[] args) {

		Map<KEY, Object> map = new HashMap<>();

		map.put(new KEY("ONE"), new Object());

		map.put(new KEY("ONE"), new Object());

		map.put(new KEY("TWO"), new Object());
		map.put(new KEY(), new Object());

		System.out.println(" Size Of the Map " + map.size());

	}
}
