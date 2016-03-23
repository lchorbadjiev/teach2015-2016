package org.elsys;

import java.io.Serializable;

public class Bar implements Serializable {
	private static final long serialVersionUID = 1746958359785602722L;

	private String bar;
	
	public Bar(String bar) {
		this.bar = bar;
	}

	public String getBar() {
		return bar;
	}
}
