package com.trvajjala.java.collection;

public class ClonableTest implements Cloneable {

	public ClonableTest() {
		System.out.println("  contructor() ");
	}

	public final int a = 10;
	String name;

	public ClonableTest(String name) {
		System.out.println("  contructor(name) ");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ClonableTest test = new ClonableTest("TRVAJJALA");

		System.out.println(test.getName() + test.a);

		ClonableTest o = test.clone();

		System.out.println(" ---  " + o.getName() + o.a);

	}

	@Override
	protected ClonableTest clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (ClonableTest) super.clone();
	}

}
