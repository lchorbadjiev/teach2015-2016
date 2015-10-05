#include <iostream>
using namespace std;

#define STACK_SIZE 10

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
			throw StackError(1);
		}
		data_[top_++] = val;
	}
	
	int pop() {
		if(is_empty()) {
			cout << "OOOPS: stack is empty..." << endl;
			throw StackError(2);
		}
		return data_[--top_];
	}
	
};


int main() {
	Stack st;
	
	try {
		for(int i=0; i<100; i++) {
			st.push(i);
		}
		
		cout << "this is not executed..." << endl;
	} catch(StackError ex) {
		cout << "StackError catched..." << endl;
		cout << "StackError::status=" << ex.get_status() << endl;
	}
	cout << "after catch..." << endl;
	
	
	try {	

		while(true) {
			cout << "val=" << st.pop() << endl;
		}

	} catch(StackError ex) {
		cout << "StackError in pop catched..." << endl;
		cout << "StackError::status=" << ex.get_status() << endl;
	}
	
	
	return 0;
}



