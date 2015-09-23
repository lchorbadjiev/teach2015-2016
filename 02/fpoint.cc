#include <iostream>
using namespace std;


class Fpoint {
	double x_;
	double y_;
public:

	void set_x(double x) {
		if(x<0.0) {
			cout << "ooops!!!" << endl;
			return;
		}
		x_ = x;
	}
	
	void set_y(double y) {
		if(y<0.0) {
			cout << "ooops y!!!" << endl;
			return;
		}
		y_ = y;
	}

};

int main() {
	Fpoint p1;
	
	// p1.x_ = -1.0;
	// p1.y_ = -2.0;
	p1.set_x(-1.0);
	p1.set_y(-2.0);
	
	
	
	
	return 0;
}
