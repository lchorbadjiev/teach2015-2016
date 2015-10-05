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

	void push(int val) {
		if(is_full()) {
			cout << "OOOPS: stack is full..." << endl;
			return;
		}
		data_[top_++] = val;
	}
	
	int pop() {
		if(is_empty()) {
			cout << "OOOPS: stack is empty..." << endl;
			return 0;
		}
		return data_[--top_];
	}
	
};


int main() {
	Stack st;
	for(int i=0; i<100; i++) {
		st.push(i);
	}
	return 0;
}

