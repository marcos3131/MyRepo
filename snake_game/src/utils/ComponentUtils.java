package utils;

import java.awt.Component;
import java.awt.Dimension;

class ComponentUtils {

	public static void setSize(Component c, Dimension d) {
		c.setPreferredSize(d);
		c.setMinimumSize(d);
		c.setMaximumSize(d);
		c.setSize(d);
	}

}