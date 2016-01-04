#include <sstream>

#include "postfix.hh"
#include "operation.hh"


using namespace std;

double Postfix::get_val() {
	if(stack_.empty()) {
		throw CalcError();
	}
	double val = stack_.back();
	stack_.pop_back();
	return val;
}

void Postfix::put_val(double val) {
	stack_.push_back(val);
}

void Postfix::add_op(Op* op) {
	context_.push_back(op);
}

Op* Postfix::get_op(const string& token) {
	for(vector<Op*>::iterator it=context_.begin();
		it!=context_.end(); ++it) {
		
		if( (*it) -> get_token() == token ) {
			return *it;
		}	
	}
	return 0;	
}

void Postfix::run(istream& in) {
	string token;
	while(true) {
	
		in >> token;
		if(!in) {
			break;
		}
		Op* op = get_op(token);
		if(op) {
			op->calc();
			cerr << "op(" << token << "): res=" 
				<< stack_.back() << endl;
		} else {
			istringstream istr(token);
			double val = 0;
			istr >> val;
			if(!istr) {
				cerr << "bad value: " << token << endl;
				throw CalcError();
			}
			stack_.push_back(val);
			cerr << "data: " << val << endl;
		}
	}
}

