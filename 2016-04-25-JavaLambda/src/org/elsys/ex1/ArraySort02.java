package org.elsys.ex1;

import java.util.Arrays;

public class ArraySort02 {

	public ArraySort02() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		String[] testStrings = new String[] { "one", "two", "three", "four" };

		Arrays.sort(testStrings, (s1, s2) -> {
			return s1.length() - s2.length();
		});

		Arrays.sort(testStrings, (s1, s2) -> s1.length() - s2.length());

		for (String s : testStrings) {
			System.out.println(s);
		}

		Arrays.sort(testStrings, (s1, s2) -> s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
		for (String s : testStrings) {
			System.out.println(s);
		}
		
	}
}
