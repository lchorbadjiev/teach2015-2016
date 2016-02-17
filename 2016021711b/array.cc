#include <iostream>
using namespace std;

class ArrayError{};
/*
	* copy constructor
	* operator=
	* destructor
	* iterator
*/


template<typename T>
class Array {
	int size_;
	int capacity_;
	T* data_;
	
	static int max(int a, int b) {
		return a>b?a:b;
	}
	
	void resize() {
		int new_capacity = max(2*capacity_, 1);
		T* new_data = new T[new_capacity];
		
		for(int i =0; i<capacity_; ++i) {
			new_data[i] = data_[i];
		}
		
		delete [] data_;
		
		data_ = new_data;
		capacity_ = new_capacity;
	}
	
public:
	Array() 
	: size_(0),
	  capacity_(0),
	  data_(0)
	{}
	
	Array(int size) 
	: size_(size),
	  capacity_(size),
	  data_(new T[size])
	{}
	
	int size() const {
		return size_;
	}
	
	bool empty() const {
		return size_== 0;
	}

	void push_back(T val) {
		if(size_ == capacity_) {
			resize();
		}
		data_[size_ ++] = val;
	}

	T front() const {
		if(empty()) {
			throw ArrayError();
		}
		return data_[0];
	}
	
	T back() const {
		if(empty()) {
			throw ArrayError();
		}
		return data_[size_ - 1];
	}

	T& operator[](int index) {
		return data_[index];
	}
	
	T& at(int index) {
		if(index<0 || index >= size_) {
			throw ArrayError();
		}
		return data_[index];
	}

	void pop_back() {
		if(empty()) {
			throw ArrayError();
		}
		size_ --;
	}

};

template<typename T>
void print(Array<T>& a) {
	cout << "ARR: ";
	for(int i=0; i<a.size(); ++i) {
		cout << a[i] << ' ';
	}
	cout << endl;
}

int main() {
	Array<int> a;
	cout << a.size() << endl;
	cout << a.empty() << endl;

	a.push_back(1);
	a.push_back(2);
	a.push_back(3);
	
	cout << a.size() << endl;
	cout << a.empty() << endl;
	
	cout << a.front() << ' ' << a.back() << endl;	
	for(int i = 0; i<a.size(); ++i) {
		cout << a[i] << ' ';
	}
	cout << endl;

	// cout << a[10] << endl;
	// cout << a.at(10) << endl;
	
	a.pop_back();
	cout << a.size() << endl;

	Array<double> d(10);
	
	for(int i=0;i<d.size(); ++i) {
		d[i] = i*3.14;
	}
	
	for(int i=0; i<d.size(); ++i) {
		cout << d[i] << ' ';
	}
	cout << endl;

	print(a);
	print(d);
	
	return 0;
}

