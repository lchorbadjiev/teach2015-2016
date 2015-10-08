#include <iostream>
using namespace std;

class StackError {
	int status_;
public:
	StackError(int status) {
		status_ = status;
	}

	int get_status() {
		return status_;
	}
};

#define STACK_SIZE 10

class Stack {
	int data_[STACK_SIZE];
	int top_;
public:
	Stack() {
		top_ = 0;
	}
	
	bool is_empty() {
		return top_ == 0;
	}
	
	bool is_full() {
		return top_ == STACK_SIZE;
	}

	void push(int val) {
		if(is_full()) {
			cout << "OOOPS: stack is full..." << endl;
			throw StackError(2);
		}
		data_[top_++] = val;
	}

	int pop() {
		if(is_empty()) {
			cout << "OOOPS: stack is empty..." << endl;
			throw StackError(4);
		}
		return data_[--top_];
	}

};


int main() {
	Stack st;
	for(int i=0; i<10; i++) {
		st.push(i);
	}
	
	try {
		st.push(11111);
		cout << "this is never exectued..." << endl;
	} catch(StackError ex) {
		cout << "exception catched..." << endl;
		cout << "status: " << ex.get_status() << endl;
	}
	cout << "this is next..." << endl;
	
	while(! st.is_empty()) {
		cout << st.pop() << endl;
	}
	
	try {
		st.pop();
	} catch(StackError ex) {
		cout << "exception catched..." << endl;
		cout << "status: " << ex.get_status() << endl;
	}
	
	return 0;
}

