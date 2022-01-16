import java.awt.*;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SeasonTile extends PictureTile {
	
	//grabs an image from the source file
	private Image Spring = 
			new ImageIcon(this.getClass().getResource("/images/Spring.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	private Image Summer = 
			new ImageIcon(this.getClass().getResource("/images/Summer.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);;
	private Image Fall = 
			new ImageIcon(this.getClass().getResource("/images/Fall.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);;
	private Image Winter = 
			new ImageIcon(this.getClass().getResource("/images/Winter.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);;
	
	//constructor
	public SeasonTile(String name) {
		super(name);
		setToolTipText(toString());

	}
	
	//inherits paintComponent and draws the image onto the tile
	//switches image based on input
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch(name){
		case "Spring":
			g.drawImage(Spring, 30, 10, this);
			break;
		case "Summer":
			g.drawImage(Summer, 30, 10, this);
			break;
		case "Fall":
			g.drawImage(Fall, 30, 10, this);
			break;
		case "Winter":
			g.drawImage(Winter, 30, 10, this);
			break;
		}
	}
	
	//main to test class
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Season Tiles");

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}
