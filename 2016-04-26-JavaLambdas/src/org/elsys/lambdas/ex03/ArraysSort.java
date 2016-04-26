package org.elsys.lambdas.ex03;

import java.util.List;
import java.util.Arrays;

public class ArraysSort {

	public ArraysSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String[] testStrings = new String[] { "one", "two", "three" };

		List<String> strings = Arrays.asList(testStrings);

		strings.forEach((s) -> {
			System.out.println(s);
		});

		strings.forEach(System.out::println);
	}
}
