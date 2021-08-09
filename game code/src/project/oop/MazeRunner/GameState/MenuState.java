// The main menu GameState.


//The main menu GameState.

package project.oop.MazeRunner.GameState;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import project.oop.MazeRunner.Manager.Content;
import project.oop.MazeRunner.Manager.GameStateManager;
import project.oop.MazeRunner.Manager.Keys;

public class MenuState extends GameState {
	// menu of game
	
	private BufferedImage bg;
	private BufferedImage diamond;
	
	private int currentOption = 0;
	private String[] options = {
		"START",
		"QUIT",
	
	};
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		bg = Content.MENUBG[0][0];
		diamond = Content.KEY[0][0];

	}
	
	public void update() {
		handleInput();
		
	}
	
	public void draw(Graphics2D g) {
		
g.drawImage(bg, 0, 0, null);
		
		Content.drawString(g, options[0], 60, 100);
		Content.drawString(g, options[1], 64, 115);
		
		
		if(currentOption == 0) g.drawImage(diamond, 40, 96, null);
		else if(currentOption == 1) g.drawImage(diamond, 40, 113, null);
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.DOWN) && currentOption < options.length - 1) {
	
			currentOption++;
		}
		if(Keys.isPressed(Keys.UP) && currentOption > 0) {
	
			currentOption--;
		}
		if(Keys.isPressed(Keys.ENTER)) {
		
			selectOption();
		}
	}
	
	
	private void selectOption() {
		if(currentOption == 0) {
			gsm.setState(GameStateManager.NEXT,null);
		}
		if(currentOption == 1) {
			System.exit(0);
		}
	
	}

	@Override
	public void loadMap(String s) {
		// TODO Auto-generated method stub
		
	}
	
}
