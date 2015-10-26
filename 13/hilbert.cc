#include <iostream>
using namespace std;

void b(int, int);
void c(int, int);
void d(int, int);

void a(int i, int h) {

	if(i<=0) {
		return;
	}
	d(i-1, h);
	cout << '-' << h << ' ' << 0 << ' ' << "rlineto" << endl;
	a(i-1, h);
	cout << 0 << ' ' << '-' << h << ' ' << "rlineto" << endl;
	a(i-1, h);
	cout << h << ' ' << 0 << ' ' << "rlineto" << endl;
	b(i-1, h);
	
}

void b(int i, int h) {
	if(i<=0) {
		return;
	}
	c(i-1, h);
	cout << 0 << ' ' << h << ' ' << "rlineto" << endl;
	b(i-1, h);
	cout << h << ' ' << 0 << ' ' << "rlineto" << endl;
	b(i-1, h);
	cout << 0 << ' ' << '-' << h << ' ' << "rlineto" << endl;
	a(i-1, h);
}

void c(int i, int h) {
	if(i<=0) {
		return;
	}
	b(i-1, h);
	cout << h << ' ' << 0 << ' ' << "rlineto" << endl;
	c(i-1, h);
	cout << 0 << ' ' << h << ' ' << "rlineto" << endl;
	c(i-1, h);
	cout << '-' << h << ' ' << 0 << ' ' << "rlineto" << endl;
	d(i-1, h);
}

void d(int i, int h) {
	if(i<=0) {
		return;
	}
	a(i-1, h);
	cout << 0 << ' ' << '-' << h << ' ' << "rlineto" << endl;
	d(i-1, h);
	cout << '-' << h << ' ' << 0 << ' ' << "rlineto" << endl;
	d(i-1, h);
	cout << 0 << ' ' << h << ' ' << "rlineto" << endl;
	c(i-1, h);
}



int main() {
	cout << "newpath" << endl;

	cout << "520 520 moveto" << endl;	
	a(1, 512);

	cout << "520 520 moveto" << endl;	
	a(3, 512/8);
	
	cout << "520 530 moveto" << endl;
	cout << "-512 0 rlineto" << endl;
	cout << "stroke" << endl;
	cout << "showpage" << endl;
	
	return 0;
}

