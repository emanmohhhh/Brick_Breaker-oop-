/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author GenuinE
 */
public class power extends game {
   private int x;
   private int y;
   private double vy;
   private int num_brick;
   private int width,height;
   private boolean own;
   
   
    
   public static Color lifed = Color.red;
   
   public static Color paddle = Color.yellow;
   
   public static Color bullet = Color.BLUE;
   
   private Color color;
   
   
    
            
            
    
    public power(int x, int y,int num_brick, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.num_brick=num_brick;
        vy = 2;
        
        own=false;
        
        if(num_brick == 4)
            color = lifed;
        if(num_brick == 5)
            color = paddle;
        if(num_brick == 6)
            color = bullet;
    }
    
    public void render(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
        
    }
    public void tick(){
        y+=vy;
 
    }
    
    public int getx(){
        return x;
        
    }
    
    public void setx(int newx){
        x = newx;
    }
    
    
    public int gety(){
        return y;
        
    }
    
    public void sety(int newy){
        y = newy;
    }
    
    public double getdy(){
    return vy;
}
    
    public void setdy(int newdy){
        vy = newdy;
    }
    
    public int getnum_brick(){
        return num_brick;
    }
   
    public boolean getown(){
        return own;
            
    }
    
    public void setown(boolean own){
        this.own=own;
    }
    
    public Color getcolor(){
        return color;
    }
  
    public Rectangle getrect(){
        return new Rectangle(x,y,width,height);
        
    }
    

    
    
    
}
