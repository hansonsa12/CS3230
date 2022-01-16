import java.awt.Color;
import java.awt.*;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CharacterTile extends Tile {
	protected char symbol;
	
	public CharacterTile(char symbol) {
		this.symbol = symbol;
		
		setToolTipText(toString());
	}
	
    public boolean matches(Tile other){
        if (!super.matches(other))
            return false;
        CharacterTile otherObj = (CharacterTile) other;
        return symbol == otherObj.symbol;
    }
    
    //maps numeric/alphabetical key to their symbol value
    public static HashMap<Character, Character> map = new HashMap<> (); {
    	map.put('1', '\u4E00');
    	map.put('2', '\u4E8C');
    	map.put('3', '\u4E09');
    	map.put('4', '\u56DB');
    	map.put('5', '\u4E94');
    	map.put('6', '\u516D');
    	map.put('7', '\u4E03');
    	map.put('8', '\u516B');
    	map.put('9', '\u4E5D');
    	map.put('N', '\u5317');
    	map.put('E', '\u6771');
    	map.put('W', '\u897F');
    	map.put('S', '\u5357');
    	map.put('C', '\u4E2D');
    	map.put('F', '\u767C');
    };
    
    //maps 1-9 and N,E,W,S,C,F to their number/letter value
    public static HashMap<Character, Character> number = new HashMap<> (); {
    	number.put('1', '1');
    	number.put('2', '2');
    	number.put('3', '3');
    	number.put('4', '4');
    	number.put('5', '5');
    	number.put('6', '6');
    	number.put('7', '7');
    	number.put('8', '8');
    	number.put('9', '9');
    	number.put('N', 'N');
    	number.put('E', 'E');
    	number.put('W', 'W');
    	number.put('S', 'S');
    	number.put('C', 'C');
    	number.put('F', 'F');
    };
    
    //maps 1-9 keys to their wan value
    public static HashMap<Character, Character> wan = new HashMap<> (); {
    	wan.put('1', '\u842C');
    	wan.put('2', '\u842C');
    	wan.put('3', '\u842C');
    	wan.put('4', '\u842C');
    	wan.put('5', '\u842C');
    	wan.put('6', '\u842C');
    	wan.put('7', '\u842C');
    	wan.put('8', '\u842C');
    	wan.put('9', '\u842C');
    	wan.put('N', ' ');
    	wan.put('E', ' ');
    	wan.put('W', ' ');
    	wan.put('S', ' ');
    	wan.put('C', ' ');
    	wan.put('F', ' ');
    };

	//overwritten toString method, labels the tiles
    public String toString(){
        String string;
        switch(symbol){
            case 'N': string = "North Wind";
                break;
            case 'E': string = "East Wind";
                break;
            case 'W': string = "West Wind";
                break;
            case 'S': string = "South Wind";
                break;
            case 'C': string = "Red Dragon";
                break;
            case 'F': string = "Green Dragon";
                break;
            default: string = "Character " + symbol;
        }

        return string;
    }
    

    //gets chinese symbol using hashmap
	public String toChinese() {
    	String chinese = Character.toString(map.get(symbol));
    	return chinese;
		
	}
	
	//gets corner number/letter using hashmap
	public String toCorner() {
		String corner = Character.toString(number.get(symbol));
		return corner;
	}
	
	//gets wan symbol using hashmap
	public String toWan() {
		String wan1 = Character.toString(wan.get(symbol));
		return wan1;
	}
	
	//draws wan, chinese symbol, and number/letter on tile
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Color red = new Color(255, 0, 0);
		Color black  = new Color(0, 0, 0);
		g.setColor(red);
		g.drawString(this.toCorner(), 100, 20);
		g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 35));
		g.setColor(red);
		g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 40));
		g.drawString(this.toWan(), 50, 90);
		g.setColor(black);
		
		//if statement that changes the chinese symbol size and color based on which tile is entered
        if(symbol == 'N' || symbol == 'E' || symbol == 'S' || symbol == 'W'){
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 70));
            g.drawString(this.toChinese(), 35, 85);
        }else if(symbol == 'C'){
            g.setColor(new Color(247, 27, 7));
            g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 70));
            g.drawString(this.toChinese(), 35, 85);
        }else if(symbol == 'F'){
            g.setColor(new Color(4, 158, 30));
            g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 70));
            g.drawString(this.toChinese(), 35, 85);
        }
        else
        	g.drawString(this.toChinese(), 50, 45);
        
		
		
	}
	
	//main to test the class
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);


		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
    
    }
