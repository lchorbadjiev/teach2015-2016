#include <iostream>
using namespace std;

class Point {
	double x_, y_;
public:
/*
	Point()
	: x_(0.0), y_(0.0)
	{}
*/
	
	explicit Point(double x=0.0, double y=0.0) 
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
};



int main() {
	const Point origin;
	origin.print();
	
	Point p1(1,1), p2(-2, -2);
	p1.print();
	p2.print();
	
	
	Point p3(1);
	p3.print();
	
	// p3=3.14;
	p3.print();
	
	return 0;
}

