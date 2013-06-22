#pragma once
#include "Hash.hpp"

class Restricted {
  
  static int hashFunction (const char * s) {
    int hash = 0;
    while (*s != '\0')
      hash = *s++ + hash*31;
    return hash;
  }

  static int cmpFunction (const char * s, const char * s2) {
    while (s++ == s2++)
      ;
    return s-s2;
  }


private:

  void add (char *s);

public:

  Restricted();
  bool loadFile(const char *fname);
  Hash<char> mHash;
  bool exists (const char * s);

};
