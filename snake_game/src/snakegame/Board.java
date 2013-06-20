package snakegame;

import java.awt.Point;
import java.awt.Rectangle;


public class Board {
	Point windowOffset;
	Point windowSize;
	Rectangle fieldSize;

	public Board(Point offset, Point size, Rectangle fieldSize) {
		this.windowSize = size;
		this.windowOffset = offset;
		this.fieldSize = fieldSize;
	}

	public Point getWindowLocation(Point location) {
		return new Point((location.x + 1)*fieldSize.x,
				(location.y + 3)*fieldSize.y);
	}
}