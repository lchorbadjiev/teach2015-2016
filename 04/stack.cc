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
			cout << "OOOPs: push() called on full stack..." << endl;
			return;
		}
		data_[top_] = val;
		top_ ++;
	}
	
	int pop() {
		if(is_empty()) {
			cout << "OOOOPS: pop() called on empty stack..." << endl;
			return 0;
		}
		top_--;
		return data_[top_];
	}
	
};

int main() {
	Stack st;
	cout << "st.is_empty() = " << st.is_empty() << endl;
	
	st.push(10);
	cout << "st.is_empty() = " << st.is_empty() << endl;
	
	cout << st.pop() << endl;
	cout << "st.is_empty() = " << st.is_empty() << endl;

	for(int i=0; i<10; ++i) {
		st.push(i*10);
	}	
	cout << "st.is_full() = " << st.is_full() << endl;
	st.push(100);
	
	while(!st.is_empty()) {
		cout << st.pop() << endl;
	}
	
	/*
	cout << true << ' ' << false << endl;
	cout << boolalpha << true << ' ' << false << endl;
	*/
	
	st.pop();
		
	return 0;
}

