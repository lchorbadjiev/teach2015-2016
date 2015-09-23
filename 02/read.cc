#include <iostream>
using namespace std;


int main() {
	cout << "input int val: ";
	int val=3;
	cin >> val;
	if(!cin) {
		cout << "wrong input..." << endl;
		return 1;
	}
	cout << "val=" << val << endl;
	
	return 0;
}

