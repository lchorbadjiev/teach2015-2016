#include <iostream>
using namespace std;

class ListError{};

class List {
	
	struct Node {
		int data_;
		Node* next_;
		Node* prev_;
		
		Node(int val=0)
		: data_(val),
		  next_(0),
		  prev_(0)
		{}
	};

	Node* head_;
public:

	List()
	: head_(new Node())
	{
		head_->next_ = head_;
		head_->prev_ = head_;
	}

	bool empty() const {
		return head_ -> prev_ == head_;
	}

	void push_back(int val) {
		Node* ptr = new Node(val);
		Node* back = head_->prev_;
		
		back->next_ = ptr;
		ptr->prev_ = back;
		
		ptr->next_ = head_;
		head_->prev_ = ptr;
	}
	
	void push_front(int val) {
		Node* ptr = new Node(val);
		Node* front = head_->next_;
		
		head_ -> next_ = ptr;
		ptr->prev_ = head_;
		
		ptr -> next_ = front;
		front->prev_ = ptr;
	}
	
	int front() const {
		if( empty() ) {
			throw ListError();
		}
		return head_ -> next_ -> data_;
	}
	
	int back() const {
		if( empty() ) {
			throw ListError();
		}
		return head_ -> prev_ -> data_;
	}
	
	void pop_front() {
		if( empty() ) {
			throw ListError();
		}
		Node* front = head_ -> next_;
		Node* new_front = front -> next_;
		
		head_ -> next_ = new_front;
		new_front -> prev_ = head_;
		
		delete front;
	}
	
	void pop_back() {
		if(empty()) {
			throw ListError();
		}
		Node* back = head_ -> prev_;
		Node* new_back = back -> prev_;
		new_back->next_ = head_;
		head_ -> prev_ = new_back;
		
		delete back;
	}
	
	~List() {
		while(!empty()) {
			pop_back();
		}
		delete head_;
	}
	
	
	class iterator {
		Node* ptr_;
		
		iterator(Node* ptr)
		: ptr_(ptr)
		{}
		
		friend class List;
	public:
		int& operator*() {
			return ptr_->data_;
		}
		
		iterator& operator++() {
			ptr_ = ptr_-> next_;
			return *this;
		}

		iterator operator++(int) {
			iterator res(*this);
			ptr_ = ptr_ -> next_;
			return res;
		}
		
		bool operator==(const iterator& other) const {
			return ptr_ == other.ptr_;
		}
		
		bool operator!=(const iterator& other) const {
			return ! operator==(other);
		}
		
	};
	
	iterator begin() {
		return iterator(head_->next_);
	}
	
	iterator end() {
		return iterator(head_);
	}
};

int main() {
	List l1;
	cout << l1.empty() << endl;
	l1.push_back(20);
	cout << l1.empty() << endl;
	l1.push_front(-20);
	cout << l1.empty() << endl;
	
	cout << l1.front() << endl;
	cout << l1.back() << endl;
	
	l1.pop_front();
	cout << l1.front() << endl;
	cout << l1.back() << endl;
	
	l1.pop_back();
	cout << l1.empty() << endl;

	l1.push_back(10);
	l1.push_back(20);
	l1.push_back(30);
	l1.push_back(40);
	
	List::iterator it = l1.begin();
	cout << *it << endl;
	++ it;
	cout << *it << endl;	
	it ++;
	
	for(List::iterator i=l1.begin(); i!=l1.end(); ++ i) {
		cout << *i << ' ';
	}
	cout << endl;
	
	return 0;
}

