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
            cout << "OOOPS: push() called on full stack..." << endl;
            return;
        }
    
        data_[top_] = val;
        top_ ++;
    }
    
    int pop() {
        if(is_empty()) {
            cout << "OOOPS: pop() call on empty stack..." << endl;
            return 0;
        }
        top_--;
        return data_[top_];   
    }

};


int main() {

    Stack st;
    cout << "st.is_empty() = " << st.is_empty() << endl;
    cout << "st.is_full() = " << st.is_full() << endl;
    
    for(int i = 0; i<10; i++) {
        st.push(10*i);
    }
    st.push(100);
    
    while(!st.is_empty()) {
        cout << st.pop() << endl;
    }
    
    st.pop();
    
    return 0;
}

