// The GameStateManager does exactly what its
// name says. It contains a list of GameStates.
// It decides which GameState to update() and
// draw() and handles switching between different
// GameStates.

package project.oop.MazeRunner.Manager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import project.oop.MazeRunner.GameState.GameOverState;
import project.oop.MazeRunner.GameState.GameState;
import project.oop.MazeRunner.GameState.IntroState;
import project.oop.MazeRunner.GameState.MenuState;
import project.oop.MazeRunner.GameState.PauseState;
import project.oop.MazeRunner.GameState.SelectionState;
import project.oop.MazeRunner.GameState.WORLD1;
import project.oop.MazeRunner.GameState.WORLD2;

public class GameStateManager {
	
	// defining all game states here
	
	private boolean paused;
	private PauseState pauseState;
	
	private GameState[] gameStates;
	private int currentState;
	private int previousState;
	
	public static final int NUM_STATES = 6;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int WORLD1 = 2;
	public static final int GAMEOVER = 3;
	public static final int NEXT= 4;
	public static final int WORLD2 = 5;


	
	public GameStateManager() {
		
		
		paused = false;
		pauseState = new PauseState(this);
		
		gameStates = new GameState[NUM_STATES];
		setState(INTRO, null);
		
	}
	
	public void setState(int i,String s) {
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
		if(i == INTRO) {
			gameStates[i] = new IntroState(this);
			gameStates[i].init();
		}
		else if(i == MENU) {
			gameStates[i] = new MenuState(this);
			gameStates[i].init();
		}
		
		else if(i == GAMEOVER) {
			gameStates[i] = new GameOverState(this);
			gameStates[i].init();
		}
		else if(i == NEXT) {

			gameStates[i] = new SelectionState(this);
		
			gameStates[i].init();
		}
		else if(i == WORLD1) {


				gameStates[i] = new WORLD1(this);
				gameStates[i].init();
			}
		else if(i == WORLD2) {

		

				gameStates[i] = new WORLD2(this);
				gameStates[i].init();
			}
	}
	
	public void unloadState(int i) {
		gameStates[i] = null;
	}
	
	public void setPaused(boolean b) {
		paused = b;
	}
	
	public void update() {
		if(paused) {
			pauseState.update();
		}
		else if(gameStates[currentState] != null) {
			gameStates[currentState].update();
		}
	}
	
	public void draw(Graphics2D g) {
		if(paused) {
			pauseState.draw(g);
		}
		else if(gameStates[currentState] != null) {
			gameStates[currentState].draw(g);
		}
	}

	public void drawImage(BufferedImage map, int i, int j, Object object) {
		// TODO Auto-generated method stub
		
	}

	
}
