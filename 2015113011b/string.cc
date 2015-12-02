#include <iostream>
#include <cstring>
#include <exception>
using namespace std;

#define MAX(a, b) (((a)>(b)?(a):(b)))

class String {
	unsigned size_;
	unsigned capacity_;
	char* buffer_;
	
	friend ostream& operator<<(ostream&, const String&);
	
	void ensure_capacity(unsigned cap) {
		if(size_ + cap < capacity_) {
			return;
		}
		
		unsigned new_capacity = MAX(size_+cap + 1, 2*capacity_);
		char* old_buffer= buffer_;
		buffer_ = new char[new_capacity];
		strcpy(buffer_, old_buffer);
		capacity_ = new_capacity;
		delete [] old_buffer;
		
	}
	
public:

	explicit String(int capacity=0)
	: size_(0),
	  capacity_(capacity),
	  buffer_(new char[capacity_])
	{}
	
	String(const char* str)
	: size_(strlen(str)),
	  capacity_(size_ + 1),
	  buffer_(new char[capacity_])
	{
		strcpy(buffer_, str);
	}
	
	~String() {
		delete [] buffer_;
	}

	String(const String& other) 
	: size_(other.size_),
	  capacity_(other.capacity_),
	  buffer_(new char[capacity_])
	{
		strcpy(buffer_, other.buffer_);
	}

	String& operator=(const String& other) {
		if(this != &other) { 
			delete [] buffer_;
		
			size_ = other.size_;
			capacity_ = other.capacity_;
			buffer_ = new char[capacity_];
			strcpy(buffer_, other.buffer_);
		}
		return *this;
	}

	unsigned size() const {
		return size_;
	}

	void push_back(char ch) {
		ensure_capacity(1);
		buffer_[size_ ++] = ch;
		buffer_[size_] = '\0';
	}

	String& operator+=(const String& other) {
		ensure_capacity(other.size());
		strcpy(buffer_ + size_, other.buffer_);
		size_+=other.size_;
	}
	
	char& operator[](unsigned index) {
		return buffer_[index];
	}
	
	char& at(unsigned index) {
		if(index>=size_) {
			throw exception();
		}
		return buffer_[index];
	}
};

ostream& operator<<(ostream& out, const String& str) {
	if(str.size() > 0) {
		out << str.buffer_;
	}
	return out;
}

String operator+(const String& str1, const String& str2) {
	String res=str1;
	res+=str2;
	return res;
}

int main() {

	String str("Hello world!");
	cout << str << endl;

	String str1;
	cout << str1 << endl;
	
	{	
		String str2 = str;
		cout << str2 << endl;
	}

	cout << "OOPS:" <<  str << endl;

	str1 = str;
	cout << str1 << endl;
	
	
	str1 = str1;
	str1.push_back('!');
	cout << str1 << endl;
	
	String str2("Good bye!!");
	str1 += str2;
	cout << str1 << endl;

	String str3;
	
	str3 = str1 + str2;
	cout << str3 << endl;
	
	str3 = str1 + "Ala Bala!!";
	cout << str3 << endl;
		
	// str3 = str1 + 3;
	//  cout << str3 << endl;
	for(unsigned i=0; i<str3.size(); ++i) {
		str3[i]='A';
	}
	cout << str3 << endl;
	
	
	
	return 0;
}

