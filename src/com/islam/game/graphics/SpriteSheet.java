package com.islam.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path ;                                        // 41 loading images and  transform it to pixels and store it in array
	public final int SIZE;
	public int pixels [];
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/lo.png",256);
	public static SpriteSheet spawn_level = new SpriteSheet("/textures/spawnlevel.png",48);
	public static SpriteSheet projectile = new SpriteSheet("/textures/projectile.png",48);
	public static SpriteSheet dummy = new SpriteSheet("/textures/dummy.png",256);
	public static SpriteSheet ghost = new SpriteSheet("/textures/ghost.png",256);
	
	public SpriteSheet(String path , int size){
		
		this.path=path;
		SIZE=size;
		pixels=new int [SIZE  * SIZE];
		load();
	}
	
	private void load (){
		
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w=image.getWidth();
			int h=image.getHeight();
			image.getRGB(0, 0, w, h,pixels, 0, w);
		} catch (IOException e) {
			System.out.println("error");
		}
	}
	
}
