#include <iostream>
#include <sstream>
using namespace std;


int main() {
	string istr = "42 3.14 ala-bala";
	istringstream in(istr);
	
	int a;
	float pi;
	string s;
	
	in >> a;
	in >> pi;
	in >> s;
	
	cout << "a=" << a << endl;
	cout << "pi=" << pi << endl;
	cout << "s=" << s << endl;
	
	return 0;
}
