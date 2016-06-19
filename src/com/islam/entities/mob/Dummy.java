package com.islam.entities.mob;

import com.islam.entities.projectile.Projectile;
import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;

import java.util.List;



public class Dummy extends  Mob {
	

	private int time;
	protected int xa =0 ; protected int ya =0;
	public boolean walking = false ;
	 int anim=0;
	 
	
		public Dummy (int x , int y , Sprite sprite){
		this.x = x<< 4;
		this.y = y<< 4;
       this.sprite=sprite;
    
      
	}
		
		private void move (){
			xa=0;
			ya=0;
			
		List<Player> players=level.getPlayers(this,80);
		List<Projectile> projectiles= level.getProjectiles();
		
		
	 

		
		if (players.size()>0)	{
			Player player =players.get(0);
			int bx = Math.abs(x-player.getX());
			int ay = Math.abs(y-player.getY());
			 
		 if (ay <= 16 && bx <=16 ) { player.remove(); System.exit(0);}
		
		 
		  if (x<( player.getX())) xa++;
		 if (x>( player.getX()) )xa--;
		 if (y>( player.getY()) )ya--;
		 if (y<( player.getY())) ya++;
			
		 Math.abs(x-player.getX());
		}
		
				
			if ( xa !=0 || ya != 0){
				move(xa,ya);                                  //animate the player
				walking = true;
			}else walking = false;
		}
	
	
	public void update() {
	
		List<Player> players=level.getPlayers();
		List<Projectile> projectiles= level.getProjectiles();
		if (players.size()>0) {Player player = players.get(0);
		if (projectiles.size()>0)	{
			  Projectile projectile= projectiles.get(0);		
	          int gx = Math.abs(x-projectile.getX());
			int gy = Math.abs(y-projectile.getY());
			if ( gy <=16 && gx<=16 ) { level.restart=true; projectile.remove(); remove(); level.score+=500; if( projectile.isRemoved()){ player.fired=true;} }

		}}
	
		move();
		if (anim <75000 ) anim++;
		
		
	}

	
	public void render(Screen screen) {
		if (dir == 0){
			sprite=sprite.dummy_forward;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.dummy_forward_1;
				} else sprite=sprite.dummy_forward_2;
			}
		}
		
		else if (dir == 1){                         //right
			sprite=sprite.dummy_right;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.dummy_right_1;
				} else sprite=sprite.dummy_right_2;  
			}
		}
		
		else if (dir == 2){                         //backward
			sprite=sprite.dummy_back;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.dummy_back_1;
				} else sprite=sprite.dummy_back_2;  
			}
		}
		
		else if (dir == 3){                          //left
			sprite=sprite.dummy_left;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.dummy_left_1;
				} else sprite=sprite.dummy_left_2;  
			}
		}
		
		screen.renderMob(x-16, y-16, sprite);
	
	}


}