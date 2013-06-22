#include "Dictionary.hpp"
#include <fstream>
#include <cstring>
#include <cstdlib>

#include <iostream>
using namespace std;

unsigned 
Dictionary::hash (const char * s) {
  unsigned hashval;
  for (hashval = 0; *s != '\0'; ++s)
    hashval = *s + hashval*31;
  return hashval%HASHSIZE;
}

bool 
Dictionary::loadFile(const char *s) {
  ifstream ifs(s);
  if (!ifs.good())
    return false;
  char word[256];
  char replacer[256];
  while (true) {
    ifs.getline(word, 256, ' ');
    cout << word << endl;
    ifs.getline(replacer, 256);
    cout << replacer << endl;
    add(word, replacer);
    if (ifs.eof())
      break;
  }
  return true;
}

void 
Dictionary::add(const char *word, const char *replacer) {
  element *first = t[hash(word)];
  element *n = new element;
  n->word = new char[strlen(word)+1];
  strcpy(n->word, word);
  n->replacer = new char[strlen(replacer)+1];
  strcpy(n->replacer, replacer);
  n->next = first;
  t[hash(word)] = n;
}
  
char *
Dictionary::lookup (const char * s) {
  for (element *np = t[hash(s)]; np != NULL; np = np->next)
    if (!strcmp(s, np->word))
      return np->replacer;
  return NULL;
}
