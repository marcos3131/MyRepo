import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.*;
import javax.swing.*;

class Field {
	boolean visited;
	
	public Field() {
		visited = false;
	}
	
	public void markVisited() {
		visited = true;
	}
	
}

class Board {
	Point mSize;
	boolean[][] mVisited;
	java.util.List<Point>[][] mAssotiationList;
	
	public Board(Point size) {
		mSize = size;
		mVisited = new boolean[size.x][size.y];
		
		mAssotiationList = new java.util.List[size.x+1][size.y+1];
		
		for (int i = 0; i < mSize.x+1; ++i)
		{
			for (int j = 0; j < mSize.y+1; ++j)
			{
				mAssotiationList[i][j] = new java.util.ArrayList();

				if (i == 0)
				{
					if (j != 0)
					{
						mAssotiationList[i][j].add(new Point(i,j-1));
					}
					if (j != mSize.y)
					{
						mAssotiationList[i][j].add(new Point(i,j+1));
					}
					mAssotiationList[i][j].add(new Point(i+1,j));
				}
				else if (i == mSize.x)
				{
					if (j != 0)
					{
						mAssotiationList[i][j].add(new Point(i,j-1));
					}
					if (j != mSize.y)
					{
						mAssotiationList[i][j].add(new Point(i,j+1));
					}
					mAssotiationList[i][j].add(new Point(i-1,j));
				}
				else if (j == 0)
				{
					if (i != 0)
					{
						mAssotiationList[i][j].add(new Point(i-1,j));
					}
					if (i != mSize.x)
					{
						mAssotiationList[i][j].add(new Point(i+1,j));
					}
					mAssotiationList[i][j].add(new Point(i,j+1));
				}
				else if (j == mSize.x)
				{
					if (i != 0)
					{
						mAssotiationList[i][j].add(new Point(i-1,j));
					}
					if (i != mSize.x)
					{
						mAssotiationList[i][j].add(new Point(i+1,j));
					}
					mAssotiationList[i][j].add(new Point(i,j-1));
				}
				else 
				{
					for (int k = -1; k < 2; k += 2)
					{
						mAssotiationList[i][j].add(new Point(i+k,j));
					}
					
					for (int k = -1; k < 2; k += 2)
					{
						mAssotiationList[i][j].add(new Point(i,j+k));
					}
				}
			}
		}

		for (int i = 0; i < mSize.x; ++i)
		{
			for (int j = 0; j < mSize.y; ++j)
			{
				mVisited[i][j] = false;
			}
		}
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0,0,17+mSize.x*10,37+mSize.y*10);
		g.setColor(Color.green);

		for (int i = 0; i < mSize.x-1; ++i)
		{
			for (int j = 0; j < mSize.y-1; ++j)
			{
				for (int k = 0; k < mAssotiationList[i][j].size(); ++k)
				{
					Point end = mAssotiationList[i][j].get(k);
					
					g.drawLine(13+(i)*10,31+(j)*10, 13+end.x*10, 31+end.y*10);
				}
			}
		}
	}
	
	// Destroys only one point or something...
	public void destroyWallBetweenPoints(Point p1, Point p2) {
		
		if (p1.x < p2.x)
		{
			destroyWall(p2, new Point(p2.x, p2.y+1));
		}
		else if (p1.x > p1.x)
		{
			destroyWall(p1, new Point(p1.x, p1.y+1));
		}
		else if (p1.y < p2.y)
		{
			destroyWall(p2, new Point(p2.x+1, p2.y));
		}
		else if (p1.y > p2.y)
		{
			destroyWall(p1, new Point(p1.x+1, p1.y));
		}
	}
	
	void destroyWall(Point p1, Point p2) {
		java.util.List<Point> lp = mAssotiationList[p1.x][p1.y];

		for (int i = 0; i < lp.size(); ++i)
		{
			if (lp.get(i) == p2)
			{
				lp.remove(i);
			}
		}
		
		lp = mAssotiationList[p2.x][p2.y];
		
		for (int i = 0; i < lp.size(); ++i)
		{
			if (lp.get(i) == p1)
			{
				lp.remove(i);
			}
		}
	}
	
}


public class Maze {
	Board mBoard;
	Point mStart;
	Point mEnd;
	
	public Maze(int x, int y) {
		// init board
		mBoard = new Board(new Point(x,y));
		
	}
	
	public void genMaze() {
		// init start and end
		Random g = new Random();
		
		mStart = new Point(g.nextInt()%(int)mBoard.mSize.x,
				g.nextInt()%(int)mBoard.mSize.y);
		
		mEnd = new Point(g.nextInt()%(int)mBoard.mSize.x,
				g.nextInt()%(int)mBoard.mSize.y);
		
		//
		
		
	}
	
	public void paint(Graphics g) {
		mBoard.paint(g);
	}
	
	public void showInWindow() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(17+mBoard.mSize.x*10,35+mBoard.mSize.y*10);
		// f.setResizable(false);
		f.setLocation(100, 100);
		f.setVisible(true);

		f.createBufferStrategy(2);
		
		while (true) {
			Graphics g = null;
			
			try {
				BufferStrategy fbs = f.getBufferStrategy();

				g = fbs.getDrawGraphics();
				paint(g);

				fbs.show();
			} finally {
				// dispose graphic if done
				g.dispose();
			}
			

			Toolkit.getDefaultToolkit().sync();
		}
	}
	
	public static void main(String[] args) {
		Maze m = new Maze(30, 30);
		
		m.showInWindow();
	}

}
