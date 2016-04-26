package org.elsys.ex3;

public class TimingUtils {

	public TimingUtils() {
		// TODO Auto-generated constructor stub
	}

	private static final double NANO = 1_000_000_000;

	public static void timeOperation(Operation operation) {
		long startTime = System.nanoTime();
		operation.runOperation();
		long endTime = System.nanoTime();
		double elapsedSeconds = (endTime - startTime) / NANO;
		System.out.printf("elapsed time: %.3f seconds.%n", elapsedSeconds);
	}
}
