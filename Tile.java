import java.awt.*;

import javax.swing.*;

public class Tile extends JPanel {
	//static variables used throughout the project
	//colors, polygons, and gradients
	
	public 	final static Color GREEN = new Color(0, 205, 0);
	public final static Color RED = new Color(230, 0, 0);
	private static Dimension SIZE;
	private static Polygon FIRSTLEFT;
	private static Polygon SECONDLEFT;
	private static Polygon FIRSTBOTTOM;
	private static Polygon SECONDBOTTOM;
	private static Rectangle FACE;
	private static GradientPaint LEFTWHITE;
	private static GradientPaint BOTTOMWHITE;
	private static GradientPaint LEFTRED;
	private static GradientPaint BOTTOMRED;
	private static GradientPaint TILEWHITE;
	private static Color BLACK;

	
	static {
		//dimensions for the tile
		SIZE = new Dimension (121, 121);
		int[] xFirstLeft = {10, 20, 20, 10};
		int[] yFirstLeft = {10, 0, 100, 110};
		int[] xFirstBottom = {10, 20, 120, 110};
		int[] yFirstBottom = {110, 100, 100, 110};
		int[] xSecondLeft = {0, 10, 10, 0};
		int[] ySecondLeft = {20, 10, 110, 120};
		int[] xSecondBottom = {0, 10, 110, 100};
		int[] ySecondBottom = {120, 110, 110, 120};
		
		//colors for the tile
		Color white = new Color(255, 255, 255);
		Color ivory = new Color(237, 230, 158);
		Color darkred = new Color(139, 0, 0);
		Color red = new Color(255, 0, 0);
		//gradients for the tile
		LEFTWHITE = new GradientPaint(50, 90, white, 75, 50, ivory);
		BOTTOMWHITE = new GradientPaint(50, 90, white, 100, 50, ivory);
		LEFTRED = new GradientPaint(50, 95, red, 95, 50, darkred);
		BOTTOMRED = new GradientPaint(50, 95, red, 95, 50, darkred);
		TILEWHITE = new GradientPaint(50, 95, white, 95, 50, ivory);
		BLACK = new Color(0, 0, 0);
		
		
	    
		//layers for the tile
		FIRSTLEFT = new Polygon(xFirstLeft, yFirstLeft, 4);
		FIRSTBOTTOM = new Polygon(xFirstBottom, yFirstBottom, 4);
		SECONDLEFT = new Polygon(xSecondLeft, ySecondLeft, 4);
		SECONDBOTTOM = new Polygon(xSecondBottom, ySecondBottom, 4);
		FACE = new Rectangle (20, 0 , 100, 100);
	}

	public int yPosition;
	public int xPosition;
	public int zPosition;
	public int zOrder;
	public boolean highlightTile = false;
	public int xBound;
	public int yBound;
	
	
	public Tile() {
		setPreferredSize(SIZE);
		setOpaque(false);
	}
	
	//draws and fills the tile
	public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 
		 Graphics2D g2 = (Graphics2D)g;
		 
		 g2.setPaint(LEFTRED);
		 g2.fillPolygon(SECONDLEFT);
		 g2.setColor(BLACK);
		 g2.draw(SECONDLEFT);
		 
		 g2.setPaint(BOTTOMRED);
		 g2.fillPolygon(SECONDBOTTOM);
		 g2.setColor(BLACK);
		 g2.draw(SECONDBOTTOM);
		 
		 g2.setPaint(LEFTWHITE);
		 g2.fillPolygon(FIRSTLEFT);
		 g2.setColor(BLACK);
		 g2.draw(FIRSTLEFT);
		 
		 g2.setPaint(BOTTOMWHITE);
		 g2.fillPolygon(FIRSTBOTTOM);
		 g2.setColor(BLACK);
		 g2.draw(FIRSTBOTTOM);
		 
		 g2.setPaint(TILEWHITE);
		 g2.fill(FACE);
		 g2.setColor(BLACK);
		 g2.draw(FACE);
		 
	        if(highlightTile){
	            g2.setPaint(GREEN);
	            g2.fill(FACE);
	        }
		 
		
	}
	
    public void setXPosition(int x){
        xPosition = x;
    }

    public void setYPosition(int y){
        yPosition = y;
    }

    public void setZPosition(int z){
        zPosition = z;
    }

    public void setZOrder(int z){
        zOrder = z;
    }

    public void setZOrder()
    {
        zOrder = getParent().getComponentZOrder(this);
    }


    public void resetZOrder()
    {
        getParent().setComponentZOrder(this, zOrder);
    }


    public int getZOrder()
    {
        return zOrder;
    }
	
	
	public boolean matches(Tile other) {
		if (other == null) 
			return false;
		
		if (this == other) 
			return false;
		
		if (this.getClass() == other.getClass()) 
			return true;
		else
			return false;
		
	}
	

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");

		frame.add(new Tile());

		frame.pack();
		frame.setVisible(true);
	}
}
