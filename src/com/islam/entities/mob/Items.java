package com.islam.entities.mob;

import java.util.List;

import com.islam.entities.Entity;
import com.islam.entities.projectile.Projectile;
import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;
import com.islam.levels.Level;



public class Items extends  Mob {
	


	
		public Items (int x , int y , Sprite sprite){
		this.x = x<< 4;
		this.y = y<< 4;
        this.sprite=sprite;
      
       this.level=level;
	}
		

	
	
	public void update() {
		List<Player> players=level.getPlayers();
		List<Items> items=level.getItems();
		if (players.size()>0) {
	     Player player = players.get(0);
	     int gx = Math.abs(x-player.getX());
			int gy = Math.abs(y-player.getY());
			if ( gy <=14 && gx<=12 && sprite!=Sprite.openeddoor && sprite!=Sprite.closeddoor){ remove();level.score+=150;  }

		   if (items.size()==1){sprite=Sprite.openeddoor;}
		
		}

		
		
	}

	
	public void render(Screen screen) {
	
		if (sprite == Sprite.openeddoor ||sprite == Sprite.closeddoor) {screen.renderMob(x, y, sprite);}
		else screen.renderSprite(x-8, y-8, sprite);
	
	}


}