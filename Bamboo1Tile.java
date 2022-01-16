import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bamboo1Tile extends PictureTile
{
	//grabs an image from the source file
	private Image Bamboo1 = 
			new ImageIcon(this.getClass().getResource("/images/Sparrow.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);;
	
	//constructor
	public Bamboo1Tile()
	{
		super("Sparrow");
		setToolTipText(toString());

	}

	public String toString()
	{
		return "Bamboo 1";
	}
	
	//inherits paintComponent and draws the image onto the tile
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Bamboo1, 30, 10, this);
	}
}