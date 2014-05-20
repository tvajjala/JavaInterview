package com.trvajjala.java.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		list.add(44);
		list.add(22);
		list.add(33);
		list.add(88);

		ListIterator<Integer> li = list.listIterator();

		while (li.hasNext()) {

			if (li.nextIndex() == 2) {
				li.add(11);
			}

			int j = li.next();

			/*
			 * set method Replaces the last element returned by {@link #next} or {@link
			 * #previous} with the specified element
			 */
			if (j == 44) {
				//caont call immediately after add/remove 
				li.set(77);
				li.remove();
			}

			System.out.println(li.nextIndex() + " --> " + j);

		}

		System.out.println("------------------");

		while (li.hasPrevious()) {
			System.out.println(li.previousIndex() + "  <--- " + li.previous());
		}

	}

}
