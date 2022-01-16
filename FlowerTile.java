import java.awt.*;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FlowerTile extends PictureTile{
	
	
	//grabs an image from the source file
	private Image Chrysanthemum = 
			new ImageIcon(this.getClass().getResource("/images/Chrysanthemum.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);;
	private Image Orchid = 
			new ImageIcon(this.getClass().getResource("/images/Orchid.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);;
	private Image Plum = 
			new ImageIcon(this.getClass().getResource("/images/Plum.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);;
	private Image Bamboo = 
			new ImageIcon(this.getClass().getResource("/images/Bamboo.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);;
	
	public FlowerTile(String name) {
		super(name);
		setToolTipText(toString());

	}
	
	//inherits paintComponent and draws the image onto the tile
	//switches image based on input
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch(name){
		case "Chrysanthemum":
			g.drawImage(Chrysanthemum, 30, 10, this);
			break;
		case "Orchid":
			g.drawImage(Orchid, 30, 10, this);
			break;
		case "Plum":
			g.drawImage(Plum, 30, 10, this);
			break;
		case "Bamboo":
			g.drawImage(Bamboo, 30, 10, this);
			break;
	}

}
	
	//main to test class
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Flower Tiles");

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.pack();
		frame.setVisible(true);
	}
}
