package org.elsys.postfix;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Postfix {

	private Map<String, Operation> operations = new HashMap<String, Operation>();
	private Stack<Double> context = new Stack<Double>();

	public void addOperation(Operation op) {
		op.setContext(context);
		operations.put(op.getName(), op);
	}

	public Operation getOperation(String name) {
		return operations.get(name);
	}

	public void interpret(InputStream in) {
		Scanner scanner = new Scanner(in);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split("\\s+");
			for (String token : tokens) {
				token = token.trim();
				if (token.isEmpty()) {
					continue;
				}
				// check for operation <token>
				if (operations.containsKey(token)) {
					Operation op = operations.get(token);
					System.out.println("O: <" + token + ">");
					op.eval();
				} else {
					// try to interpret <token> as double
					try {
						double value = Double.parseDouble(token);
						context.push(value);
						System.out.println("D: <" + value + ">");
					} catch (NumberFormatException ex) {
						// unknown operation
						// ....
						System.out.println("Unknown operation <" + token + ">");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Postfix postfix = new Postfix();
		postfix.addOperation(new Plus());
		postfix.interpret(System.in);
	}
}
