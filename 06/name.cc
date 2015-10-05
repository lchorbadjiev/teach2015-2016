
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


namespace elsys {
	class Cabinet {
	
	};

};


int main() {
	elsys::Teacher t1;
	tues::Teacher t2;
	
	using elsys::Student;
	Student st1;

	tues::Student st2;
	
	// using tues::Student;
	
	using namespace std;
	using namespace elsys;

	Teacher t3;
	
	return 0;
}


