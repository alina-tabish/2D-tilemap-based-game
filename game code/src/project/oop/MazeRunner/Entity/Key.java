// Diamond class.
// May contain a list of tileChanges.
// These tileChanges are used to modify
// the tile map upon collection.

package project.oop.MazeRunner.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.oop.MazeRunner.Manager.Content;
import project.oop.MazeRunner.TileMap.TileMap;

public class Key extends Entity {
	
	BufferedImage[] sprites;
	
	private ArrayList<int[]> tileChanges;
	
	public Key(TileMap tm) {
		
		super(tm);
		
		// size of key sprite
		width = 16;
		height = 16;
		cwidth = 12;
		cheight = 12;
		
		sprites = Content.KEY[0];
		animation.setFrames(sprites);
		animation.setDelay(10);
		
		tileChanges = new ArrayList<int[]>();
		
	}
	// replace with plain tile when key is collected
	
	public void addChange(int[] i) {
		tileChanges.add(i);
	}
	public ArrayList<int[]> getChanges() {
		return tileChanges;
	}
	
	public void update() {
		animation.update();
	}
	
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
}
