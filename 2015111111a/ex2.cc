#include <iostream>
using namespace std;

class Point {
	static unsigned long COUNT_;
	static unsigned long LIVE_;
	
	double x_, y_;
public:
	Point(double x=0.0, double y=0.0)
	: x_(x), y_(y)
	{
		COUNT_ ++;
		LIVE_ ++;
	}
	
	~Point() {
		-- LIVE_;
	}

	static unsigned long count() {
		return COUNT_;
	}

	static unsigned long live() {
		return LIVE_;
	}

};

unsigned long Point::COUNT_ = 0;
unsigned long Point::LIVE_ = 0;

int main() {
	cout << "count=" << Point::count() << endl;
	cout << "live =" << Point::live() << endl;

	Point p1(1,1), p2(2,2);

	cout << "count=" << Point::count() << endl;
	cout << "live =" << Point::live() << endl;
	
	{
	
		Point p3(3,3), p4(4,4);
		cout << "count=" << Point::count() << endl;
		cout << "live =" << Point::live() << endl;
		
	}
	
	cout << "count=" << Point::count() << endl;
	cout << "live =" << Point::live() << endl;
	
	return 0;
}

