package com.islam.levels.tile;

import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;                                           // 47 creating tile of type Land

public class LandTile extends Tile {

	public LandTile(Sprite sprite) {
		super(sprite);
		
	}

	public void render (int x , int y , Screen screen){
		
		screen.renderTile(x<<4 , y<<4  , this);
		
	}
	
}
