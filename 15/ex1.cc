#include <iostream>
using namespace std;

class Point {
	double x_, y_;
public:
	Point() {
		x_= 0.0;
		y_= 0.0;
	}
	
	double get_x() const {
		return x_;
	}
	
	void set_x(double x) {
		x_ = x;
	}
	
	void print() const {
		cout << "(" << x_ << ", " << y_ << ")" << endl;
	}

};

int main() {

	const double pi = 3.14;
	// pi = 22.0/7;
	cout << "pi=" << pi << endl;

	const Point origin;
	origin.print();
	origin.get_x();

	// origin.set_x(22.0);
	
	return 0;
}

