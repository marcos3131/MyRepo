//Cóż, nie jest to "Hello world !", ale coś bardzo zbliżonego ;)
#include <GL/glut.h>    // Header File For The GLUT Library
//#include <GL/gl.h>        // Header File For The OpenGL32 Library
//#include <GL/glu.h>        // Header File For The GLu32 Library
/* The number of our GLUT window */
int window;
/* A general OpenGL initialization function.  Sets all of the initial parameters. */
void InitGL(int Width, int Height)                // We call this right after our OpenGL window is created.
{
  glClearColor(0.0f, 0.0f, 0.0f, 0.0f);                // This Will Clear The Background Color To Black
  glClearDepth(1.0);                                // Enables Clearing Of The Depth Buffer
  glDepthFunc(GL_LESS);                                // The Type Of Depth Test To Do
  glEnable(GL_DEPTH_TEST);                        // Enables Depth Testing
  glShadeModel(GL_SMOOTH);                        // Enables Smooth Color Shading
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();                                // Reset The Projection Matrix

  gluPerspective(45.0f,(GLfloat)Width/(GLfloat)Height,0.1f,100.0f);        // Calculate The Aspect Ratio Of The Window
  glMatrixMode(GL_MODELVIEW);
}


/* The function called when our window is resized (which shouldn't happen, because we're fullscreen) */
void ReSizeGLScene(int Width, int Height)
{
  if (Height==0)                                // Prevent A Divide By Zero If The Window Is Too Small
    Height=1;

  glViewport(0, 0, Width, Height);                // Reset The Current Viewport And Perspective Transformation

  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();

  gluPerspective(45.0f,(GLfloat)Width/(GLfloat)Height,0.1f,100.0f);
  glMatrixMode(GL_MODELVIEW);
}

/* The main drawing function. */
void DrawGLScene()
{
glutSetWindow(window);                                        //Set active window

  glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);        // Clear The Screen And The Depth Buffer
  glLoadIdentity();                                // Reset The View
  //OpenGL scene goes here///////////////////////////////////////

  ///////////////////////////////////////////////////////////////
  // swap the buffers to display, since double buffering is used.
  glutSwapBuffers();
}

int main(int argc, char **argv)
{
  /* Initialize GLUT state - glut will take any command line arguments that pertain to it or
     X Windows - look at its documentation at http://reality.sgi.com/mjk/spec3/spec3.html */
  glutInit(&argc, argv);

  /* Select type of Display mode:
     Double buffer
     RGBA color
     Alpha components supported
     Depth buffered for automatic clipping */
  glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_ALPHA | GLUT_DEPTH);
//W przypadku błędów po odpaleniu usunąć  GLUT_ALPHA |

  /* get a 640 x 480 window */
  glutInitWindowSize(640, 480);

  /* the window starts at the upper left corner of the screen */
  glutInitWindowPosition(0, 0);

  /* Open a window */
  window = glutCreateWindow("GLUT TUTORIAL #1");

  /* Register the function to do all our OpenGL drawing. */
  glutDisplayFunc(&DrawGLScene);

  /* Go fullscreen.  This is as soon as possible. */
  //glutFullScreen();

  /* Even if there are no events, redraw our gl scene. */
  glutIdleFunc(&DrawGLScene);

  /* Register the function called when our window is resized. */
  glutReshapeFunc(&ReSizeGLScene);

  /* Initialize our window. */
  InitGL(640, 480);

  /* Start Event Processing Engine */
  glutMainLoop();

  /* shut down our window */
  glutDestroyWindow(window);

  return 1;
}
