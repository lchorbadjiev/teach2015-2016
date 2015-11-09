#include <iostream>
#include <vector>
using namespace std;

void print_table(vector<int>& table) {
	for(int i=0; i< table.size();++i) {
		cout << "(" << i << ", " << table[i] << ")" << endl;
	}
}


bool is_possible_pos(vector<int>& table, int i, int j) {
	for(int k=0; k<i; ++k) {
		if(table[k]==j) {
			return false;
		}
		if( (k - table[k]) == (i - j) ) {
			return false;
		}
		if( (k + table[k]) == (i + j) ) {
			return false;
		}
	}
	return true;
}

void queens(vector<int>& table, int i) {
	if(i==table.size()) {
		cout << "solution found..." << endl;
		print_table(table);
		return;
	}
	
	for(int j=0; j<table.size(); ++j) {
		if( is_possible_pos(table, i, j) ) {
			table[i] = j;
			queens(table, i+1);
		}
	}
}

class Stack {
	vector<int> data_;
public:
	void push(int val) {
		data_.push_back(val);
	}
	
	int pop() {
		int val = data_.back();
		data_.pop_back();
		return val;
	}

	bool empty() const {
		return data_.empty();
	}
};

void queens_iter(int size) {

	vector<int> table(size);
	Stack where;

	int i = 0;
	int j = 0;
	
	while(i<size && i>=0) {
		// cout << "(" << i << ", " << j << ")" << endl;
		while(!is_possible_pos(table, i, j) && j < size) {
			++ j;
		}
		if(j <  size) {
			table[i] = j;
			where.push(j);
			++ i;
			j = 0;
		} else {
			--i;
			j = where.pop();
			++ j;
		}
	}
	cout << "iter solution..." << endl;
	print_table(table);

}


int main() {
	vector<int> table(4);

	
	queens(table, 0);
	queens_iter(4);
	
	return 0;
}


