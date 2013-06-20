import java.util.Random;






class Board {
	public final int SIZE_X;
	public final int SIZE_Y;
	public int[][] tMaze;
	public final char poczatek='A';
	public final char koniec='B';
	public final char sciana='#';
	public final char sciezka=' ';
	public final char wolne='!';
	public final int nic= 0;
	public final int minLiczba=255;
	public final int maxLiczba=1000000;
	public final char rozwiazanie='*';
	
	public Board(int x, int y) {
		SIZE_X = 49;
		SIZE_Y = 187;
		
		tMaze = new int[SIZE_X][SIZE_Y];
	}
	
	public String toString() {
		String s = "";
		
	    int i,j;
	    for (i=0; i<SIZE_X; ++i) {
	        for (j=0; j<SIZE_Y; ++j) {
	           	s += tMaze[i][j];
	        }
	        s += '\n';
	    }
        s += '\n';
		
        return s;
	}
	
}




class PermutationGenerator {

	public void genRand(int[] t,int n) {
		Random g = new Random();
		
	    int i;
	    int liczba;
	    boolean[] byla = new boolean[n];

	    for (i=0; i<n; ++i)
	        byla[i]=false;

	    for (i=0; i<n; ++i) {
	        liczba=g.nextInt()%n;
	        if (!byla[liczba]) {
	            t[i]=liczba;
	            byla[liczba]=true;
	        } else --i;
	    }
	}
	
}











public class Maze {
	final int SIZE_X;
	final int SIZE_Y;
	Board mBoard;
	
	public Maze(int x, int y) {
		SIZE_X = 49;
		SIZE_Y = 187;
		mBoard = new Board(SIZE_X,SIZE_Y);
	}
	
	
	public void genMaze() {
		
	}
	


	boolean wGranicach(int x,int y) {
	    if (x>0&&x<SIZE_X&&y>0&&y<SIZE_Y) return true;
	    return false;
	}
	


	boolean graniczyZIO(int x,int y) {
	    if (wGranicach(x,y)) if (mBoard.tMaze[x][y]==mBoard.koniec) return true;
	    if (wGranicach(x-1,y)) if (mBoard.tMaze[x-1][y]==mBoard.koniec) return true;
	    if (wGranicach(x+1,y)) if (mBoard.tMaze[x+1][y]==mBoard.koniec) return true;
	    if (wGranicach(x,y-1)) if (mBoard.tMaze[x][y-1]==mBoard.koniec) return true;
	    if (wGranicach(x,y+1)) if (mBoard.tMaze[x][y+1]==mBoard.koniec) return true;
	    return false;
	}
	
}
