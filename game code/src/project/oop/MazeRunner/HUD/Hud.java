// Contains a reference to the Player.
// Draws all relevant information at the
// bottom of the screen.

package project.oop.MazeRunner.HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.oop.MazeRunner.Entity.Key;
import project.oop.MazeRunner.Entity.Player;
import project.oop.MazeRunner.GameState.GameState;
import project.oop.MazeRunner.Main.GamePanel;
import project.oop.MazeRunner.Manager.Content;
import project.oop.MazeRunner.Manager.GameStateManager;

public class Hud extends GameState{
	
	// key collector bar at bottom
	
	private int yoffset;
	
	private BufferedImage bar;
	private BufferedImage key;
	private BufferedImage boat;
	private BufferedImage axe;
	
	private Player player;
	
	private int numKeys;
	
	private Font font;
	private Color textColor; 
	
	public Hud(Player p, ArrayList<Key> k,GameStateManager gsm) {
		super(gsm);
		player = p;
		numKeys = k.size();
		yoffset = GamePanel.HEIGHT;
		
		bar = Content.BAR[0][0];
		key = Content.KEY[0][0];
		boat = Content.ITEMS[0][0];
		axe = Content.ITEMS[0][1];
	
		font = new Font("Arial", Font.BOLD, 8);
		textColor = new Color(0, 0, 0);
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw hud
		g.drawImage(bar, 0, yoffset, null);
		
		// draw key bar
		g.setColor(textColor);
		g.fillRect(8, yoffset + 6, (int)(55.0 * player.numKeys() / numKeys), 5);
		
		// draw key amount
		g.setColor(textColor);
		g.setFont(font);
		String s = player.numKeys() + "/" + numKeys;
		Content.drawString(g, s, 66, yoffset + 3);
		if(player.numKeys() >= 3) g.drawImage(key, 92, yoffset, null);
		else g.drawImage(key, 92, yoffset, null);
		
		// draw items
		if(player.hasBoat()) g.drawImage(boat, 133, yoffset, null);
		if(player.hasAxe()) g.drawImage(axe, 120, yoffset, null);
		
		// draw time
		int seconds =  ((player.getsec() / 30) % 60);
		 Content.drawString(g, "0:" +seconds, 66, 3);
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadMap(String s) {
		// TODO Auto-generated method stub
		
	}
	
}
