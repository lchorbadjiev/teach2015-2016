#include <iostream>
#include <list>
#include <string>
#include <sstream>
using namespace std;

class CalcError{};

class Calc {

	list<double> data_stack_;


	double get_val() {
		if(data_stack_.empty()) {
			cerr << "no data in stack..." << endl;
			throw CalcError();
		}
		double val = data_stack_.back();
		data_stack_.pop_back();
		return val;
	}	
	
	void eval_dup() {
		// eval dup
		double val = get_val();
		cout << "res: " << val << "dup" << endl;
		data_stack_.push_back(val);
		data_stack_.push_back(val);
	}
	
	void eval_neg() {
		// eval neg
		double val = get_val();
				
		cout << "res: " << -val << endl;
		data_stack_.push_back(-val);
	}
	
	void eval_plus() {
		// eval +
		double val1 = get_val();		
		double val2 = get_val();
				
		double res = val1 + val2;
		cout << "res: " << res << endl;
		data_stack_.push_back(res);
	}
	
	void eval_minus() {
		// eval -
		double val1 = get_val();
		double val2 = get_val();
			
		double res = val2 - val1;
		cout << "res: " << res << endl;
		data_stack_.push_back(res);
	}
	
	void eval_mul() {
		// eval *
	}
	
	void eval_div() {
		// eval /
	}
	
	void eval_swap() {
		// eval swap
		
	}
	
	void eval_sqrt() {
		// eval sqrt
		
	}
public:

	void run(istream& in) {
		try {
			while(in) {
				string token;		
				in >> token;
				if(!in) {
					break;
				}
				cout << token << endl;
			
				if(token == "+") {
					eval_plus();				
				} else if(token == "-") {
					eval_minus();
				} else if(token == "neg") {
					eval_neg();
				} else if(token == "dup") {
					eval_dup();
				} else {
					// double??
					istringstream istr(token);
					double val = 0;
					istr >> val;
					if(!istr) {
						cerr << "bad value: " << token 
							<< "!!" << endl;
						break;
					}
					data_stack_.push_back(val);
				}
			}
		}
		catch(CalcError ex) {
			cerr << "calc error catched..." << endl;
		}
	}

};


int main() {

	Calc calc;
	calc.run(cin);
	
	return 0;
}

