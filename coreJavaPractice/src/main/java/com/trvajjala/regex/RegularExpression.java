package com.trvajjala.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		wordCount();
		duplicateCount();
		
		regexGroup();
	}

	public static void regexGroup() {
		String input = "hello world 34";

		Pattern p = Pattern.compile("[\\D]{5}");

		Matcher m = p.matcher(input);

		while (m.find()) {
			System.out.println("Found : " + m.group());
		}

		System.out.println("  ****************** END ******************");
	}

	public static void wordCount() {

		String text = "using regex find out how many words are there in the given text $#$#$";

		// non space characters several \\S+
		// total words =\\w+
		Pattern p = Pattern.compile("\\S+");

		Matcher m = p.matcher(text);
		int count = 0;
		while (m.find()) {
			System.out.print(" | " + m.group());
			count++;
		}
		System.out.println();

		System.out.println("total word count " + count);

		System.out.println(m.groupCount());

	}

	public static void duplicateCount() {
		String text = "using regex find find out how many many spaces are there in the given text text $$$$ 222";//special characters are not treated as words

		//  space characters several \\s+
		// non words =\\W+
		Pattern p = Pattern.compile("\\b(\\w+)\\s+\\1\\b");

		Matcher m = p.matcher(text);
		int count = 0;
		while (m.find()) {
			System.out.print(" | " + m.group());
			count++;
		}
		System.out.println();

		System.out.println("total space count " + count);

	}

}
