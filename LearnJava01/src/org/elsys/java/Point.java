package org.elsys.java;

public class Point {

	private double x;
	private double y;
	
	public Point(double x, double y) {
		 this.x = x;
		 this.y = y;
	}
	
	public Point() {
		this(0.0, 0.0);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "Point(" + x + ", " + y + ")";
		
	}
	
	public static void main(String[] args) {
		Point p0 = null;
		Point p1 = new Point(1.0, 1.0);
		
		System.out.println("p0=" + p0);
		System.out.println("p1=" + p1);
		
		Point p = p1;
		System.out.println("p=" + p);
	}
}
