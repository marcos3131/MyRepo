#include "Restricted.hpp"
#include <fstream>
#include <cstring>
#include <cstdlib>
using namespace std;


Restricted::Restricted() : mHash(hashFunction, cmpFunction) { }

void
Restricted::add(char *s) {
  mHash.add(s);
}

bool
Restricted::loadFile(const char *s) {
  ifstream ifs(s);
  if (!ifs.good())
    return false;
  char buf[256];
  while (true) {
    ifs.getline(buf, 256);
    char *n = new char[strlen(buf)+1];
    strcpy(n, buf);
    add(n);
    if (ifs.eof())
      break;
  }
  return true;
}

bool
Restricted::exists (const char * s) {
  return mHash.exists(s);
}
