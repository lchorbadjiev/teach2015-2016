#include <iostream>
using namespace std;

class Point {

	double x_, y_;
	
	static unsigned long COUNT_;
	static unsigned long LIVE_;
	
public:

	Point(double x=0.0, double y=0.0)
	: x_(x), y_(y)
	{
		COUNT_ ++;
		LIVE_ ++;
	}

	~Point() {
		LIVE_ --;
	}

	static unsigned long get_count() {
		return COUNT_;
	}

	static unsigned long get_live() {
		return LIVE_;
	}

};

unsigned long Point::COUNT_ = 0;
unsigned long Point::LIVE_ = 0;

int main() {
	cout << "count=" << Point::get_count() << endl;
	cout << "live=" << Point::get_live() << endl;
	
	Point p1, p2;

	cout << "count=" << Point::get_count() << endl;
	cout << "live=" << Point::get_live() << endl;

	{
		Point p1, p2;
		cout << "count=" << Point::get_count() << endl;
		cout << "live=" << Point::get_live() << endl;
	}
	
	cout << "count=" << Point::get_count() << endl;
	cout << "live=" << Point::get_live() << endl;
		
	return 0;
}

