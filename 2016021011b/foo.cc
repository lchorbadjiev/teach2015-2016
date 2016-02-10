#include <iostream>
using namespace std;

template<typename T>
void foo(T bar) {
	cout << "foo(" << bar << ") called..." << endl;
}


template<typename R>
R bar() {
	R res = 0;
	return res;
}

template<typename T>
T foo1(T val) {
	return val;
}

template<typename R, typename T>
R bar1(T val) {
	R res = val;
	return res;
}


int main() {
	foo(1.1);
	foo(10);
	
	int val = bar<int>();
	
	int val1 = foo1(10);
	
	bar1<double, int>(10);
	bar1<double>(10);
	
	
	return 0;
}

