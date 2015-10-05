#include <iostream>
using namespace std;

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

	int push(int val) {
		if(is_full()) {
			cout << "OOOPS: stack is full..." << endl;
			return -1;
		}
		data_[top_++] = val;
		return 0;
	}
	
	int pop(int& val) {
		if(is_empty()) {
			cout << "OOOPS: stack is empty..." << endl;
			return -1;
		}
		val = data_[--top_];
		return 0;
	}
	
};


int main() {
	Stack st;
	for(int i=0; i<100; i++) {
		if(st.push(i) == -1) {
			cout << "error in push..." << endl;
			break;
		}
	}
	while(true) {
		int val;
		if(st.pop(val) == -1) {
			cout << "error in pop..." << endl;
			break;
		}
		cout << "val = " << val << endl;
	}
	
	
	return 0;
}

