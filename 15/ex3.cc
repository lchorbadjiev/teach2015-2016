#include <iostream>
using namespace std;

void foo(int bar) {
	cout << "foo(1)(bar=" << bar << ")" << endl;
}

void foo(int bar1, int bar2) {
	cout << "foo(2)(bar1=" << bar1 << ", bar2=" << bar2 << ")" 
		<< endl;
}

void foo(double bar) {
	cout << "foo(1d)(bar=" << bar << ")" << endl;
}


void bar(int foo1, int foo2=0) {
	cout << "bar(foo1=" << foo1 << ", " << "foo2=" << foo2
		<< ")" << endl;
}

int main() {
	foo(42);
	foo(42, 21);
	foo(3.14);
	
	bar(42, 21);
	bar(42);
	
	return 0;
}

