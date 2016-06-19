package com.islam.levels.tile.spawn;

import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;
import com.islam.levels.tile.Tile;

public class SpawnLandTile extends Tile {

	public SpawnLandTile(Sprite sprite) {
		super(sprite);
		
	}

	
public void render (int x , int y , Screen screen){
		
		screen.renderTile(x*16, y*16  , this);
		
	}
}
