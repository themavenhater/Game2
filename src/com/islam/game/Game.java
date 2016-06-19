package com.islam.game;

import com.islam.entities.mob.Dummy;
import com.islam.entities.mob.Player;
import com.islam.game.input.Keyboard;
import com.islam.levels.Level;
import com.islam.levels.Mapobjects;
import com.islam.levels.TileCoord;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {  // ***** 1 ****** //

	/**
	 * 
	 */
	private Mapobjects mapo;
	private static final long serialVersionUID = 1L;
	public static int width = 400;                 //  1 - static because it's fixed .
	public static int height =  width / 16 * 9 ;
	public static int scale = 3;
	public static String title="Lol";
	
	public int score=0;
	
	
	private Thread thread ;                        //  2- start a process of our game
	private boolean running = false ;              //  6 - for the game loop 
	private JFrame frame ;
	private Keyboard key;
	private Screen screen;                          // 25 create Screen to fill the pixels
	private Level level;                             // importing level to render it
	private Player player;
	private Dummy dummy;
	private Dummy dummy2;
	
	private  BufferedImage image = new BufferedImage(width, height , BufferedImage.TYPE_INT_RGB);    // 22 creating image
	private int [] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();            // 23 writing data on image
			
	public Game (){                                // 11 creating the constructor
		
		Dimension size =new Dimension ( width * scale , height * scale);     // 12 Dimension of the JFRAME
		setPreferredSize(size);
		screen = new Screen(width,height);                              //26 instance of Screen
		frame = new JFrame() ;
		key=new  Keyboard();
		level = Level.spawn;                               // 50 start the level

	    TileCoord tc = new TileCoord(21,8);
		player = new Player(tc.x(),tc.y(),key);
		level.add(player);
		mapo = new Mapobjects(level);
		
		
		
		addKeyListener(key);
	   
	}
	public Level getllevel(){ return level; }
	
	public synchronized void start (){             // 3- start the thread  // synchronized Synchronized methods enable a simple strategy for preventing thread interference 
		
		running=true;                               // 8 when we call start we must change  running to true to keep the game loop running
		thread = new Thread(this , " Display");        // 4  this means the thread will contain a Game object
		thread.start();
	}
	
	
     public synchronized void stop (){                // 5 stop the thread to prevent overlaps
		
    	 running = false ;                            // 9 when stop is called running = false
    	 try {
		thread.join();}
				catch (InterruptedException e){ System.out.println("EROOR");
	}
    	 
		
     }

	
	public void run() {                             // 7 main loop of the game 
		
		long lasttime=System.nanoTime();                            //30 timer , frames per secondes
		final double ns =  1000000000/60;
		double delta =0;
		int frames =0, updates=0;
		long timer=System.currentTimeMillis();
				
		while ( running ) { 
			
			long now =System.nanoTime();
			delta+=(now -lasttime)/ns;
			lasttime=now;
			while(delta>=1){
               update();                   //    14 update every second the movements and all events
               updates++;
               delta--;
			}
			render();               //    15  display images to the screen
			frames++;
			
			if ( System.currentTimeMillis()-timer>1000){
				
				timer+=1000;
				
				frame.setTitle(title + "   FPS   "+ updates+"   " + frames);
				updates=0;
				frames=0;
				
			}
			
			}
		stop();
	}
	
	
	
	public void render (){                        // 16 making the render methods
		
		BufferStrategy bs = getBufferStrategy();                  // 18 buffer strategy allows us to store images on memory to render it
		
		if (bs==null) {
			createBufferStrategy(2);
			return;
		}
		
		screen.clear();
		int xScroll =  player.getX() -screen.width/2;                                     // render the map to place the player in the middle of the screen
		int yScroll =  player.getY() -screen.height/2;
		
		level.render(xScroll, yScroll, screen); 
		player.renderp(screen);                                                 		 // render the movement of player                                                                       
		
		
		for (int i=0;  i<pixels.length;i++){                    // 28 render method of Screen to fill pixels
			pixels[i]=screen.pixels[i];
		}
		
        Graphics g = bs.getDrawGraphics();                      // 19 graphic it's drawin , we link it to the buffer to be rendered 
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
	   // g.setColor(Color.RED);
	   // g.fillRect(700, 20,100, 30);
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Verdana",0,30));
	    g.drawString("Score:"+level.score, 700, 50);
	  
		g.dispose();                                          // 21 transfer the images to be rendered       
		bs.show();                               
	}
	
	public void update (){                        // 17 making the update method
		key.update();
		level.update();
		
	}
	
	
	
	public static void main (String args[]){
		
		Game game = new Game();                                             //13 starting our Game , displaying the Window
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();

		
		
	}
	
	
}
