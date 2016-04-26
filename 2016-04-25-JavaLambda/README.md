#Java 8 Lambdas

## Usage of interfaces

```java
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

```

```
ala
bala
portokala
```

## Replace single method interface with Java 8 lambda

```java
	String[] testStrings = new String[] { "one", "two", "three", "four" };

	Arrays.sort(testStrings, (s1, s2) -> {
		return s1.length() - s2.length();
	});

	for (String s : testStrings) {
		System.out.println(s);
	}
```

Or even shorter:

```java
	Arrays.sort(testStrings, (s1, s2) -> s1.length() - s2.length());
```
 
Or we can use different comparator:

```java
	Arrays.sort(testStrings, 
				(s1, s2) -> s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));

```

```
one
three
two
four
```

## Example: Numeric integration

### Simplest method of integration

[Numerical Integration](https://en.wikipedia.org/wiki/File:Integration_rectangle.svg)

### Single method interface `Integrable`

```java
public interface Integrable {

	double eval(double x);
	
}
```

### Method `integrate`

```java
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
```

### Testing integration

```java
	public static void integrationTest(Integrable function, double x1, double x2) {
		for (int i = 1; i < 7; ++i) {
			int slices = (int) Math.pow(10, i);

			double result = integrate(function, x1, x2, slices);
			System.out.printf(" For slices =%,10d result = %,.8f%n", slices, result);
		}
		System.out.println();
	}
```

### Integration examples

```java
	public static void main(String[] args) {
		integrationTest((x) -> x*x, 10, 100);
		integrationTest((x) -> x*x*x, 10, 100);
		integrationTest((x) -> Math.sin(x), 0, Math.PI);
	}
```


## Example: Timing utility

### Single method interface `Operation`

```java
public interface Operation {

	void runOperation();
}
```

### Timing operation function

```java
	private static final double NANO = 1_000_000_000;

	public static void timeOperation(Operation operation) {
		long startTime = System.nanoTime();
		operation.runOperation();
		long endTime = System.nanoTime();
		double elapsedSeconds = (endTime - startTime) / NANO;
		System.out.printf("elapsed time: %.3f seconds.%n", elapsedSeconds);
	}
```

### Testing utilities

```java
public class TimingTests {

	public static void main(String[] args) {
		for (int i = 3; i < 8; i++) {
			int size = (int) Math.pow(10, i);
			System.out.printf("Sorting array of length %,d.%n", size);
			TimingUtils.timeOperation(() -> sortArray(size));
		}
	}

	public static double[] randomNums(int length) {
		double[] nums = new double[length];
		for (int i = 0; i < length; i++) {
			nums[i] = Math.random();
		}
		return (nums);
	}

	public static void sortArray(int length) {
		double[] nums = randomNums(length);
		Arrays.sort(nums);
	}
}
```

## Summary
**Code that expects single method interface can use lambdas**
