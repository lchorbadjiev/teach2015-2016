#include <iostream>
using namespace std;

class Foo {
	const int bar_;
public:
	Foo(int bar)
	: bar_(bar)
	{
		// bar_ = bar;
	}
	
	int get_bar() const {
		return bar_;
	}

};

int main() {
	Foo f1(42);
	cout << f1.get_bar() << endl;

	return 0;
}

