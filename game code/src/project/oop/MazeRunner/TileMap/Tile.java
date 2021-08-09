// Only contains two types of tiles:
// Blocked and non-blocked.

package project.oop.MazeRunner.TileMap;

import java.awt.image.BufferedImage;

public class Tile {
	
	private BufferedImage image;
	private int type;
	
	// tile types
	public static final int NORMAL = 0;  // player can walk on it
	public static final int BLOCKED = 1;  // player cannot walk on it
	
	public Tile(BufferedImage image, int type) {
		this.image = image;
		this.type = type;
	}
	
	public BufferedImage getImage() { return image; }
	public int getType() { return type; }
	
}
