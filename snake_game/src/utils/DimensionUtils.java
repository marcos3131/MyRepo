package utils;

import java.awt.Dimension;

class DimensionUtils {
	public static Dimension mult(Dimension d, double i) {
		d.setSize(d.getWidth()*i, d.getHeight()*i);
		return d;
	}
}