package org.elsys;

public class Bar {
	private String bar;
	private String foo;
	
	@MapAs(name="fullbar")
	private String fullBar;
	
	public Bar(String bar, String foo) {
		this.bar = bar;
		this.foo = foo;
		this.fullBar = bar + foo;
	}
	
	public String getBar() {
		return bar;
	}
	
	public String getFoo() {
		return foo;
	}

	public String getFullBar() {
		return fullBar;
	}
}
