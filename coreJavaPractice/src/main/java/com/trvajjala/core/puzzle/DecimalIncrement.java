package com.trvajjala.core.puzzle;

public class DecimalIncrement {

	public static void main(String[] args) {

		double d = 0.0d;
		for (int i = 0; i < 7; i++) {
			d = d + 0.1d;
			System.out.println(d);
		}
		System.out.println("---------");
		System.out.println(d);
	}
}
