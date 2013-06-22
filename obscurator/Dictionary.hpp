#pragma once

class Dictionary {

  struct element {
    element * next;
    char * word;
    char * replacer;
  };

  static const unsigned HASHSIZE = 10000;
  element * t[HASHSIZE];

private:

public:

  void add(const char *, const char *);
  bool loadFile(const char *);
  unsigned hash (const char * s);  
  char * lookup (const char * s);

};
