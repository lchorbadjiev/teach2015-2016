#include <iostream>
#include <vector>

using namespace std;


int main() {
	vector<int> v1;
	
	cout << "v1.size() = " << v1.size() << endl;
	cout << "v1.capacity() = " << v1.capacity() << endl;	

	v1.push_back(1);
	v1.push_back(2);
	v1.push_back(3);

	cout << "v1.size() = " << v1.size() << endl;
	cout << "v1.capacity() = " << v1.capacity() << endl;	

	v1.push_back(4);

	cout << "v1.size() = " << v1.size() << endl;
	cout << "v1.capacity() = " << v1.capacity() << endl;	

	v1.push_back(5);

	cout << "v1.size() = " << v1.size() << endl;
	cout << "v1.capacity() = " << v1.capacity() << endl;	


	for(int i=0; i<v1.size(); ++i) {
		cout << "v1[" << i << "]=" << v1[i] << endl;
	}

	vector<int>::iterator it;
	it = v1.begin();
	cout << "*it=" << *it << endl;
	it++;
	cout << "*it=" << *it << endl;
	for(it=v1.begin(); it!=v1.end(); ++it) {
	
		cout << "*it=" << *it << endl;
	}
	


	return 0;
}

