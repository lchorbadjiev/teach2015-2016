#include <iostream>
#include <string>
using namespace std;


class Employee {
	long id_;
protected:
	string name_;
public:
	Employee(long id, const string& name)
	: id_(id),
	  name_(name)
	{}
	
	long get_id() const {
		return id_;
	}
	
	string get_name() const {
		return name_;
	}

	virtual void print() const {
		cout << "id: " << id_ << "; name: " << name_ << endl;
	}

};

class Manager: public Employee {
	long level_;
public:
	Manager(long id, const string& name, long level)
	: Employee(id, name),
	  level_(level)
	{}
	

	long get_level() const {
		return level_;
	}
	
	void print() const {
		cout << "M:" << level_ << "; ";
		Employee::print();
		// cout << name_ << endl;
	}
};

int main() {
	Employee e1(1, "Peter");
	Employee e2(2, "Gosho");
	e1.print();
	e2.print();

	// e2.name_; error!!
	
	Manager m1(3, "Ivancho", 2);
	m1.print();
	
	Employee* pe;
	
	pe = &e1;
	pe->print();
	
	pe = &m1;
	pe->print();
	
	
	
	return 0;
}
