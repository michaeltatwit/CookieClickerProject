package Application;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public  class ImagePanel extends JPanel {
	Image image;

	public ImagePanel(String filename) {
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource(filename));
		image = img.getImage();
	}
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,0,0,null);
	}
}
	