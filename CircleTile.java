import java.awt.*;
import javax.swing.*;

public class CircleTile extends RankTile {
	
	//array of circle objects
	final Circle circles[] = new Circle[9];
	
	public CircleTile(int rank) {
		
		super(rank);
		setToolTipText(toString());
		
		switch(rank){
		case 1:
			circles[0] = new Pancake( 61, 41, Color.RED);
			break;
		case 2:
			circles[0] = new Circle(60, 25, Color.GREEN);
			circles[1] = new Circle(60, 65, Color.RED);
			break;
		case 3:
			circles[0] = new Circle(25, 5, Color.BLUE);
			circles[1] = new Circle(63, 43, Color.RED);
			circles[2] = new Circle(100, 80, Color.GREEN);
			break;
		case 4:
			circles[0] = new Circle(40, 20, Color.BLUE);
			circles[1] = new Circle(40, 65, Color.GREEN);
			circles[2] = new Circle(80, 20, Color.GREEN);
			circles[3] = new Circle(80, 65, Color.BLUE);
			break;
		case 5:
			circles[0] = new Circle(30, 10, Color.BLUE);
			circles[1] = new Circle(63, 43, Color.RED);
			circles[2] = new Circle(95, 75, Color.BLUE);
			circles[3] = new Circle(95, 10, Color.GREEN);
			circles[4] = new Circle(30, 75, Color.GREEN);
			break;
		case 6:
			circles[0] = new Circle(40, 10, Color.GREEN);
			circles[1] = new Circle(80, 10, Color.GREEN);
			circles[2] = new Circle(40, 40, Color.RED);
			circles[3] = new Circle(80, 40, Color.RED);
			circles[4] = new Circle(40, 70, Color.RED);
			circles[5] = new Circle(80, 70, Color.RED);
			break;
		case 7:
			circles[0] = new Circle(30, 10, Color.GREEN);
			circles[1] = new Circle(60, 20, Color.GREEN);
			circles[2] = new Circle(90, 30, Color.GREEN);
			circles[3] = new Circle(40, 52, Color.RED);
			circles[4] = new Circle(80, 52, Color.RED);
			circles[5] = new Circle(40, 75, Color.RED);
			circles[6] = new Circle(80, 75, Color.RED);
			break;
		case 8:
			circles[0] = new Circle(40, 7, Color.BLUE);
			circles[1] = new Circle(80, 7, Color.BLUE);
			circles[2] = new Circle(40, 30, Color.BLUE);
			circles[3] = new Circle(80, 30, Color.BLUE);
			circles[4] = new Circle(40, 53, Color.BLUE);
			circles[5] = new Circle(80, 53, Color.BLUE);
			circles[6] = new Circle(40, 76, Color.BLUE);
			circles[7] = new Circle(80, 76, Color.BLUE);
			break;
		case 9:
			circles[0] = new Circle(30, 15, Color.GREEN);
			circles[1] = new Circle(60, 15, Color.GREEN);
			circles[2] = new Circle(90, 15, Color.GREEN);
			circles[3] = new Circle(30, 45, Color.RED);
			circles[4] = new Circle(60, 45, Color.RED);
			circles[5] = new Circle(90, 45, Color.RED);
			circles[6] = new Circle(30, 75, Color.BLUE);
			circles[7] = new Circle(60, 75, Color.BLUE);
			circles[8] = new Circle(90, 75, Color.BLUE);
			break;
		}
	}
	
	public String toString() {
		return "Circle " +  rank;
	}
	


	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Circle c : circles)
			if (c != null)
				c.draw(g);
	}
	
public class Circle {
		
		private int x;
		private int y;
		private Color color;
		
		public Circle(int x, int y, Color color) {
			
			super();
			this.x = x;
			this.y = y;
			this.color = color;
			
		}
		
		public void draw(Graphics g) {
			g.setColor(color);
			g.fillOval(x, y, 17 , 17);
			g.setColor(Color.WHITE);
			g.drawLine(x+6, y+6, x+11, y+11);
			g.drawLine(x+11, y+6, x+6, y+11);
		}
		
	}
	

public class Pancake extends Circle {

	public Pancake(int x, int y, Color color) {
		
		super(x, y, color);
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(35, 15, 70, 70);
		g.setColor(Color.WHITE);
		super.draw(g);
		g.setColor(Color.BLACK);
		g.drawOval(35, 15, 70, 70);
		Graphics2D	g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_MITER, 5.0f, new float[] {0.4f, 7.0f}, 10.0f));
		g2.drawOval(40, 20, 60, 60);
	}
	
}


	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
	
}