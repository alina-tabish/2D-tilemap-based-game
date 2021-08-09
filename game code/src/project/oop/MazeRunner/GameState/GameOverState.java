// Congratulations for finishing the game.
// Gives you a rank based on how long it took
// you to beat the game.

// Under two minutes = Speed Demon
// Under three minutes = Adventurer
// Under four minutes = Beginner
// Four minutes or greater = Bumbling Idiot

package project.oop.MazeRunner.GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import project.oop.MazeRunner.Main.GamePanel;
import project.oop.MazeRunner.Manager.Content;
import project.oop.MazeRunner.Manager.Data;
import project.oop.MazeRunner.Manager.GameStateManager;
import project.oop.MazeRunner.Manager.Keys;

public class GameOverState extends GameState {
	
	private Color color;
	

	private long ticks;
	
	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		color = new Color(0, 0, 0);
		ticks = Data.getTime();
		
	}
	
	public void update() {}
	
	public void draw(Graphics2D g) {
		
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
	
		
		Content.drawString(g, "GAME OVER", 42, 80);
	
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) {
			gsm.setState(GameStateManager.MENU,null);
			
		}
	}

	@Override
	public void loadMap(String s) {
		// TODO Auto-generated method stub
		
	}
	
}