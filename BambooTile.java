import java.awt.*;

import javax.swing.*;

public class BambooTile extends RankTile {
	
	//an array of bamboo objects
	final Bamboo bamboos[] = new Bamboo[9];
	
	//inherits rank from RankTile
	//depending on rank is how many bamboo objects are drawn
	//sets bamboo colors and sizes
	public BambooTile(int rank) {
		super(rank);
		
		switch(rank) {
		case 2:
			bamboos[0] = new Bamboo(60, 20, Color.BLUE);
			bamboos[1] = new Bamboo(60, 50, Color.GREEN);
			break;
		case 3:
			bamboos[0] = new Bamboo(60, 20, Color.BLUE);
			bamboos[1] = new Bamboo(40, 50, Color.GREEN);
			bamboos[2] = new Bamboo(80, 50, Color.GREEN);
			break;
		case 4:
			bamboos[0] = new Bamboo(40, 20, Color.BLUE);
			bamboos[1] = new Bamboo(40, 50, Color.GREEN);
			bamboos[2] = new Bamboo(80, 20, Color.GREEN);
			bamboos[3] = new Bamboo(80, 50, Color.BLUE);
			break;
		case 5:
			bamboos[0] = new Bamboo(35, 20, Color.GREEN);
			bamboos[1] = new Bamboo(35, 50, Color.BLUE);
			bamboos[2] = new Bamboo(60, 35, Color.RED);
			bamboos[3] = new Bamboo(85, 20, Color.BLUE);
			bamboos[4] = new Bamboo(85, 50, Color.GREEN);
			break;
		case 6:
			bamboos[0] = new Bamboo(35, 15, Color.GREEN);
			bamboos[1] = new Bamboo(35, 55, Color.BLUE);
			bamboos[2] = new Bamboo(60, 15, Color.GREEN);
			bamboos[3] = new Bamboo(60, 55, Color.BLUE);
			bamboos[4] = new Bamboo(85, 15, Color.GREEN);
			bamboos[5] = new Bamboo(85, 55, Color.BLUE);
			break;
		case 7:
			bamboos[0] = new Bamboo(60, 5, Color.RED);
			bamboos[1] = new Bamboo(35, 35, Color.GREEN);
			bamboos[2] = new Bamboo(60, 35, Color.BLUE);
			bamboos[3] = new Bamboo(35, 65, Color.GREEN);
			bamboos[4] = new Bamboo(60, 65, Color.BLUE);
			bamboos[5] = new Bamboo(85, 35, Color.GREEN);
			bamboos[6] = new Bamboo(85, 65, Color.GREEN);
			break;
		case 8:
			bamboos[0] = new Bamboo(60, 10, Color.GREEN);
			bamboos[1] = new Bamboo(35, 65, Color.BLUE);
			bamboos[2] = new Bamboo(35, 10, Color.GREEN);
			bamboos[3] = new Bamboo(60, 65, Color.BLUE);
			bamboos[4] = new Bamboo(85, 10, Color.GREEN);
			bamboos[5] = new Bamboo(85, 65, Color.BLUE);
			bamboos[6] = new Bamboo(47, 38, Color.RED);
			bamboos[7] = new Bamboo(72, 38, Color.RED);
			break;
		case 9:
			bamboos[0] = new Bamboo(35, 5, Color.RED);
			bamboos[1] = new Bamboo(35, 35, Color.RED);
			bamboos[2] = new Bamboo(60, 5, Color.BLUE);
			bamboos[3] = new Bamboo(60, 35, Color.BLUE);
			bamboos[4] = new Bamboo(85, 5, Color.GREEN);
			bamboos[5] = new Bamboo(85, 35, Color.GREEN);
			bamboos[6] = new Bamboo(35, 65, Color.RED);
			bamboos[7] = new Bamboo(60, 65, Color.BLUE);
			bamboos[8] = new Bamboo(85, 65, Color.GREEN);
			break;
	}
		setToolTipText(toString());
		}
	
	public String toString() {
		return "Bamboo " + rank;
	}
	
	//inherits paint component
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for (Bamboo b : bamboos)
			if (b != null)
				b.draw(g);
		}
	
public class Bamboo {
		
		private int x;
		private int y;
		private Color color;
		
		public Bamboo(int x, int y, Color color) {
			
			super();
			this.x = x;
			this.y = y;
			this.color = color;
			
		}
				
		//design for bamboo
		public void draw(Graphics g) {	
			
			g.setColor(color);
			g.fillOval(x, y, 14, 10);
			g.fillOval(x, y + 18, 14, 10);
			g.fillRoundRect(x + 4, y + 3, 7, 25, 7, 7);
			g.setColor(Color.WHITE);
			g.drawLine(x + 5, y + 4, x + 5, y + 25);
			g.drawLine(x + 9, y + 4, x + 9, y + 25);
			g.setColor(color);
			g.fillOval(x + 2, y + 9, 10, 10);
		}
		
	}
		
	
	
	//main to test class
	public  static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
	
}
