package org.elsys.java;

public class ShowArray {

	public static void main(String[] args) {
		for(int i = 0; i < args.length; ++i) {
			System.out.println("args[" + i + "]=" + args[i]);
		}
		
		String[] arr = new String[10];
		for(int i = 0; i < arr.length; ++i) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
		for(int i = 0; i< arr.length; ++i) {
			arr[i] = "arr[" + i + "]";
		}
		for(String a: arr) {
			System.out.println(a);
		}
		
	}
	
}
