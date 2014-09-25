package com.trvajjala.core.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListPuzzel {

	public static void main(String[] args) {

		List<String> circus1 = new ArrayList<String>();
		circus1.add("Monkey");
		circus1.add("Elephant");

		List<String> zoo1 = new ArrayList<String>(circus1);
		zoo1.add("Lion");
		System.out.println(zoo1+"zoo1 size: " + zoo1.size());

		String[] circus2 = { "Monkey", "Elephant" };
		
		/**
		 * The method asList() of Arrays returns a fixed size List instance.
		 * This instance serves as a bridge for an array to a collection. We
		 * cannot add a new element or remove an element from the returned
		 * instance. We can set the value of an already existing element using
		 * its index. Any change we do will be propagated to the array source.
		 */
		List<String> zoo2 = Arrays.asList(circus2);
		zoo2.add("Tiger");//you can't add new element to array -> list bridge
		System.out.println(zoo2+"zoo2 size: " + zoo2.size());
	}
}
