
namespace elsys {

	class Student {
	
	};
	
	class Teacher {
	
	};

};


namespace tues {

	class Student {
	
	};

	class Teacher {
	
	};
};

int foo() {
	using namespace tues;
	
}


int main() {
	elsys::Teacher t1;
	tues::Teacher t2;

	using elsys::Student;
	Student st1;

	// using tues::Student;
	// Teacher t3;

	using namespace std;
	using namespace elsys;
	
	Teacher t3;
	

	return 0;
}

