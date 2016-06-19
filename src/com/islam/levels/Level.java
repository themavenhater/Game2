package com.islam.levels;


import com.islam.entities.Entity;
import com.islam.entities.mob.Dummy;
import com.islam.entities.mob.Ghost;
import com.islam.entities.mob.Items;
import com.islam.entities.mob.Player;
import com.islam.entities.projectile.Projectile;
import com.islam.game.Screen;
import com.islam.levels.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Level {
    public boolean restart = false ;                                                         // level class organize which tile need to be rendered
	protected int width , height;
	protected int tilesint[];
	protected static int[] tiles ;                        // store level tiles " colors of the level.png"
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Player> players = new ArrayList<Player>();
	private List<Dummy> monsters = new ArrayList<Dummy>();
	private List<Items> items = new ArrayList<Items>();
	public int score=0;
	public static Level spawn = new SpawnLevel();
	

	
	public Level(){                                                               //44 load level from text file
		loadLevel();
		
	}
	
	
	protected void loadLevel() {
		
		
	}


	protected void generateLevel (){                                                        // random levels
		
		
	}
	
	public void update(){                                                                // updating entties , positions ...etc
		
		for (int i=0; i<entities.size();i++){
		entities.get(i).update();
      	}
		
		 for (int i=0; i<projectiles.size();i++){	
				projectiles.get(i).update();
			}
		 
		 for (int i=0; i<players.size();i++){	
				players.get(i).update();
			}
		 
		 for (int i=0; i<monsters.size();i++){	
				monsters.get(i).update();
			}
		 for (int i=0; i<items.size();i++){	
				items.get(i).update();
			}
		 remove();
		}
	
	private void remove(){
		
		for (int i =0 ; i<entities.size();i++){
			if (entities.get(i).isRemoved()) entities.remove(i);
		}
		for (int i =0 ; i<projectiles.size();i++){
			if (projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		for (int i =0 ; i<players.size();i++){
			if (players.get(i).isRemoved()) players.remove(i);
		}
		for (int i =0 ; i<monsters.size();i++){
			if (monsters.get(i).isRemoved()) monsters.remove(i);
		}
		for (int i =0 ; i<items.size();i++){
			if (items.get(i).isRemoved()) items.remove(i);
		}
	}
	
	
	
	
	public List <Projectile> getProjectiles(){
		return projectiles;
	}
	
	public void time (){
		
	}
	
	public boolean tileCollision(int x , int y ,int xa , int ya, int size){                      //x and y the position of the entity
		
		boolean solid=false;
		
		for (int c = 0 ; c<10 ; c++){
		    int xt = ((x+xa) + c %  2* size / 16+5 )/16 ;
			int yt = ((y+ya) + c % 2*  size /16  )/16;
			if (getTile(xt,yt).solid()) solid = true;    // if the next place where we will be is solid make solid = true
		}
		
		return solid ;
	}
	
	
	public void render (int xScroll , int yScroll, Screen screen){
		screen.setOffset(xScroll,yScroll);                                                                           //48 detecting the corner ins , the surface that must be rendered in the screen
		int x0 = xScroll >> 4;
		int x1 = (xScroll +screen.width+ 16)>>4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll +screen.height + 16)>>4;
		
		for(int y= y0 ; y < y1;y++){
			for (int x = x0 ; x < x1;x++){
				
				getTile(x,y).render(x, y, screen);               //  get the tile and render it 
				
		}}  
		 for (int i=0; i<items.size();i++){
 			
 			items.get(i).render(screen);
 		}
		
		for (int i=0; i<entities.size();i++){
			
			entities.get(i).render(screen);
		}
		
        for (int i=0; i<projectiles.size();i++){
			
			projectiles.get(i).render(screen);
		}
        
          for (int i=0; i<players.size();i++){
			
			players.get(i).render(screen);
		}
          for (int i=0; i<monsters.size();i++){
  			
  			monsters.get(i).render(screen);
  		}
         
	}
	       
	public void add (Entity e ){
		e.init(this);
		 if (e instanceof Items) {items.add((Items)e);}
		 else if  (e instanceof Projectile) {projectiles.add((Projectile)e);}
		else if (e instanceof Player) {players.add((Player)e);}
		else if (e instanceof Dummy) {monsters.add((Dummy)e);}
		else if (e instanceof Ghost) {monsters.add((Dummy)e);}
		
		
		//else entities.add(e);
		
	}
	
	public void addProjectile(Projectile p){
		//e.init(this);
		//projectiles.add(p);
		
	}
	
	public Player getPlayersAt(int index){
		return players.get(index);
	}
	
     public List <Player> getPlayers(){
		return players;
	}
     
     public List <Items> getItems(){
 		return items;
 	}
     
     public List <Dummy> getDummys(){
 		return monsters;
 	}
     

    public Player getClientPlayer(){
	  return players.get(0);
   }
	
    public List<Entity> getEntities (Entity e , int radius){
    	List<Entity> result = new ArrayList<Entity>();
    	int ex=e.getX();
    	int ey=e.getY();
    	for (int i =0; i < entities.size();i++){
    		Entity entity = entities.get(i);
    		int x=entity.getX();
    		int y=entity.getY();
    		int dx= Math.abs(x-ex);
    		int dy= Math.abs(y-ey);
    		double distance = Math.sqrt((dx *dx )+(dy*dy));
    		if (distance<=radius) result.add(entity);
    	}
    	return result;
    }
    
    public List<Player> getPlayers(Entity e , int radius){
    	List<Player> result = new ArrayList<Player>();
    	int ex=e.getX();
    	int ey=e.getY();
    	for (int i =0; i < players.size();i++){
    		Player player = players.get(i);
    		int x=player.getX();
    		int y=player.getY();
    		int dx= Math.abs(x-ex);
    		int dy= Math.abs(y-ey);
    		double distance = Math.sqrt((dx *dx )+(dy*dy));
    		if (distance<=radius) result.add(player);
    		
    		
    	
    	
    	}
    	return result;
    }
	// blackland = 000000 , brown land = 7F3300 , skull 0C00FF , black rock= 404040  , grassrock 007F46;
	
	
	public Tile getTile (int x , int y){
		
		
		if (x<0 ||y<0 ||x>=width||y>=height)return Tile.voidTile;  // fixing out of bound exception
		if (tiles [x+y * width]==Tile.col_spawn_blackland)  return Tile.spawn_blackland;                                  // 49 get a tile to be rendered
		if (tiles [x+y * width]==Tile.col_spawn_blackrock) return Tile.spawn_blackrock;
		if (tiles [x+y * width]==Tile.col_spawn_brownland) return Tile.spawn_brownland;
		if (tiles [x+y * width]==Tile.col_spawn_grassrock) return Tile.spawn_grassrock;
		if (tiles [x+y * width]==Tile.col_spawn_skull) return Tile.spawn_skull;
		return Tile.voidTile;
		
	}
	
	
	
	
	
}
