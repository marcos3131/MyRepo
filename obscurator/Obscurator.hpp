#pragma once
#include "Restricted.hpp"

class Obscurator {
public:
  Obscurator () { }
  void obscure (char ** files, char * outputFile, Restricted r);
};
