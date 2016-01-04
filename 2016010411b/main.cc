#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <cmath>
using namespace std;

#include "operation.hh"
#include "postfix.hh"


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

