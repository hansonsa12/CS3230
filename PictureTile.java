import java.awt.*;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PictureTile extends Tile {
	
	protected String name;
	
	//constructor
	public PictureTile(String name) {
		this.name = name;
		setToolTipText(toString());

    }
	
	public String toString() {
		return name;
	}
	
	//inherits paintComponent from Tile
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	//main to test class
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Picture Tiles");

		frame.add(new Bamboo1Tile());

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}
