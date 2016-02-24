package org.elsys.postfix;

public class Plus extends Operation{
	
	public Plus() {
		super("+");
	}

	@Override
	public void eval() {
		double v1 = getContext().pop();
		double v2 = getContext().pop();
		
		double res = v1 + v2;
		System.out.println("R: " + res);
		getContext().push(res);
	}

}
