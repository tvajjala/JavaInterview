package com.trvajjala.core;

import com.trvajjala.regex.RegularExpression;

public class ObjectGens {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		RegularExpression test = (RegularExpression) Class.forName("com.trvajjala.regex.RegularExpression")
				.newInstance();

		System.out.println(" "+ test);
		
	}

	class Test {
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
