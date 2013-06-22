#include "Restricted.hpp"
#include <iostream>
using namespace std;


int main (int argc, char **argv) {
  if (argc < 2) {
    cerr << "Give more arguments" << endl;
    return 1;
  }

  Restricted r;
  cout << r.loadFile((const char *)argv[1]) << endl;
  char buf[256];
  while (1) {
    cin.getline(buf,256);
    cout << r.exists(buf);
  }
  
  return 0;
}
