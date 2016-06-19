package com.islam.game;

import java.util.Random;

import com.islam.entities.projectile.Projectile;
import com.islam.game.graphics.Sprite;
import com.islam.levels.tile.Tile;

                                //24  a class that will handle pixels on the screen

public class Screen {

	
	public int width ;
	public int height;
	public int [] pixels ;
	public int [] tiles = new int [64 * 64 ];                  // 33 making tiles tables , to put data in every tile on the screen
	private Random random = new Random();                      // 34 creating a random to fill tiles with random colors

	public int xOffset , yOffset ;
	
	public Screen(int width, int height) {
		this.width=width;
		this.height=height;
		pixels = new int [width* height];
		
		
	}
	
	
	public void clear (){                                               //29  Clear old positions of draw
		for (int i=0 ; i<pixels.length;i++){
			pixels[i]=0;
		}
	}
	
	

	
	public void renderTile(int xp , int yp , Tile tile){                                          
		
		xp-=xOffset;
		yp-=yOffset;
		for (int y=0 ; y<tile.sprite.SIZE;y++){
			int ya = y + yp ;
			for (int x=0 ; x<tile.sprite.SIZE;x++){
				int xa = x + xp ;
				if (xa <-tile.sprite.SIZE || xa>= width ||ya <0 || ya>= height) break;        // render only what you see in screen , if the tile is outside the edges stop
		        if (xa<0) xa=0;
				pixels[xa + ya * width ]=tile.sprite.pixels[x + y * tile.sprite.SIZE];
			} 
			
		
	}
}
	
	public void renderSprite(int xp , int yp , Sprite sprite){                                          
		
		xp-=xOffset;
		yp-=yOffset;
		for (int y=0 ; y<sprite.SIZE;y++){
			int ya = y + yp ;
			for (int x=0 ; x<sprite.SIZE;x++){
				int xa = x + xp ;
				if (xa <sprite.SIZE || xa>= width ||ya <0 || ya>= height) break;        // render only what you see in screen , if the tile is outside the edges stop
		        if (xa<0) xa=0;
		        
               int col =sprite.pixels[x + y * 16];
		        if (col != 0xffff00ff) 
				pixels[xa + ya * width ]=sprite.pixels[x + y * sprite.SIZE];
			} 
			
		
	}
}
	
	public void renderProjectileTile(int xp, int yp, Projectile p) {

	    xp -= xOffset;
	    yp -= yOffset;

	    for (int y = 0; y < p.sprite.SIZE; y++) {

	        int ya = y + yp;

	        for (int x = 0; x < p.sprite.SIZE; x++) {

	            int xa = x + xp;

	            if (xa < -p.sprite.SIZE || xa >= width || ya < 0 || ya >= height) {
	                break;
	            }

	            if (xa < 0) {
	                xa = 0;
	            }

	            int col =  p.sprite.pixels[x + y * p.sprite.SIZE];
	            if (col !=0xffff00ff )
	            pixels[xa + ya * width] = col;

	        }

	    }

	}
	
	public void renderMob(int xp , int yp , Sprite sprite){
		
		xp-=xOffset;
		yp-=yOffset;
		for (int y=0 ; y<32;y++){
			int ya = y + yp ;
			for (int x=0 ; x<32;x++){
				int xa = x + xp ;
				if (xa <-32 || xa>= width ||ya <0 || ya>= height) break;                            // render only what you see in screen , if the tile is outside the edges stop
		        if (xa<0) xa=0;
		        int col =sprite.pixels[x + y * 32];
		        
		        if (col != 0xffff00ff) 
				pixels[xa + ya * width ]=col;
			} 
			
		
	}
	}


	public void setOffset(int xOffset, int yOffset) {                                        // making the offset
		this.xOffset=xOffset;
		this.yOffset=yOffset;
		
	}
	}
