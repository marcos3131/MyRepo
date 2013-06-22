#include "LexicalAnalisator.hpp"
#include <iostream>
#include <fstream>
#include <vector>
#include <cstring>
#include <string>

using namespace std;

LexicalAnalisator::LexicalAnalisator (char * of, Dictionary & d, Restricted & r) :
  mD(d),
  mRestricted(r),
  mOF(of),
  mNameCounter(0) {
}

void LexicalAnalisator::obscureFile(char * f) {
  ifstream ifs(f);
  if (!ifs.good())
    cerr << "Error while opening the file" << f << endl;
  ofstream ofs;
  ofs.open(mOF, fstream::app);
  if (!ofs.good())
    cerr << "Error while opening the file" << mOF << endl;
  while (1) {
    string line;
    while (getline(ifs, line)) {
    vector<string> tokens = tokenize (line, string(" \n\t{}();:#"));
    for (unsigned i = 0; i < tokens.size(); ++i)
        if (!strcmp(tokens[i].c_str(), "{")
            || !strcmp(tokens[i].c_str(), "}")
            || !strcmp(tokens[i].c_str(), "(")
            || !strcmp(tokens[i].c_str(), ")")
            || !strcmp(tokens[i].c_str(), ";")
            || !strcmp(tokens[i].c_str(), ":")
            || !strcmp(tokens[i].c_str(), "#")
            || mRestricted.exists(tokens[i].c_str()))
          ofs << tokens[i];
        else if (!strcmp(tokens[i].c_str(), "\n"))
          ofs << " ";
        else {
          char * lu = mD.lookup(tokens[i].c_str());
          if (lu)
            ofs << lu;
          else {
            string name = getNewName();
            mD.add (tokens[i].c_str(), name.c_str());
            ofs << name;
          }
        }
    }
  }
}

vector<string> 
LexicalAnalisator::tokenize (string line, string delimiters) {
  unsigned word_beginning = 0;
  vector<string> tokens;
  for (unsigned i = 0; i < line.size(); ++i) {
    for (unsigned j = 0; j < delimiters.size(); ++j) {
      if (line[i] == delimiters[j]) {
        tokens.push_back(line.substr(word_beginning, i-1));
        tokens.push_back(line.substr(i, i));
        word_beginning = i+1;
        i = i+1;
      }
    }
  } 
  return tokens;
}

string LexicalAnalisator::getNewName () {
  string name("name");
  char buffer[256];
  sprintf(buffer, "%d", ++mNameCounter);
  name += string(buffer);
  return name;
}
