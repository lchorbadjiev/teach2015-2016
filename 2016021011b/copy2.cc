#include <iostream>
using namespace std;

template<typename T>
void copy1(T dst[], T src[], int size) {
	for(int i=0; i<size; ++i) {
		dst[i]=src[i];
	}
}

template<class T> 
void print(T a[], int size) {
	for(int i=0; i<size; ++i) {
		cout << a[i] << ' ';
	}
	cout << endl;
}


int main() {

	int a[10], b[10];
	double c[10], d[10];
	
	for(int i=0; i<10; ++i) {
		a[i] = 100*i;
		c[i] = 0.1*i;
	}
	
	copy1<int>(b, a, 10);
	copy1<double>(d, c, 10);

	print<int>(b, 10);
	print<double>(d, 10);

	// copy1<int>(b, c, 10);
	print(b, 10);
	print(d, 10);
		
	return 0;
}







