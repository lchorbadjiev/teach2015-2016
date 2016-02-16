#include <iostream>
using namespace std;

#define MAX(a,b) ((a)>(b)?(a):(b))

class ArrayError {};

template<typename T>
class Array {
	T* data_;
	int size_;
	int capacity_;
	
	void resize() {
		int new_capacity = MAX(2* capacity_, 1);
		T* new_data = new T[new_capacity];
		for(int i=0; i< capacity_; ++i) {
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
	
	~Array() {
		delete [] data_;
	}
	
	Array(int size)
	: size_(size),
	  capacity_(size),
	  data_(new T[size])
	{}
	 
	 
	void push_back(T val) {
		if( size_ >= capacity_) {
			resize();
		}
		data_[size_++] = val;
	}

	bool empty() const {
		return size_ == 0;
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
		return data_[size_-1];
	}

	void pop_back() {
		if(empty()) {
			throw ArrayError();
		}
		
		size_--;
	}
	
	int size() const {
		return size_;
	}

	T& operator[](int index) {
		return data_[index];
	}
	
	T& at(int index) {
		if(index < 0 || index >=size_) {
			throw ArrayError();
		}
		return data_[index];
	}

	// copy cnstr
	// operator=
	// iterator
	
	
};

int main() {
	Array<int> a;
	a.push_back(1);
	a.push_back(2);
	a.push_back(3);
	
	cout << "front: " << a.front() << endl;
	cout << "back:  " << a.back() << endl;
	cout << "size:  " << a.size() << endl;
	a.pop_back();
	cout << "back:  " << a.back() << endl;
	cout << "size:  " << a.size() << endl;
	
	for(int i=0; i<a.size(); ++i) {
		cout << a[i] << ' ';
	}
	cout << endl;
	
	// cout << a[10] << endl;
	// cout << a.at(10) << endl;	

	Array<double> b(10);
	for(int i=0; i<b.size(); ++i) {
		b[i] = 3.14 * i;
	}
	
	for(int i=0; i<b.size(); ++i) {
		cout << b[i] << ' ';
	}
	cout << endl;
	
	
	return 0;
}

