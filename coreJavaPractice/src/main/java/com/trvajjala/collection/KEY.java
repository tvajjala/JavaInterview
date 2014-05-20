package com.trvajjala.collection;

public class KEY {

	String name;

	public KEY() {
	}

	public KEY(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		System.out.println("	hashCode	");

		return (name == null) ? super.hashCode() : name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("	equals	"+ super.equals(obj));
		return true;
	}
}
