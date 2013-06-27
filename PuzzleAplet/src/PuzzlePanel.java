import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PuzzlePanel extends JPanel implements MouseListener {
	Image o1, o2, o3, o4, o5, o6, o7, o8, o9;
	Image tabImage[] = new Image[9];
	boolean ulozone = false;
	int xCz = 0, yCz = 0, nowy = 0, stary = 0;

	public PuzzlePanel() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(600, 450));
		try {
			o1 = new ImageIcon(this.getClass().getResource("1.jpg")).getImage();
			o2 = new ImageIcon(this.getClass().getResource("2.jpg")).getImage();
			o3 = new ImageIcon(this.getClass().getResource("3.jpg")).getImage();
			o4 = new ImageIcon(this.getClass().getResource("4.jpg")).getImage();
			o5 = new ImageIcon(this.getClass().getResource("5.jpg")).getImage();
			o6 = new ImageIcon(this.getClass().getResource("6.jpg")).getImage();
			o7 = new ImageIcon(this.getClass().getResource("7.jpg")).getImage();
			o8 = new ImageIcon(this.getClass().getResource("8.jpg")).getImage();
			o9 = new ImageIcon(this.getClass().getResource("9.jpg")).getImage();
		} catch (Exception e) {
		}

		tabImage[0] = o7;
		tabImage[1] = o4;
		tabImage[2] = o6;
		tabImage[3] = o3;
		tabImage[4] = o2;
		tabImage[5] = o5;
		tabImage[6] = o8;
		tabImage[7] = o1;
		tabImage[8] = o9;
		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int x = 0, y = 0;
		for (int i = 0; i < 9; i++) {
			if (i == 0 || i == 3 || i == 6) {
				x = 0;
			} else if (i == 1 || i == 4 || i == 7) {
				x = 200;
			} else
				x = 400;

			if (i == 0 || i == 1 || i == 2) {
				y = 0;
			} else if (i == 3 || i == 4 || i == 5) {
				y = 150;
			} else
				y = 300;

			g2.drawImage(tabImage[i], x, y, null);

		}

		if (ulozone == false) {
			g2.setColor(new Color(204, 204, 204));
			g2.drawLine(0, 150, 600, 150);
			g2.drawLine(0, 300, 600, 300);
			g2.drawLine(200, 0, 200, 450);
			g2.drawLine(400, 0, 400, 450);
			g2.setColor(new Color(255, 0, 0));
			g2.drawRect(xCz, yCz, 200, 150);
		}

	}

	// metody do obs�ugi zdarze� myszy:
	public void mouseClicked(MouseEvent me) {
		int xme = me.getX();
		int yme = me.getY();
		int przycisk = me.getButton();
		// lewy to 1, prawy to 3
		if (xme < 200 && xme >= 0 && yme >= 0 && yme < 150 && ulozone == false) {
			xCz = 0;
			yCz = 0;
			if (przycisk == 1) {
				stary = 0;
			} else if (przycisk == 3) {
				nowy = 0;
				zamiana();
			}
		} else if (xme < 400 && xme >= 200 && yme >= 0 && yme < 150
				&& ulozone == false) {
			xCz = 200;
			yCz = 0;
			if (przycisk == 1) {
				stary = 1;
			} else if (przycisk == 3) {
				nowy = 1;
				zamiana();
			}
		} else if (xme < 600 && xme >= 400 && yme >= 0 && yme < 150
				&& ulozone == false) {
			xCz = 400;
			yCz = 0;
			if (przycisk == 1) {
				stary = 2;
			} else if (przycisk == 3) {
				nowy = 2;
				zamiana();
			}
		} else if (xme < 200 && xme >= 0 && yme >= 150 && yme < 300
				&& ulozone == false) {
			xCz = 0;
			yCz = 150;
			if (przycisk == 1) {
				stary = 3;
			} else if (przycisk == 3) {
				nowy = 3;
				zamiana();
			}
		} else if (xme < 400 && xme >= 200 && yme >= 150 && yme < 300
				&& ulozone == false) {
			xCz = 200;
			yCz = 150;
			if (przycisk == 1) {
				stary = 4;
			} else if (przycisk == 3) {
				nowy = 4;
				zamiana();
			}
		} else if (xme < 600 && xme >= 400 && yme >= 150 && yme < 300
				&& ulozone == false) {
			xCz = 400;
			yCz = 150;
			if (przycisk == 1) {
				stary = 5;
			} else if (przycisk == 3) {
				nowy = 5;
				zamiana();
			}
		} else if (xme < 200 && xme >= 0 && yme >= 300 && yme < 450
				&& ulozone == false) {
			xCz = 0;
			yCz = 300;
			if (przycisk == 1) {
				stary = 6;
			} else if (przycisk == 3) {
				nowy = 6;
				zamiana();
			}
		} else if (xme < 400 && xme >= 200 && yme >= 300 && yme < 450
				&& ulozone == false) {
			xCz = 200;
			yCz = 300;
			if (przycisk == 1) {
				stary = 7;
			} else if (przycisk == 3) {
				nowy = 7;
				zamiana();
			}
		} else if (xme < 600 && xme >= 400 && yme >= 300 && yme < 450
				&& ulozone == false) {
			xCz = 400;
			yCz = 300;
			if (przycisk == 1) {
				stary = 8;
			} else if (przycisk == 3) {
				nowy = 8;
				zamiana();
			}
		}
		if (tabImage[0] == o1 && tabImage[1] == o2 && tabImage[2] == o3
				&& tabImage[3] == o4 && tabImage[4] == o5 && tabImage[5] == o6
				&& tabImage[6] == o7 && tabImage[7] == o8 && tabImage[8] == o9) {
			ulozone = true;
		}
		repaint();
	}

	public void mouseEntered(MouseEvent me) {
	}

	public void mouseExited(MouseEvent me) {
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void zamiana() {
		Image tymczasowy = tabImage[stary];
		tabImage[stary] = tabImage[nowy];
		tabImage[nowy] = tymczasowy;
	}
}// koniec klasy