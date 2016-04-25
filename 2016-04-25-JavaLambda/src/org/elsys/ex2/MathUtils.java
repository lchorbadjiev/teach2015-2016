package org.elsys.ex2;

public class MathUtils {

	public MathUtils() {
		// TODO Auto-generated constructor stub
	}

	public static double integrate(Integrable function, double x1, double x2, int slices) {
		if (slices < 1) {
			slices = 1;
		}
		double delta = (x2 - x1) / slices;
		double start = x1 + delta / 2;
		double sum = 0;
		for (int i = 0; i < slices; i++) {
			sum += delta * function.eval(start + delta * i);
		}
		return (sum);
	}

	public static void integrationTest(Integrable function, double x1, double x2) {
		for (int i = 1; i < 7; ++i) {
			int slices = (int) Math.pow(10, i);

			double result = integrate(function, x1, x2, slices);
			System.out.printf(" For slices =%,10d result = %,.8f%n", slices, result);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		integrationTest((x) -> x*x, 10, 100);
		integrationTest((x) -> x*x*x, 10, 100);
		integrationTest((x) -> Math.sin(x), 0, Math.PI);
	}
}
