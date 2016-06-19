package com.islam.entities.mob;

import java.util.ArrayList;
import java.util.List;

import com.islam.entities.Entity;
import com.islam.entities.projectile.Projectile;
import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;

public  class Mob extends Entity {                            // 52 creating mobs
 
	
	public int px;
	public int py ;
	
	protected Sprite sprite ;
	protected int dir=2;                                                          
	protected boolean moving = false ;
	
	public void move (int xa , int ya){
		
		if (xa !=0 && ya != 0) { 
			move(xa ,0);                         // sliding in case of collision
			move(0 ,ya);
			return;
		}
		
		if (xa>0) dir =1;	                                         /// direction of the mob 
		if (xa<0) dir =3;	
		if (ya>0) dir =2;	
		if (ya<0) dir =0;	
		
		if (!collision(xa,  ya)){                                   // we only can move if there is no collision
	
		x+=xa;
		y+=ya;
		}
	}
	
	
	public  void  update (){
		
	}
		
	
	
	public void shoot(int x , int y , int dir){
		
		Projectile p = new  Projectile (x , y ,  dir);
		
		if (level.getProjectiles() != null){
		level.add(p); }
		//level.getProjectiles().remove(0); to remmove in collisison
	
		
	}
	
	public boolean collision(int xa , int ya){
		
		boolean solid=false;
		
		for (int c = 0 ; c<4 ; c++){
		   int xt = ((x+xa) + c % 2* 12 -7)/16;
			int yt = ((y+ya) + c / 2*12 +3)/16;
			if (level.getTile(xt,yt).solid()) solid = true;    // if the next place where we will be is solid make solid = true
		}
		
		return solid ;
	}
	
	
	public  void render(Screen screen){
		
	}
		
	
}

