#ifndef OPERATION_HH__
#define OPERATION_HH__
#include <string>

class Postfix;
class CalcError {};


class Op {
	Postfix& postfix_;
	std::string token_;
public:
	Op(Postfix& postfix, const std::string& token)
	: postfix_(postfix),
	  token_(token)
	{}

	const std::string& get_token() const {
		return token_;
	}
	
	Postfix& get_postfix() {
		return postfix_;
	}
	
	virtual void calc() = 0;
};

#endif
