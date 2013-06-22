#pragma once

#include <iostream>

template <typename A>
class Hash {

  const unsigned int HASHSIZE;

  typedef int (*hc_t)(const A *);
  typedef int (*eq_t)(const A *, const A *);

  int size;
  A ** tab;
  int nele;
  hc_t hc;
  eq_t eq;

public:

  Hash (hc_t _hc, eq_t _eq): HASHSIZE(1000) {
    tab = new A * [HASHSIZE];
    for (unsigned i = 0; i < HASHSIZE; ++i)
      tab[i] = NULL;
    hc = _hc;
    eq = _eq;
    size = HASHSIZE;
    nele = 0;
  }

  void 
  add (A * n) {
    if (nele >= size) {
      throw new std::exception;
    }
    if (exists(n))
      return;
    int _hc = 0;
    do {

      _hc = _hc + hc(n)*31;
      if (!tab[_hc%HASHSIZE]) {
	tab[_hc%HASHSIZE] = n;
	return;
      }
    } while (true);
  }

  bool
  exists(const A * o) {
    int _hc = 0;
    do {
      _hc = _hc + hc(o)*31;
      if (tab[_hc%HASHSIZE] == NULL)
	return false;
      else if (eq(tab[_hc%HASHSIZE], o))
	return true;
    } while (true);
    return false;
  }

};
