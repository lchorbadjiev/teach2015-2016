#include <iostream>
using namespace std;

class FPoint {
	double x_, y_;
public:

	void set_x(double x) {
		if(x<0.0) {
			cerr << "not in first quadrant!!!" << endl;
			return;
		}
		x_ = x;
	}	

	void set_y(double y) {
		if(y<0.0) {
			cerr << "not in first quadrant!!!" << endl;
			return;
		}
		y_ = y;
	}	

};

int main() {
	FPoint p1;
	p1.set_x( -1.0);
	p1.set_y( -2.0);

	

	return 0;
}

