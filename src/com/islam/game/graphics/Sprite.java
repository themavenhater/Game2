package com.islam.game.graphics;

public class Sprite {

	
	public final int SIZE;
	public int x ,y ;
	public int  pixels [];
	private SpriteSheet sheet;
	
   public static Sprite land = new Sprite(16 ,0,0,SpriteSheet.tiles);          // creating sprite of type land
   public static Sprite rock = new Sprite(16 ,1,0,SpriteSheet.tiles);          // creating sprite of type land
   public static Sprite flower = new Sprite(16 ,2,0,SpriteSheet.tiles);          // creating sprite of type land
   public static Sprite voidSprite = new Sprite(32 , 0); 
  
   // items Sprites
   public static Sprite crystalball = new Sprite(16 ,3,0,SpriteSheet.dummy);
   public static Sprite thing = new Sprite(16 ,4,0,SpriteSheet.dummy);
   public static Sprite bag = new Sprite(16 ,5,0,SpriteSheet.dummy);
   public static Sprite bomb = new Sprite(16 ,6,0,SpriteSheet.dummy);
   public static Sprite openeddoor = new Sprite(32 ,4,0,SpriteSheet.dummy);
   public static Sprite  closeddoor= new Sprite(32 ,5,0,SpriteSheet.dummy);
   
  
   //Spawn level Sprite : 
   
   
   public static Sprite spawn_skull = new Sprite(16 ,  0 , 1 ,   SpriteSheet.spawn_level); 
   public static Sprite spawn_blackland = new Sprite(16 , 0 , 0, SpriteSheet.spawn_level); 
   public static Sprite spawn_blackrock = new Sprite(16 , 1  , 1, SpriteSheet.spawn_level); 
   public static Sprite spawn_grassrock = new Sprite(16 , 2  , 0 ,  SpriteSheet.spawn_level); 
   public static Sprite spawn_brownLand = new Sprite(16 , 1 , 0,   SpriteSheet.spawn_level); 
   
   // player sprite :
   
   public static Sprite player_forward = new Sprite(32 , 0    ,5,SpriteSheet.tiles); 
   public static Sprite player_back = new Sprite(32 ,    2    ,5,SpriteSheet.tiles); 
   public static Sprite player_left = new Sprite(32 ,   3     ,5,SpriteSheet.tiles); 
   public static Sprite player_right = new Sprite(32 ,   1    ,5,SpriteSheet.tiles); 
   
   public static Sprite player_forward_1 = new Sprite(32 , 0    ,6,SpriteSheet.tiles); 
   public static Sprite player_forward_2 = new Sprite(32 , 0    ,7,SpriteSheet.tiles); 
   
   public static Sprite player_back_1 = new Sprite(32 , 2    ,6,SpriteSheet.tiles); 
   public static Sprite player_back_2 = new Sprite(32 , 2    ,7,SpriteSheet.tiles); 
   
   public static Sprite player_left_1 = new Sprite(32 , 3    ,6,SpriteSheet.tiles); 
   public static Sprite player_left_2 = new Sprite(32 , 3    ,7,SpriteSheet.tiles); 
   
   public static Sprite player_right_1 = new Sprite(32 , 1    ,6,SpriteSheet.tiles); 
   public static Sprite player_right_2 = new Sprite(32 , 1    ,7,SpriteSheet.tiles); 
   
   // Dummy sprite
   
   public static Sprite dummy_forward = new Sprite(32 , 0    ,5,SpriteSheet.dummy); 
   public static Sprite dummy_back = new Sprite(32 ,    2    ,5,SpriteSheet.dummy); 
   public static Sprite dummy_left = new Sprite(32 ,   3     ,5,SpriteSheet.dummy); 
   public static Sprite dummy_right = new Sprite(32 ,   1    ,5,SpriteSheet.dummy); 
   
   public static Sprite dummy_forward_1 = new Sprite(32 , 0    ,6,SpriteSheet.dummy); 
   public static Sprite dummy_forward_2 = new Sprite(32 , 0    ,7,SpriteSheet.dummy); 
   
   public static Sprite dummy_back_1 = new Sprite(32 , 2    ,6,SpriteSheet.dummy); 
   public static Sprite dummy_back_2 = new Sprite(32 , 2    ,7,SpriteSheet.dummy); 
   
   public static Sprite dummy_left_1 = new Sprite(32 , 3    ,6,SpriteSheet.dummy); 
   public static Sprite dummy_left_2 = new Sprite(32 , 3    ,7,SpriteSheet.dummy); 
   
   public static Sprite dummy_right_1 = new Sprite(32 , 1    ,6,SpriteSheet.dummy); 
   public static Sprite dummy_right_2 = new Sprite(32 , 1    ,7,SpriteSheet.dummy); 
   
   // Ghost Sprite
   
   
   public static Sprite ghost_forward = new Sprite(32 , 0    ,5,SpriteSheet.ghost); 
   public static Sprite ghost_back = new Sprite(32 ,    2    ,5,SpriteSheet.ghost); 
   public static Sprite ghost_left = new Sprite(32 ,   3     ,5,SpriteSheet.ghost); 
   public static Sprite ghost_right = new Sprite(32 ,   1    ,5,SpriteSheet.ghost); 
   
   public static Sprite ghost_forward_1 = new Sprite(32 , 0    ,6,SpriteSheet.ghost); 
   public static Sprite ghost_forward_2 = new Sprite(32 , 0    ,7,SpriteSheet.ghost); 
   
   public static Sprite ghost_back_1 = new Sprite(32 , 2    ,6,SpriteSheet.ghost); 
   public static Sprite ghost_back_2 = new Sprite(32 , 2    ,7,SpriteSheet.ghost); 
   
   public static Sprite ghost_left_1 = new Sprite(32 , 3    ,6,SpriteSheet.ghost); 
   public static Sprite ghost_left_2 = new Sprite(32 , 3    ,7,SpriteSheet.ghost); 
   
   public static Sprite ghost_right_1 = new Sprite(32 , 1    ,6,SpriteSheet.ghost); 
   public static Sprite ghost_right_2 = new Sprite(32 , 1    ,7,SpriteSheet.ghost); 
   
   
   // Projectile Sprite
   
   public static Sprite projectile = new Sprite(16 , 0 ,0,SpriteSheet.projectile);
   
   
   public Sprite (int size , int x, int y , SpriteSheet sheet){
		
	    SIZE = size   ;
	    pixels=new int [SIZE * SIZE];
	    this.x= x * size;                                    // converting sprite to pixel
	    this.y= y * size; 
	    this.sheet=sheet;
	    load();
	}
	
public Sprite ( int size , int colour){                          // sprite constructor for the void tile
	
	SIZE = size ;
	pixels= new  int[SIZE * SIZE];
	setColour(colour);
}

	private void setColour(int colour) {                        // set color  for the void tile
	for (int i = 0 ; i< SIZE*SIZE;i++){
		pixels[i]=colour;
	}
	
}

	public void load (){
		
		for (int y =0 ;y<SIZE;y++){
			for (int  x =0; x<SIZE;x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];  // 42   extracting single sprite   from sprite sheet
			}
		}
		
		
	}
}
