package com.islam.entities;

import com.islam.game.Screen;
import com.islam.levels.Level;

import java.util.Random;

public  class Entity {

	
	
	
	protected int x, y ;                                          // 51 creating entitis , abstract because it's a template 
	public boolean removed =false ;
	protected Level level ;
	protected final Random random = new Random();
	
	public  void update (){
		
	}
		
	
	
	public void render (Screen screen){
		
	}
	public Level getlevel (){ return level; }
	
	public void remove (){
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
		
	}
	
	public void init (Level level){
		this.level=level;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
