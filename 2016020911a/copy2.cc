#include <iostream>
using namespace std;

template<typename T>
void copy1(T dst[], T src[], int size) {
	for(int i=0; i<size; ++i) {
		dst[i] = src[i];
	}
}

template<class T> 
void print(T a[], int size) {
	for(int i=0; i<size; ++i) {
		cout << a[i] << ' ';
	}
	cout << endl;
}

template<typename R, typename T>
R foo(T bar) {

}

template<typename T, typename R>
R foo(T bar, R ala_bala) {

}


int main() {

	int a[10], b[10];
	double c[10], d[10];
	for(int i=0; i<10; ++i) {
		a[i] = i*100;
		c[i] = i*0.1;
	}

	copy1<int>(b, a, 10);
	copy1<double>(d, c, 10);
	
	print<int>(b, 10);
	print(d, 10);
	
	
	// copy1(d, a, 10);
	foo<double>(10);
	return 0;
}

