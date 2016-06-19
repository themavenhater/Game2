package com.islam.levels.tile.spawn;

import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;
import com.islam.levels.tile.Tile;

public class SpawnRockTile extends Tile {

	public SpawnRockTile(Sprite sprite) {
		super(sprite);
		
	}                                                                       

	
    public void render (int x , int y , Screen screen){
		
		screen.renderTile(x<<4 , y<<4  , this);
		
	}
    
    public boolean solid(){
		
    	return true;
    }
    
}
