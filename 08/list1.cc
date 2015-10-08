#include <iostream>
#include <list>

using namespace std;

void print(list<int>& l) {
	for(list<int>::iterator it=l.begin(); it!=l.end(); ++it) {
		cout << *it << ' ';
	}
	cout << endl;
}


int main() {
	int a[] = {0,1,2,3,4,5,6,7,8,9};
	list<int> l1(a, a+10);
	
	for(list<int>::iterator it=l1.begin(); it!=l1.end(); ++it) {
		cout << *it << ' ';
	}
	cout << endl;
	print(l1);
	
	cout << "l1.size(): " << l1.size() << endl;
	
	l1.push_back(1000);
	l1.push_back(1001);
	print(l1);
	
	l1.push_front(-1);
	l1.push_front(-2);
	print(l1);
	
	list<int>::iterator it = l1.begin();
	l1.insert(it, -1000);
	it = l1.end();
	l1.insert(it, 33000);
	print(l1);

	it = l1.begin();
	++it; ++it; ++it; ++it;
	l1.insert(it, 44444);
	print(l1);

	it = l1.begin();
	++it; ++it; ++it; ++it;
	l1.erase(it);
	print(l1);

	l1.erase(l1.begin(), l1.end());
	print(l1);
	
	return 0;
}

