package org.elsys.java;

public class ShowString {

	
	public static void main(String[] args) {
		String hello = "Hello";
		String world = new String("World!");
		
		String message = hello + " " + world;
		
		System.out.println(message);
		
		String message42 = message + 42;
		System.out.println(message42);
		
		
		
		
	}
}
