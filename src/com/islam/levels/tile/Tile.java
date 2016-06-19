package com.islam.levels.tile;

import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;
import com.islam.levels.tile.spawn.SpawnLandTile;
import com.islam.levels.tile.spawn.SpawnRockTile;

public class Tile {

	
	public int x ,y ;                                            // tile it what gives the command to render
	public Sprite sprite ;
	
	public static Tile land = new LandTile(Sprite.land);                             // 47 creating tile of type landtile
	public static Tile rock = new Rock(Sprite.rock);                             // 47 creating tile of type landtile
	public static Tile flower = new Flower(Sprite.flower);                             // 47 creating tile of type landtile
	public static Tile voidTile = new VoidTile(Sprite.voidSprite); 
	
	
	// Spawn tiles 
	
	public static Tile spawn_blackland = new SpawnLandTile(Sprite.spawn_blackland);
	public static Tile spawn_skull = new SpawnRockTile(Sprite.spawn_skull);
	public static Tile spawn_blackrock = new SpawnRockTile(Sprite.spawn_blackrock);
	public static Tile spawn_brownland = new SpawnLandTile(Sprite.spawn_brownLand);
	public static Tile spawn_grassrock = new SpawnLandTile(Sprite.spawn_grassrock);
	
	
	public static final int col_spawn_blackland = -16777216;
    public static final int col_spawn_skull = -15990529;
    public static final int col_spawn_blackrock = -12566464;
    public static final int col_spawn_brownland = -8441088;
    public static final int col_spawn_grassrock = -16744634;
	
    		// blackland = 000000 , brown land = 7F3300 , skull 0C00FF , black rock= 404040  , grassrock 007F46;
	
    
    
    public Tile (Sprite sprite){
		
		this.sprite=sprite;
		
	}
	
    
    
	public void render (int x , int y , Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
}
