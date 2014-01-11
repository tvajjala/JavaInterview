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
			System.out.println(li.nextIndex() + " --> " + li.next());
		}

		System.out.println("------------------");

		while (li.hasPrevious()) {
			System.out.println(li.previousIndex() + "  <--- " + li.previous());
		}

	}

}
