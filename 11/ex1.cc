#include <iostream>
#include <string>
#include <cstdio>

using namespace std;



int main() {
	string str1;
	cout << "(" << str1 << ")" << endl;
	
	str1 = "Hello";
	cout << "(" << str1 << ")" << endl;

	str1 += " ";
	str1 += "world";
	str1 += "!";
	cout << "(" << str1 << ")" << endl;

	cout << "str1.size()=" << str1.size() << endl;		
	cout << "str1.length()=" << str1.length() << endl;
	for(int i = 0; i<str1.length(); ++i) {
		cout << str1[i] << endl;
	}
	
	for(string::iterator it=str1.begin(); it!=str1.end(); ++it) {
		cout << *it << endl;
	}

	printf("c str: %s\n", str1.c_str());

	string str2 = str1.substr(0,4);
	cout << "substr: " << str2 << endl;

	int pos = str1.find("wor", 0);
	cout << "wor pos: " << pos << endl;
	cout << str1.substr(pos, 3) << endl;
	
	pos = str1.find("wor");
	
	pos = str1.find("alabala");
	if(pos == string::npos) {
		cout << "sub string not found..." << endl;
	}
	
	pos = str1.find("o");
	while(pos!=string::npos) {
		cout << "'o' found at pos: " << pos << endl;
		pos = str1.find("o", pos + 1);
	}
	return 0;
}

