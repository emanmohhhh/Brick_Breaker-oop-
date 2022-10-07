/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author GenuinE
 */
public class paddle extends game {
    

  private  double x;
  private double y;
  private int widthtemp;
  private int paddlewidth;
  private int paddleheight;
   
  Timer paddletime = new Timer();
  BufferedImage img;
    
    
    public paddle(BufferedImage img){
        x=frame.width/2;
        y =frame.height-80;
        paddlewidth=90;
        paddleheight=20;
        widthtemp=paddlewidth;
        this.img=img;
        
    }
    
    public void tick(){
     if(paddletime.getTime()>=10){
         paddlewidth=widthtemp;
        paddletime.setused(false);
      
         panel.checkp=false;
         
     }   
    }
    
    public void render(Graphics g){
        
     
       g.drawImage(img,(int) x, (int)y, paddlewidth, paddleheight, null);
        
        
    }
    
    
   
    
     public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,paddlewidth,paddleheight);
        
    }
     
     
     
     public void moveright(){
         x+=50;
         
     }   
     public void moveleft(){
         x-=50;
     }
     
     
     
     public void setpaddlewidth(int width){
         if(!paddletime.getused()){
         paddlewidth=width;
         paddletime.settime();
         //paddletime.used=true;
         paddletime.setused(true);
         
         }
     }
     
     
   
     
     public double getx(){
         return x;
         
     }
     
     public double gety(){
         return y;
     }
         public void setx(double x){
         this.x=x;
     }
     
     
     public void sety(double y){
         this.y=y;
     }
     public int getpaddlewidth(){
         return paddlewidth;
     }
     
     public int getpaddleheight(){
         return paddleheight;
     }
     
     public void setpaddleheight(int paddleheight){
         this.paddleheight=paddleheight;
         
     }
 
     
     
     
     
     
     
    
}
