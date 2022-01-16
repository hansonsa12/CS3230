import java.awt.*;



import javax.swing.JFrame;

public class WhiteDragonTile extends Tile
{
	
	public WhiteDragonTile()
	{
		setToolTipText("White Dragon");
	}
	
	public String toString()
	{
		return "White Dragon";
	}
	
	//draws rectangles on tile
	public void paintComponent(Graphics g) {	
        super.paintComponent(g);
        
        g.setColor(new Color(6,61,163));
        g.draw3DRect(27,8,85,85,false);
        g.draw3DRect(35,15,70,70,false);

        //top
        g.fill3DRect(28,8,15,8,false);
        g.fill3DRect(57,8,15,8,false);
        g.fill3DRect(85,8,15,8,false);
        //right
        g.fill3DRect(106,15,7,15,false);
        g.fill3DRect(106,44,7,15,false);
        g.fill3DRect(105,71,7,15,false);
        //bottom
        g.fill3DRect(28,85,15,8,false);
        g.fill3DRect(57,85,15,8,false);
        g.fill3DRect(85,85,15,8,false);
        //left
        g.fill3DRect(28,28,7,15,false);
        g.fill3DRect(28,57,7,15,false);
	}
	
	//main to test the class
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("White Dragon Tile");

		frame.add(new WhiteDragonTile());

		frame.pack();
		frame.setVisible(true);
	}
	
	
}
