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

	Point& operator+=(const Point& p) {
		x_ += p.x_;
		y_ += p.y_;
		return *this;
	}

	Point& operator-=(const Point& p) {
		x_ -= p.x_;
		y_ -= p.y_;
		return *this;
	}

};

Point operator+(const Point& p1, const Point& p2) {
	Point res(p1.get_x(), p1.get_y());
	res += p2;
	return res;
}

Point operator-(const Point& p1, const Point& p2) {
	Point res(p1.get_x(), p1.get_y());
	res -= p2;
	return res;
}

Point operator-(const Point& p) {
	Point res(-p.get_x(), -p.get_y());
	return res;
}

ostream& operator<<(ostream& out, const Point& p) {
	out << '(' << p.get_x() << ',' << p.get_y() << ')';
	return out;
}

int main() {
	Point p1(1,1), p2(2,2), p;
	p1.print();
	p2.print();
	
	p1+=p2;
	p1.print();
	
	p1-=p2;
	p1.print();
	
	int a=0, b=0, c=0;
	a = (b = 3);
	a = (b += 1);
	(cout << a) << "," << b << endl;
	
	p = p1;
	p = (p1 += p2);
	p.print();
	
	p = p1 + p2;
	p.print();

	p = p1 - p2;
	p.print();

	p = -p1;
	p.print();
	
	
	((cout << p) << p1) << p2 << endl;
	
	return 0;
}

