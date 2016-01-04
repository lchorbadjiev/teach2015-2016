#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <cmath>
using namespace std;

class Postfix;
class CalcError {};


class Op {
	Postfix& postfix_;
	string token_;
public:
	Op(Postfix& postfix, const string& token)
	: postfix_(postfix),
	  token_(token)
	{}

	const string& get_token() const {
		return token_;
	}
	
	Postfix& get_postfix() {
		return postfix_;
	}
	
	virtual void calc() = 0;
};

class Postfix {
	vector<Op*> context_;
	vector<double> stack_;
	
public:

	double get_val() {
		if(stack_.empty()) {
			throw CalcError();
		}
		double val = stack_.back();
		stack_.pop_back();
		return val;
	}
	
	void put_val(double val) {
		stack_.push_back(val);
	}
	
	void add_op(Op* op) {
		context_.push_back(op);
	}

	Op* get_op(const string& token) {
		for(vector<Op*>::iterator it=context_.begin();
			it!=context_.end(); ++it) {
			
			if( (*it) -> get_token() == token ) {
				return *it;
			}	
		}
		return 0;	
	}
	
	void run(istream& in) {
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
};

class Swap: public Op {
public:
	Swap(Postfix& postfix)
	: Op(postfix, "swap")
	{}

	void calc() {
		double val1 = get_postfix().get_val();
		double val2 = get_postfix().get_val();

		get_postfix().put_val(val1);
		get_postfix().put_val(val2);
	}
};

class BinOp: public Op {
public:
	BinOp(Postfix& postfix, const string& token)
	: Op(postfix, token)
	{}
	
	virtual double eval(double val1, double val2) const =0;
	
	void calc() {
		double val1 = get_postfix().get_val();
		double val2 = get_postfix().get_val();
		
		double res = eval(val1, val2);
		
		get_postfix().put_val(res);
	}
};


class Plus: public BinOp {
public:
	Plus(Postfix& postfix)
	: BinOp(postfix, "+")
	{}
	
	double eval(double val1, double val2) const {
		return val1 + val2;
	}
};

class Minus: public BinOp {
public:
	Minus(Postfix& postfix)
	: BinOp(postfix, "-")
	{}

	double eval(double val1, double val2) const {
		return val2 - val1;
	}
};

class Mult: public BinOp {
public:
	Mult(Postfix& postfix)
	: BinOp(postfix, "*")
	{}

	double eval(double val1, double val2) const {
		return val2 * val1;
	}
};

class Div: public BinOp {
public:
	Div(Postfix& postfix)
	: BinOp(postfix, "/")
	{}

	double eval(double val1, double val2) const {
		return val2 / val1;
	}
};

class UnaryOp: public Op {
public:
	UnaryOp(Postfix& postfix, const string& token)
	: Op(postfix, token)
	{}
	
	virtual double eval(double val) const =0;
	
	void calc() {
		double val = get_postfix().get_val();
		double res = eval(val);
		get_postfix().put_val(res);
	}
};

class Dup: public Op {
public:
	Dup(Postfix& postfix)
	: Op(postfix, "dup")
	{}
	
	void calc() {
		double val = get_postfix().get_val();
		get_postfix().put_val(val);
		get_postfix().put_val(val);		
	}
};


// Neg
// Sqrt
class Neg: public UnaryOp {
public:
	Neg(Postfix& postfix)
	: UnaryOp(postfix, "neg")
	{}
	
	double eval(double val) const {
		return - val;
	}
};

class Sqrt: public UnaryOp {
public:
	Sqrt(Postfix& postfix)
	: UnaryOp(postfix, "sqrt")
	{}
	
	double eval(double val) const {
		return sqrt(val);
	}
};


class CompositeOp: public Op {
	vector<Op*> ops_;
public:
	CompositeOp(Postfix& postfix, string token)
	: Op(postfix, token)
	{}

	void calc() {
		for(vector<Op*>::iterator it = ops_.begin();
			it!=ops_.end(); ++it) {
		
			(*it)->calc();
		}
	}	

	void add_op(string token) {
		Op* op = get_postfix().get_op(token);
		if(op==0) {
			cerr << "Unknown operation: " << token << endl;
			throw CalcError();
		}
		ops_.push_back(op);
	}

};


int main() {
	Postfix postfix;
	postfix.add_op(new Plus(postfix));
	postfix.add_op(new Minus(postfix));
	postfix.add_op(new Mult(postfix));
	postfix.add_op(new Div(postfix));
	
	postfix.add_op(new Neg(postfix));
	postfix.add_op(new Dup(postfix));
	postfix.add_op(new Sqrt(postfix));
	
	postfix.add_op(new Swap(postfix));
	
	
	CompositeOp* hyp = new CompositeOp(postfix, "hyp");
	hyp->add_op("dup");
	hyp->add_op("*");
	hyp->add_op("swap");
	hyp->add_op("dup");
	hyp->add_op("*");
	hyp->add_op("+");
	hyp->add_op("sqrt");
	postfix.add_op(hyp);
	
	postfix.run(cin);	

	return 0;
}

