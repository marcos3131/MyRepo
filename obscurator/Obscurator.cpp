#include "Obscurator.hpp"
#include "LexicalAnalisator.hpp"

void
Obscurator::obscure (char ** files, char * output_file, Restricted r) {
  Dictionary d;
  LexicalAnalisator la(output_file, d, r);  
  for (unsigned i = 0; files[i] != NULL; ++i)
    la.obscureFile(files[i]);
}
