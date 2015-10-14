#include <sstream>
#include <iostream>

using namespace std;


int main() {
	ostringstream out;
	
	out << "Hello" << ' ' << 42 << ' ' << "world!" << ' ' << 3.14;

	cout << "out.str(): " << out.str() << endl;
	return 0;
}

