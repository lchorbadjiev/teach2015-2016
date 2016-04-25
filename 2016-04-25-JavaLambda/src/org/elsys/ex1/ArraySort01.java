package org.elsys.ex1;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort01 {

	public ArraySort01() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String[] testStrings = new String[] { "ala", "bala", "portokala" };

		Arrays.sort(testStrings, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				
				return s1.length() - s2.length();
			}
		});
		
		for(String s: testStrings) {
			System.out.println(s);
		}
	}
}
