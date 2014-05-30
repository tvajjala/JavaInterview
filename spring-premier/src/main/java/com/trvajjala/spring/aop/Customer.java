package com.trvajjala.spring.aop;

public class Customer {

	private String name;
	private String mobile;

	public Customer() {

	}

	public Customer(String name, String mobile) {
		this.name = name;
		this.mobile = mobile;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Object[" + name + " , " + mobile + "]";
	}

}
