package com.trvajjala.core.objcreation;

public class ObjectGens {

	/**
	 * There are Three ways we can create Objects 
	 * 
	 * 1. Using new Operator 
	 * 2. Class.forName 
	 * 3. De-serialization 
	 * 4. Java Reflection
	 * 5. Cloning
	 */
	public static void main(String[] args) throws Exception {

		Incarnation test = (Incarnation) Class.forName(
				"com.trvajjala.core.Incarnation").newInstance();

		test.setName("Object Generation Through Reflection");

		System.out.println(" " + test);

		Incarnation clonedBaby = (Incarnation) test.clone();
		// cloneable object will retain its states from its parent
		clonedBaby.setAge("44");
		System.out.println(test.getAge());
		System.out.println(clonedBaby.getName());

	}

}
