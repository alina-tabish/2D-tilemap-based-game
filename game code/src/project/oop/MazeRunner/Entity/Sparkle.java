// Simple class that plays animation
// once and is removed.

package project.oop.MazeRunner.Entity;

import java.awt.Graphics2D;

import project.oop.MazeRunner.Manager.Content;
import project.oop.MazeRunner.TileMap.TileMap;

public class Sparkle extends Entity {
	
	// add sparkle on key
	private boolean remove;
	
	public Sparkle(TileMap tm) {
		super(tm);
		animation.setFrames(Content.SPARKLE[0]);
		animation.setDelay(5);
		width = height = 16;
	}
	
	public boolean shouldRemove() {
		return remove;
	}
	
	public void update() {
		animation.update();
		if(animation.hasPlayedOnce()) remove = true;
	}
	
	public void draw(Graphics2D g) {
		super.draw(g);
	}
	
}
