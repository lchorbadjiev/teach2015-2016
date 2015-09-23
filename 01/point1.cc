#include <iostream>
using namespace std;

class Point {

	double x_;
	double y_;

public:
	Point() {
		cout << "Point() called..." << endl;
		x_ = 0.0;
		y_ = 0.0;
	}

	Point(double x, double y) {
		cout << "Point(" << x << ',' << y << ") called..." << endl;
		x_ = x;
		y_ = y;
	}

	void set_x(double val) {
		x_ = val;
	}
	
	void set_y(double val) {
		y_ = val;
	}


	double get_x() {
		return x_;
	}

	double get_y() {
		return y_;
	}
};


int main() {
	Point p1;
	p1.set_x(1.0);
	p1.set_y(2.0);
	
	Point p2;
	p2.set_x(3.0);
	p2.set_y(6.0);
	
	cout << p1.get_x() << ' ' << p1.get_y() << endl;
	cout << p2.get_x() << ' ' << p2.get_y() << endl;
	
	
	Point p3(-1.0, -2.0), p4(-3.0, -6.0);
	cout << p3.get_x() << ' ' << p3.get_y() << endl;
	cout << p4.get_x() << ' ' << p4.get_y() << endl;
	
	return 0;
}

