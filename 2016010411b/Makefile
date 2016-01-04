
all: postfix


postfix: main.o postfix.o
	g++ -o postfix main.o postfix.o


main.o: main.cc operation.hh postfix.hh

postfix.o: postfix.cc operation.hh postfix.hh

clean:
	rm -f *.o
	rm -f *~
	rm -f postfix
	rm -f a.out

