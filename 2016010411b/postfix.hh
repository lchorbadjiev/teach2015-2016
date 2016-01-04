#ifndef POSTFIX_HH__
#define POSTFIX_HH__

#include <vector>
#include <iostream>
#include <string>
// using namespace std;

class Op;

class Postfix {
	std::vector<Op*> context_;
	std::vector<double> stack_;
	
public:

	double get_val();
	void put_val(double val);
	void add_op(Op* op);
	Op* get_op(const std::string& token);
	void run(std::istream& in);
};

#endif
