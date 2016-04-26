package org.elsys.lambdas.ex04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamsExample {

	public StreamsExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("words.txt"))
		.filter(s -> s.length() > 3)
		.map(s -> s.length())
		.distinct()
		.forEach(System.out::println);

	}
}
