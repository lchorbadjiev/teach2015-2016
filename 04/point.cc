#include <iostream>
#include <cmath>
using namespace std;

class Point {
	double x_, y_;

public:
	Point() {
		cout << "Point() called..." << endl;
		x_ = 0.0;
		y_ = 0.0;
	}

	Point(double x, double y) {
		cout << "Point(x, y) called..." << endl;
		x_ = x;
		y_ = y;
	}

	double get_x() {
		return x_;
	}

	double get_y() {
		return y_;
	}
	
	void set_xy(double x, double y) {
		x_ = x;
		y_ = y;
	}
	
	void print() {
		cout << '(' << x_ << ',' << y_ << ')' << endl;
	}


	void add(Point other) {
		// x_ = x_ + other.x_;
		x_ += other.x_;
		y_ += other.y_;
	}
	
	void sub(Point other) {
		x_ -= other.x_;
		y_ -= other.y_;
	}

	double dist(Point other) {
		double dx = x_ - other.x_;
		double dy = y_ - other.y_;
		return sqrt(dx*dx + dy*dy);
	}
	
};

Point add(Point a, Point b) {
	Point res(a.get_x(), a.get_y());
	res.add(b);
	return res;
}


Point sub(Point a, Point b) {
	Point res(a.get_x(), a.get_y());
	res.sub(b);
	return res;
}




int main() {

	Point p1;
	Point p2(1.0, 2.0), p3(3.0, 4.0);
	
	p1.print();
	p2.print();
	p3.print();
	
	p1.set_xy(4,6);
	p1.print();
	
	p1.add(p2);
	p1.print();
	
	p1.sub(p2);
	p1.print();
	
	p1 = add(p2,p3);
	p1.print();


	p1 = sub(p2, p3);
	p1.print();

	cout << "dist p2 - p3: " << p2.dist(p3) << endl;
		
    return 0;
}

