package org.elsys.lambdas.ex01;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort01 {

	public ArraySort01() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		String[] testStrings = new String[] { "one", "two", "three", "four" };

		Arrays.sort(testStrings);
		for (String s : testStrings) {
			System.out.println(s);
		}

		Arrays.sort(testStrings, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {

				return s1.length() - s2.length();
			}

		});
		for (String s : testStrings) {
			System.out.println(s);
		}

		Arrays.sort(testStrings, (s1, s2) -> {
			return s1.length() - s2.length();
		});

		Arrays.sort(testStrings, (s1, s2) -> s1.length() - s2.length());

	}

}
