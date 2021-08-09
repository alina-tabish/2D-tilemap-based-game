
// The main playing GameState.
// Contains everything you need for gameplay:
// Player, TileMap, Diamonds, etc.
// Updates and draws all game objects.

package project.oop.MazeRunner.GameState;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import project.oop.MazeRunner.Entity.Enemy;
import project.oop.MazeRunner.Entity.Item;
import project.oop.MazeRunner.Entity.Key;
import project.oop.MazeRunner.Entity.Player;
import project.oop.MazeRunner.Entity.Sparkle;
import project.oop.MazeRunner.HUD.Hud;
import project.oop.MazeRunner.Main.GamePanel;
import project.oop.MazeRunner.Manager.Data;
import project.oop.MazeRunner.Manager.GameStateManager;
import project.oop.MazeRunner.Manager.Keys;
import project.oop.MazeRunner.TileMap.TileMap;

// playstate for WORLD2
public class WORLD2 extends GameState {
	
	// player
	private Player player;
	
	// tilemap
	private TileMap tileMap;

	
	// keys
	private ArrayList<Key>keys;
	private ArrayList<Enemy> enemies;
	// items
	private ArrayList<Item> items;
	
	// sparkles
	private ArrayList<Sparkle> sparkles;
	
	// camera position
	private int xsector;
	private int ysector;
	private int sectorSize; 
	private double time=(LocalDateTime.now().getMinute())+2;
	double e=time;
	// hud
	private Hud hud;
	Enemy enemy;
	// events
	private boolean blockInput;
	private boolean eventStart;
	private boolean eventFinish;
	private int eventTick;
	boolean bt;
	// transition box
	private ArrayList<Rectangle> boxes;
	
	public WORLD2(GameStateManager gsm) {
		super(gsm);
	}
	Random r=new Random();
	public void init() {
		
		// create lists
		keys = new ArrayList<Key>();
		sparkles = new ArrayList<Sparkle>();
		items = new ArrayList<Item>();
		enemies=new ArrayList<Enemy>();
		// load map
		tileMap = new TileMap(16);
		

		tileMap.loadTiles("/Tilesets/dark maze.png");

		tileMap.loadMap("/Maps/testmap.map");
	

		// create player
		player = new Player(tileMap);
		enemy =new Enemy(tileMap);
		// fill lists
		populateKeys();
		populateItems();
		
		
		
		// initialize player
		player.setTilePosition(2, 2);
		player.setTotalKeys(keys.size());
	
		populateEnemy();
		
		// set up camera position
		sectorSize = GamePanel.WIDTH;
		xsector = player.getx() / sectorSize;
		ysector = player.gety() / sectorSize;
		tileMap.setPositionImmediately(-xsector * sectorSize, -ysector * sectorSize);
		
		// load hud
		hud = new Hud(player, keys, gsm);
		
		
		// start event
		boxes = new ArrayList<Rectangle>();
		eventStart = true;
		eventStart();
			
	}
	Enemy enemy1;

	private void populateEnemy() {
		enemy =new Enemy(tileMap);
		 enemy1 =new Enemy(tileMap);
		// TODO Auto-generated method stub
		//if(player.numDiamonds() == 5)
		
		enemy.setTilePosition(4,4 );
		enemies.add(enemy);
		enemy1.setTilePosition(5,18 );
		enemies.add(enemy1);
		
		
	}
 
	private void populateKeys() {
		
		Key k;
		
		k = new Key(tileMap);
		k.setTilePosition(4, 1);
		keys.add(k);
		
	    k = new Key(tileMap);
		k.setTilePosition(18, 3);
		keys.add(k);
		
		k= new Key(tileMap);
		k.setTilePosition(8, 8);
		keys.add(k);
		
		k = new Key(tileMap);
		k.setTilePosition(2,13);
		keys.add(k);
		
		k = new Key(tileMap);
		k.setTilePosition(5, 13);
		keys.add(k);
	
		
	}
	Item item4;
	Item item3;
	private void populateItems() {

	 item3 = new Item
				
				(tileMap);
		item3.setType(Item.AXE);
		item3.setTilePosition(1,8);
		items.add(item3);
		
		 Item item4 = new Item(tileMap);
		item4.setType(Item.BOAT);
		item4.setTilePosition(4, 4);
		items.add(item4);
		
	}
	
	public void update() {
		
		
	boolean b=player.numKeys() >= 1;
		
		if(b==true) {
			if(player.intersects(enemy)==false){
					
					enemy.setLeft();
									}
			                            }
		
					if(player.numKeys() == 4){
						
					{if(player.intersects(enemy1)==false)
				{
						enemy1.setLeft();
		
						}}
					}
				
		// check keys
		handleInput();
		
		// check events
		if(eventStart) eventStart();
		if(eventFinish) eventFinish();
		
		if(player.numKeys() == player.getTotalKeys()||(((player.getx()==120 && player.gety()==40)||
			(player.getx()==264 && player.gety()==40)||(player.getx()==88 && player.gety()==248)||(player.getx()==120 && player.gety()==120)||(player.getx()==216&&player.gety()==232)||(player.getx()==216&&player.gety()==248)||(player.getx()==216&&player.gety()==264)||(player.getx()==216&&player.gety()==248))&&player.hasBoat()==false)||LocalDateTime.now().getMinute()==time||( bt
					==false && player.intersects(enemy))||(( c==false && player.intersects(enemy1))))
				
				{
			eventFinish = blockInput = true;
		}
		enemy.update();
		enemy1.update();
		// update camera
		int oldxs = xsector;
		int oldys = ysector;
		xsector = player.getx() / sectorSize;
		ysector = player.gety() / sectorSize;
		tileMap.setPosition(-xsector * sectorSize, -ysector * sectorSize);
		tileMap.update();
		
		
		if(oldxs != xsector || oldys != ysector) {
			
		}
		
		if(tileMap.isMoving()) return;
		
		
		// update player
		player.update();
		// update keys
		for(int i = 0; i < keys.size(); i++) {
			
		Key k = keys.get(i);
		k.update();
			
			// player collects key
			if(player.intersects(k)) {
				
				// remove from list
				keys.remove(i);
				i--;
				
				// increment amount of collected keys
				player.collectedKeys();
				
			
				
				// add new sparkle
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(k.getx(), k.gety());
				sparkles.add(s);
				
				// make any changes to tile map
				ArrayList<int[]> a = k.getChanges();
				for(int[] j : a) {
					tileMap.setTile(j[0], j[1], j[2]);
				}
				if(a.size() != 0) {
		
				}
				
			}
		}
		
		// update sparkles
		for(int i = 0; i < sparkles.size(); i++) {
			Sparkle s = sparkles.get(i);
			s.update();
			if(s.shouldRemove()) {
				sparkles.remove(i);
				i--;
			}
		}
		
			
	
		
		// update items
		for(int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
		
	
			if(player.intersects(item)) {
				items.remove(i);
				i--;
					item.collected(player);
				
				Sparkle s = new Sparkle(tileMap);
				s.setPosition(item.getx(), item.gety());
				sparkles.add(s);}
			}
		}
	
	boolean c;
	int g=0;
	public void draw(Graphics2D g) {
		
		// draw tilemap
		tileMap.draw(g);
	
		// draw items
					for(Item i : items) {
						i.draw(g);
					}
		// draw player
		player.draw(g);
		if(bt==false )
		
			
		{enemy.draw(g);}
		if(c==false )
			
		{enemy1.draw(g);}
		
		// draw keys
		for(Key k: keys) {
			k.draw(g);
		}
		
		// draw sparkles
		for(Sparkle s : sparkles) {
			s.draw(g);
		}
		
		
		
		// draw hud
		hud.draw(g);
		
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) {
			gsm.setPaused(true);
		}
		if(blockInput) return;
		if(Keys.isDown(Keys.LEFT)) player.setLeft();
		if(Keys.isDown(Keys.RIGHT)) player.setRight();
		if(Keys.isDown(Keys.UP)) player.setUp();
		if(Keys.isDown(Keys.DOWN)) player.setDown();
		if(Keys.isPressed(Keys.SPACE)) 
		{	
		g++;
		
		boolean u=player.hasAxe();
		if(u==true)
		{if(g==5)
		{c =true;}}
		if(u==true)
		{if(g==2)
		{bt =true;}}
		player.setAction();}
	}
	
	//===============================================
	
	private void eventStart() {
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 9; i++) {
				boxes.add(new Rectangle(0, i * 16, GamePanel.WIDTH, 16));
			}
		}
		if(eventTick > 1 && eventTick < 32) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					r.x -= 4;
				}
				else {
					r.x += 4;
				}
			}
		}
		if(eventTick == 33) {
			boxes.clear();
			eventStart = false;
			eventTick = 0;
		}
	}
	
	private void eventFinish() {
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 9; i++) {
				if(i % 2 == 0) boxes.add(new Rectangle(-128, i * 16, GamePanel.WIDTH, 16));
				else boxes.add(new Rectangle(128, i * 16, GamePanel.WIDTH, 16));
			}
			
		}
		if(eventTick > 1) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					if(r.x < 0) r.x += 4;
				}
				else {
					if(r.x > 0) r.x -= 4;
				}
			}
		}
		if(eventTick > 33) {
				Data.setTime(player.getTicks());
				gsm.setState(GameStateManager.GAMEOVER,null);
			}
	

			}
			


	@Override
	public void loadMap(String s) {
		// TODO Auto-generated method stub
		
	}
	}
	
//}
