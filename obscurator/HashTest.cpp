#include "Hash.hpp"
#include <cstdlib>
#include <cstring>
#include <iostream>
using namespace std;

int hashFunction (const char * s) {
  int hash = 0;
  while (*s != '\0')
    hash = *s++ + hash*31;
  return hash;
}

int cmpFunction (const char * s, const char * s2) {
  while (s++ == s2++)
    ;
  return s-s2;
}

int main() {
  Hash<char> h (hashFunction, cmpFunction);
  char * tmpString = (char*)"I am stupid.";
  char * str1 = new char[strlen(tmpString)+1];
  strcpy(str1, tmpString);
  h.add (str1);
  tmpString = (char *)"I am not stupid.";
  str1 = new char[strlen(tmpString)+1];
  strcpy(str1, tmpString);
  h.add (str1);
  tmpString = (char *)"I don't have a dog.";
  str1 = new char[strlen(tmpString)+1];
  strcpy(str1, tmpString);
  h.add (str1);
  cout << h.exists(tmpString);
  cout << h.exists((char*)"I am not stupid.");
  cout << h.exists((char *)"I don't have a dog.");
  cout << h.exists((char *)"I'm not a dog.");


  return 0;
}
