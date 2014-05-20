package com.trvajjala.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String input = "hello world 34";

		Pattern p = Pattern.compile("[\\D]{2}");

		Matcher m = p.matcher(input);

		while (m.find()) {
			System.out.println("Found : " + m.group());
		}

		System.out.println("  ****************** END ******************");
	}


}
