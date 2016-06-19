package com.islam.entities.projectile;

import java.util.List;

import com.islam.entities.Entity;
import com.islam.entities.mob.Dummy;
import com.islam.entities.mob.Player;
import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;

public  class Projectile extends Entity {

	
	
 
 protected int speed =2;
 public Sprite sprite;
 protected int dir=100 ;
 
 
	public Projectile(int x , int y , int dir ){
		
		sprite=Sprite.projectile;
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	
	
	public void render(Screen screen){
		
		screen.renderProjectileTile(x, y-8, this);
	}
	
	boolean gone = false ;
	
	public void update(){
		
		List<Player> players=level.getPlayers();
		
		 
	    
		if (players.size()>0){	
			Player player =players.get(0); 
		int bx = Math.abs(x-player.getX());
		int by = Math.abs(y-player.getY());
		 
	
		if (gone){
		if (by <=20 &&bx<=10) remove(); if( isRemoved()){ player.fired=true;} }
		
		 if (level.tileCollision(x, y, 2,  2, 8) && speed==2 ){
		    	speed = - 2;
		    	gone=true;
		    	
  	   }
		 
		 else if (level.tileCollision(x, y, 2, 2, 8) && speed==-2 ){
		    	speed = 2;
		    	gone=true;
		    	
	   }}
		move(); 
		
		// level.getProjectiles().remove(0);
	}
	
	
	protected void move(){
		
       
		 
		if (dir==0) { 
	    	y += -speed ;
	    }
	
		if (dir==1) {
			x += speed ;
		}
		
		if (dir==2) {
			y += speed ;
		}
		
		if (dir==3) {
			x += -speed ;
		}
		if (dir==4) {
			x += -speed ;
			y+= +speed;
		}
		if (dir==5) {
			x += +speed ;
			y+= +speed;
		}
		if (dir==6) {
			x += -speed ;
			y+= -speed;
		}
		if (dir==7) {
			x += +speed ;
			y+= -speed;
		}
		
		
		 
        
    	
    	  
       }
       
       
   
		
		
       
	}

