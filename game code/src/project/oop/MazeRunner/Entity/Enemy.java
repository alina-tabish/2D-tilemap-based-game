package project.oop.MazeRunner.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import project.oop.MazeRunner.Manager.Content;
import project.oop.MazeRunner.TileMap.TileMap;

public class Enemy extends Entity{
	private BufferedImage[] downSprites;

	
	// animation
	private final int DOWN = 0;


	
	private long ticks;
	public Enemy(TileMap tm) {
		super(tm);
		// TODO Auto-generated constructor stub
		
		// size of enemy character
		
		width = 16;
		height = 16;
		cwidth = 12;
		cheight = 12;
		
		moveSpeed = 2;
		downSprites = Content.enemy[0];
	
		animation.setFrames(downSprites);
		animation.setDelay(10);
		
			
	}
	private void setAnimation(int i, BufferedImage[] bi, int d) {
		currentAnimation = i;
		animation.setFrames(bi);
		animation.setDelay(d);
	}
	public void setAction() {
	
		if(left) 
			setLeft();	
		if(up) 
			setUp();	
		if(down) 
			setDown();	
		if(right) 
			setRight();	
	}
public void update() {
	
		ticks++;
		

		super.update();
		if(down) {
			
				setAnimation(DOWN, downSprites, 10);
		setAction();}
		
}
public void draw(Graphics2D g) {
	super.draw(g);
}

}
