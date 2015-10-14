#include <string>
#include <iostream>
#include <cstdio>
using namespace std;


int main() {
	string str1;
	cout << '|' << str1 << '|' << endl;
	
	str1 = "Hello";
	cout << '|' << str1 << '|' << endl;

	str1 += " ";
	str1 += "world";
	str1 += "!";
	cout << '|' << str1 << '|' << endl;

	string str2 = str1;
	str2 += str1;
	cout << '|' << str2 << '|' << endl;
	
	string str3 = str2 + str1;
	cout << '|' << str3 << '|' << endl;
	
	cout << "str1.size()=" << str1.size() << endl;
	cout << "str1.length()=" << str1.length() << endl;
	
	for(int i = 0; i<str1.length(); ++i) {
		cout << str1[i] << endl;
	}
	
	for(string::iterator it=str1.begin(); it!=str1.end(); ++it) {
		cout << *it << endl;
	}
	
	printf("c_str: %s\n",str1.c_str());

	string sstr = str1.substr(0,4);
	cout << "sstr: " << sstr << endl;
	
	cout << "str3: " << str3 << endl;
	int pos = str3.find("world");
	cout << "pos=" << pos << endl;
	
	pos = str3.find("world", pos + 1);
	cout << "pos=" << pos << endl;
	
	
	pos = str3.find("ala-bala", 0);
	if(pos == string::npos) {
		cout << "ala-bala not found..." << endl;
	}
	
	pos = str3.find("world");
	while(pos!=string::npos) {
		cout << "pos=" << pos << endl;
		pos = str3.find("world", pos+1);
	}
	
	
	return 0;
}

