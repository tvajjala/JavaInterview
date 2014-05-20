package com.trvajjala.core.objcreation;

public class Incarnation implements Cloneable {

	String name;

	String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return (name == null) ? super.toString() : name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	// clone an object need to override below method but this method is not part
	// of Cloneable Interface it is part of Object class 
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
