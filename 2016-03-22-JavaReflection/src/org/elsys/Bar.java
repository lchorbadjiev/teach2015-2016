package org.elsys;

import java.io.Serializable;

public final class Bar implements Serializable {

	private static final long serialVersionUID = -1603123619749251519L;

	private String bar;

	public Bar(String bar) {
		this.bar = bar;
	}

	public Bar(int val) {
		this.bar = "" + val;
	}

	@Foo	
	public String getBar() {
		return bar;
	}

}
