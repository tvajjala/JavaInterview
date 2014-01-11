package com.trvajjala.java.collection;

import java.util.Hashtable;

public class HashingBucket {

	public static void main(String[] args) {

		Hashtable<String, String> table = new Hashtable<String, String>();

		/**
		 * COLLISION For two different keys k1 and k2, if we have h(k1) = h(k2),
		 * then this is called collision in hashtable.
		 * 
		 * When we have a collision, there are multiple methodologies available
		 * to resolve it. To name a few hashtable collision resolution
		 * technique, ‘separate chaining’, ‘open addressing’, ‘robin hood
		 * hashing’, ‘cuckoo hashing’, etc. Java’s hashtable uses ‘separate
		 * chaining’ for collision resolution in Hashtable.
		 */
		String s1 = new String("HASHCHECK");
		System.out.println(s1.hashCode());
		String s2 = new String("HASHCHECK");
		System.out.println(s2.hashCode());

		System.out.println(table.put(s1, s2));
		System.out.println(table.put(s1, s2));

		/*
		 * The general contract of <code>hashCode</code> is: <ul> <li>Whenever
		 * it is invoked on the same object more than once during an execution
		 * of a Java application, the <tt>hashCode</tt> method must consistently
		 * return the same integer, provided no information used in
		 * <tt>equals</tt> comparisons on the object is modified.
		 */

		/*
		 * <li>If two objects are equal according to the <tt>equals(Object)</tt>
		 * method, then calling the <code>hashCode</code> method on each of the
		 * two objects must produce the same integer result.
		 */

	}
}
