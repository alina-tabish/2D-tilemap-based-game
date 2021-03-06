// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package project.oop.MazeRunner.Main;

import javax.swing.JFrame;

// main class 

public class Game {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Maze Runner");;
		window.add(new GamePanel());
		
		window.setResizable(false);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
