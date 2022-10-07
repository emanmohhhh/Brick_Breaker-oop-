/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author GenuinE
 */
public class ball extends game {
    
   private double x;
   private double y;
   private double vx ;
   private double vy;
   private int size;
   private boolean lose;
   private BufferedImage ball;
   

  
    
    public ball(BufferedImage img){
        x = frame.width/2;
        y = frame.height-550;
        vx = 2;
        vy=3;
        size = 10;
        ball = img;
        lose = false;
        
    }
    
    public void tick(){
        x+=vx;
        y+=vy;
        
        
        if(x<0 || x>frame.width-size){
            vx=-vx;
        }
        else
            if(y<0 || y>frame.height)
                vy=-vy;
        
    }
    
    public void render(Graphics g){
        g.drawImage(ball, (int)x,(int) y, size, size, null);
        
        
    }
    
    
    public  Rectangle getRect(){
       return new Rectangle((int)x,(int)y,size,size);
        
    }
    
    
    public void setvy(double vy){
        this.vy=vy;
      
    }
    
    public void setvx(double vx){
    this.vx=vx;
}
     public double getvx(){
      return vx;
  }
     public double getvy(){
      return vy;
  }
      public void setx(double x){
      this.x=x;
  }
  
  public void sety(double y){
      this.y=y;
  }
  public double getx(){
      return x;
  }
  
  public double gety(){
      return y;
  }
  
  public void setsize(int size){
      this.size=size;
  }
  public int getsize(){
      return size;
  }
    public boolean lose(){
        
        if(y> frame.height)
            lose=true;
        
        return lose;
    }
     
}
