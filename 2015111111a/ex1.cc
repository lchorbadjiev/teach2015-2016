#include <iostream>
using namespace std;

class Point {
	double x_, y_;
public:
	Point(double x=0.0, double y=0.0)
	: x_(x), y_(y)
	{}
	
	double get_x() const {
		return x_;
	}
	
	double get_y() const {
		return y_;
	}
	
	void print() const {
		cout << "(" << x_ << ", " << y_ << ")" << endl;
	}

	Point& set_x(double x) {
		x_ = x;
		return *this;
	}

	Point& set_y(double y) {
		y_ = y;
		return *this;
	}
};


int main() {
	Point p1(1,1), p2(2,2);
	p1.print();
	p2.print();
	
	p1.set_x(1.1).set_y(1.2);
	p2.set_x(2.2).set_y(2.3);
	
	p1.print();
	p2.print();
	

	return 0;
}

