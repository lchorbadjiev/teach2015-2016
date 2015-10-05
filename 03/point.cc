#include <cmath>

#include <iostream>
using namespace std;


class Point {
    double x_, y_;
public:
    Point() {
        cout << "Point() called..." << endl;
        x_ = 0.0;
        y_ = 0.0;
    }

    Point(double x, double y) {
        cout << "Point(x,y) called..." << endl;
        x_ = x;
        y_ = y;
    }

    double get_x() {
        return x_;
    }

    double get_y() {
        return y_;
    }
    
    void set_xy(double x, double y) {
        x_ = x;
        y_ = y;
    }
    
    void print() {
        cout << '(' << x_ << ',' << y_ << ')' << endl;
    }
    
    void add(Point other) {
        x_ += other.x_;
        y_ += other.y_;
    }
    
    void sub(Point other) {
        x_ -= other.x_;
        y_ -= other.y_;
    }
    
};

Point add(Point p1, Point p2) {
    Point res(p1.get_x(), p1.get_y());
    res.add(p2);
    return res;
}


Point sub(Point p1, Point p2) {
    Point res(p1.get_x(), p1.get_y());
    res.sub(p2);
    return res;
}

double distance1(Point p1, Point p2) {
    double dx = p1.get_x() - p2.get_x();
    double dy = p1.get_y() - p2.get_y();
    return sqrt(dx*dx + dy*dy);
}

int main() {

    Point p1, p2;
    Point p3(1.0,2.0), p4(3.0,4.0);
    // Point p5 = Point(5.0,6.0);

    p1.print();
    p2.print();
    p3.print();
    p4.print();
    
    p1.add(p3);
    p1.print();
    p3.print();
    
    p1.add(p4);
    p1.print();

    p1.sub(p4);
    p1.print();
    
    p1 = add(p3, p4);
    p1.print();
    
    p1 = sub(p3, p4);
    p1.print();

    cout << "distance(p3, p4)=" << distance1(p3, p4) << endl;
    
	return 0;
}


