#include "Dictionary.hpp"
#include "Restricted.hpp"
#include "Obscurator.hpp"

#include <stdio.h>
#include <stdlib.h>
#include <getopt.h>
#include <cstring>
#include <iostream>	// debug
using namespace std;	// debug

/* Flag set by ‘--verbose’. */
static int verbose_flag;
static int deobscure_flag = false;
     
int
main (int argc, char **argv)
{
  int c;
  char * restricted_files = NULL;
  char * output_file = NULL;
  char * dictionary_files = NULL;
     
  while (1)
    {
      static struct option long_options[] =
	{
	  /* These options set a flag. */
	  {"verbose", no_argument,       &verbose_flag, 1},
	  {"brief",   no_argument,       &verbose_flag, 0},
	  {"deobscure",   no_argument,       &deobscure_flag, 1},
	  /* These options don't set a flag.
	     We distinguish them by their indices. */
	  {"dictionary",    required_argument, 0, 'd'},
	  {"restricted",  required_argument, 0, 'e'},
	  {"output",    required_argument, 0, 'o'},
	  {0, 0, 0, 0}
	};
      /* getopt_long stores the option index here. */
      int option_index = 0;
     
      c = getopt_long (argc, argv, "d:e:o:",
		       long_options, &option_index);
     
      /* Detect the end of the options. */
      if (c == -1)
	break;
     
      switch (c)
	{
	case 0:
	  /* If this option set a flag, do nothing else now. */
	  if (long_options[option_index].flag != 0)
	    break;
	  printf ("option %s", long_options[option_index].name);
	  if (optarg)
	    printf (" with arg %s", optarg);
	  printf ("\n");
	  break;

     	case 'd':
	  dictionary_files = optarg;
	  printf ("option -d with value `%s'\n", optarg);
	  break;
     
     	case 'e':
	  restricted_files = optarg;
	  printf ("option -e with value `%s'\n", optarg);
	  break;
     
	case 'o':
	  output_file = optarg;
	  printf ("option -o with value `%s'\n", optarg);
	  break;
     
	case '?':
	  /* getopt_long already printed an error message. */
	  break;
     
	default:
	  abort ();
	}
    }
     
  /* Instead of reporting ‘--verbose’
     and ‘--brief’ as they are encountered,
     we report the final status resulting from them. */
  if (verbose_flag)
    puts ("verbose flag is set");
     
  char * files[1000];
  unsigned fileindex = 0;
  files[0] = NULL;
  /* Print any remaining command line arguments (not options). */
  if (optind < argc) {
      printf ("non-option ARGV-elements: ");
		while (optind < argc) {
			files[fileindex++] = argv[optind];
			printf ("%s ", argv[optind++]);
		}
		cout << fileindex << endl;
      files[fileindex] = NULL;
		cout << fileindex << endl;
    }

  char * ptr = NULL;
  if (deobscure_flag) {
    Dictionary d;
    d.loadFile(strtok(dictionary_files, ","));
    while ((ptr = strtok(NULL, ",")))
      d.loadFile(ptr);
  } else {
    Restricted r;
    r.loadFile(strtok(restricted_files, ","));
    while ((ptr = strtok(NULL, ",")))
      r.loadFile(ptr);
    Obscurator o;
		cout << fileindex << endl;
    o.obscure(files, output_file, r);
  }
  exit (0);
}
