package org.elsys.postfix;

import java.util.Scanner;

public class WordTokenizer {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
			
			String[] tokens = line.split("\\s+");
			// for(int i=0; i<tokens.length; ++i) {
			for(String token: tokens) {
				token= token.trim();
				if(! token.isEmpty()) {
					System.out.println("<" + token + ">");
				}
			}
		}
		scanner.close();
	}
	
}
