#include <iostream>
#include <vector>
using namespace std;

enum Dir {
	LEFT = 1,      // 0001
	RIGHT = 1<<1,  // 0010
	UP = 1 << 2,   // 0100
	DOWN = 1 << 3, // 1000
};


class Cell {
	friend class Board;
	int row_;
	int col_;
	bool visited_;
	unsigned int walls_;
	
	Cell* up_;
	Cell* down_;
	Cell* left_;
	Cell* right_;
	
	Cell& set_up(Cell* up) {
		up_ = up;
		return *this;
	}
	Cell& set_down(Cell* down) {
		down_=down;
		return *this;
	}
	Cell& set_left(Cell* left) {
		left_=left;
		return *this;
	}
	Cell& set_right(Cell* right) {
		right_ = right;
		return *this;
	}
	
public:
	Cell(int row=-1, int col=-1)
	: row_(row), col_(col), visited_(false),
	  walls_(LEFT | RIGHT | UP | DOWN),
	  up_(0), down_(0), left_(0), right_(0)
	{}

	bool visited() const {
		return visited_;
	}

	bool has_wall(Dir dir) const {
		return walls_ & dir;
	}

	void drill(Dir dir) {
		// 0010
		// ~
		// 1101
		// 1010
		// &
		// 1000
		walls_ &= ~dir;
	}

	void draw(int step=20) const {
		cout << col_*step << " " << row_*step << " "
			<< " moveto" << endl;
		cout << step << " " << 0 << " "
			<< (has_wall(DOWN)?"rlineto":"rmoveto") << endl;
		cout << 0 << " " << step << " "
			<< (has_wall(RIGHT)?"rlineto":"rmoveto") << endl;
		cout << -step << " " << 0 << " "
			<< (has_wall(UP)?"rlineto":"rmoveto") << endl;
		cout << 0 << " " << -step << " "
			<< (has_wall(LEFT)?"rlineto":"rmoveto") << endl;
	}
	
	Cell* up() const {
		return up_;
	}
	Cell* down() const {
		return down_;
	}
	Cell* left() const {
		return left_;
	}
	Cell* right() const {
		return right_;
	}
	
	
};

class Board {
	friend class Cell;
	int rows_;
	int cols_;
	vector<Cell> cells_;
	
public:
	Board(int rows, int cols)
	: rows_(rows), cols_(cols)
	{
		for(int i=0; i<rows_; ++i) {
			for(int j=0; j<cols_; ++j) {
				cells_.push_back(Cell(i, j));
			}
		}
		
		for(int i=0; i<rows_; ++i) {
			for(int j=0; j<cols_; ++j) {
				Cell& c=at(i,j);
				if(i < rows_-1) 
					c.set_up(&at(i+1,j));
				if(i > 0) 
					c.set_down(&at(i-1,j));
				if(j > 0) 
					c.set_left(&at(i, j-1));
				if(j < cols_-1)
					c.set_right(&at(i, j+1));
			}
		}
		
	}
	
	Cell& at(int i, int j) {
		int index = i*cols_ + j;
		return cells_[index];
	}
	
	const Cell& at(int i, int j) const {
		int index = i*cols_ + j;
		return cells_[index];		
	}
	
	void draw() const {
		cout << "newpath" << endl;

		for(vector<Cell>::const_iterator it = cells_.begin();
			it!=cells_.end(); ++it) {
		
			(*it).draw();	
		}
		
		cout << "stroke" << endl;
		cout << "showpage" << endl;
		
	}
};



int main() {
	/*
	Cell c1(1,1);
	cout << c1.visited() << endl;
	cout << c1.has_wall(UP) << endl;
	cout << c1.has_wall(LEFT) << endl;
	c1.drill(LEFT);
	cout << c1.has_wall(UP) << endl;
	cout << c1.has_wall(LEFT) << endl;
	*/
	Board b(5,5);
	
	Cell& c=b.at(2,2);
	c.drill(UP);
	Cell* up = c.up();
	up->drill(DOWN);
	
	b.draw();
	
	return 0;
}

