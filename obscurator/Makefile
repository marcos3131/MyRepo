CPP=g++
PNAME=obscurator
CPPFLAGS=-Wall -g

OBJECTS= Dictionary.o\
	Restricted.o\
	LexicalAnalisator.o\
	Obscurator.o\
	main.o

all: $(PNAME)

gdb: all
	gdb -x gdbfile


HashTest.o: HashTest.cpp Hash.hpp
Restricted.o: Restricted.cpp Restricted.hpp
Dictionary.o: Dictionary.cpp Dictionary.hpp
RestrictedTest.o: RestrictedTest.cpp
DictionaryTest.o: DictionaryTest.cpp
LexicalAnalisator.o: LexicalAnalisator.cpp LexicalAnalisator.hpp
main.o: main.cpp
Obscuraotor: Obscurator.cpp Obscurator.hpp

%.o: %.cpp
	$(CPP) -c $(CPPFLAGS) -o $@ $<

$(PNAME): $(OBJECTS)
	$(CPP) $(OBJECTS) -o $@ $(CPPFLAGS)

.PHONY:
clean:
	rm -rf *.o
