package org.elsys.lambdas.ex02;

public class TimeUtils {

	public TimeUtils() {
		// TODO Auto-generated constructor stub
	}

	public static double NANO = 1E9;
	
	public static double timeOperation(Operation op) {
		long startTime = System.nanoTime();
		op.eval();
		long endTime = System.nanoTime();
		
		double result = (double) ((endTime - startTime)/NANO);
		return result;
	}
	
}
