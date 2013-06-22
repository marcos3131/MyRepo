#pragma once
#include "Dictionary.hpp"
#include "Restricted.hpp"
#include <vector>
#include <string>

class LexicalAnalisator {
  char * currentSymbol;
  Dictionary mD;
  Restricted mRestricted;
  char * mOF;
  unsigned int mNameCounter;

public:

  LexicalAnalisator (char * of, Dictionary & d, Restricted & r);
  void obscureFile (char * f);
  std::vector<std::string> tokenize (std::string line, std::string delimiters);
  std::string getNewName ();
};
