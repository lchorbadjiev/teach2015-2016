#include <iostream>
using namespace std;

class Shape {
public:
	virtual void draw() const = 0;

};

class Circle: public Shape {
	double x_, y_;
	double r_;
public:
	Circle(double x, double y, double r)
	: x_(x), y_(y), r_(r)
	{}


	void draw() const {
		cout << "C((" << x_ << "," << y_ << ")," << r_ << ")" << endl;
	}
};


int main() {
	// Shape sh;
	Circle c1(0,0,2);
	Shape* psh = &c1; 
	psh -> draw();
	
	
	return 0;
}

