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

![Numerical Integration](https://en.wikipedia.org/wiki/File:Integration_rectangle.svg)

