package project.oop.MazeRunner.GameState;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import project.oop.MazeRunner.Manager.Content;
import project.oop.MazeRunner.Manager.GameStateManager;
import project.oop.MazeRunner.Manager.Keys;

public class SelectionState extends GameState {
	
	// menu for choosing worlds
	
	private BufferedImage m1;
	private BufferedImage bg;
	private BufferedImage m2;
	private BufferedImage key;
	public SelectionState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	private int currentOption =0;



private String [] option= {
		"enchanted",
		"underworld"
};

	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		m1 = Content.MAP1[0][0];
		m2 = Content.MAP2[0][0];
		bg= Content.MENUBG[0][0];
		key = Content.KEY[0][0];
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		handleInput();
	
	}

	@Override
	public void draw(Graphics2D g) {
		
		g.drawImage(bg, 0, 0, null);		
        g.drawImage(m1, 120, 95, null);
		Content.drawString(g, option[0], 30, 100);
		g.drawImage(m2, 120, 124, null);
		Content.drawString(g, option[1], 30, 130);
		
		if(currentOption == 0) g.drawImage(key, 10, 98, null);
		else if(currentOption == 1) g.drawImage(key, 10, 128, null);
		
	}

	@Override
	public void handleInput() {if(Keys.isPressed(Keys.DOWN) && currentOption < option.length - 1) {
	
		currentOption++;
	}
	if(Keys.isPressed(Keys.UP) && currentOption > 0) {
	
		currentOption--;
	}
	if(Keys.isPressed(Keys.ENTER)) {
		selectOption();
	}
		// TODO Auto-generated method stub
	}	
	

	private void selectOption() {
		
			if(currentOption == 0) {

				gsm.setState(GameStateManager.WORLD1,null);
				
			}
			 if(currentOption == 1) {
		
			gsm.setState(GameStateManager.WORLD2,null);

			
			}
			}
		
	
		// TODO Auto-generated method stub
		
	

	@Override
	public void loadMap(String s) {
		// TODO Auto-generated method stub
		
	}

	
	
}

