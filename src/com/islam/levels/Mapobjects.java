package com.islam.levels;

import com.islam.entities.mob.Dummy;
import com.islam.entities.mob.Ghost;
import com.islam.entities.mob.Items;
import com.islam.game.graphics.Sprite;

public class Mapobjects {
    private  boolean turn=true;
    private int next=0;
    public String string;
    public int aa=0,s=0;
    public static int[] coupe;

    public Mapobjects(String string ){

        this.string=string;
        coupe =new int[40];
        String nounou = "10-6-4-14-4-17-9-11-9-5-11-8-13-15-14-19-15-11-16-5-16-5-12-4-15-9-9-9-5-9-9-14";
        System.out.println(nounou);
        for (String retval : nounou.split("-")) {
            coupe[s] = Integer.parseInt(retval);
            s++;
        }

        //System.out.println(coupe[1]);
    }


    public Mapobjects(Level level){


        for (int i=0 ; i<coupe.length;i++){
            //System.out.println(coupe[i]);
            //int a= Integer.parseInt(String.valueOf(coupe[0]));
        }
        for (int i=0; i<=(coupe[0])*2/2 ;i+=4){
           level.add(new Ghost(coupe[i+1],coupe[i+2], Sprite.ghost_back));
           level.add(new Dummy(coupe[i+3],coupe[i+4], Sprite.dummy_back));
            //System.out.println(coupe[i+1]+"---"+coupe[i+2]);
            //System.out.println(coupe[i+3]+"---"+coupe[i+4]);
        }
        System.out.println((coupe[0]*2)+2);
        System.out.println(coupe[coupe[0]*2]);

       for (int i=(coupe[0]*2)+1; i<= coupe[coupe[0]*2]+(coupe[(coupe[0]*2)+1])*2 /2 ;i+=2){
           level.add(new Items(coupe[i+1],coupe[i+2], Sprite.bag));
           level.add(new Items(coupe[i+2],coupe[i+3], Sprite.bomb));
           System.out.println(coupe[i+1]+"---"+coupe[i+2]);
           System.out.println("aaaaaaaaaaaaaaaa");
       }
        //System.out.println("aaaaaaaa");
       // for (int i=(coupe[coupe[0]*2])+1; i< coupe[coupe[coupe[0]]*2];i+=2){
         //   System.out.println(coupe[i+1]+"---"+coupe[i+2]);
        //}

    }

}
