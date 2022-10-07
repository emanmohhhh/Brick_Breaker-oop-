/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author GenuinE
 */
public class enemy {
    
    private double x;
    private double y;
    
    private double vx;
    private double vy;
    
    private int width;
    private int height;
    
    private BufferedImage img;
    
    
    
    public enemy(BufferedImage img){
        x=frame.width/2;
        y=frame.height-330;
        
        vx=2;
        vy=2;
        
        width=150;
        height=80;
        this.img=img;
    }
    
    
    public void tick(){
        x+=vx;
        y+=vy;
        if(x<0 || x>frame.width-width){
            vx=-vx;
        }
        else
            if(y<0 || y>frame.height/2)
                vy=-vy;
        
        
        
    }
    
    public void render(Graphics g){
        
    g.drawImage(img, (int)x,(int) y, width, height,null);
  //  g.drawRect((int)x,(int) y, width, height);
    }
    
    public Rectangle getrec(){
        return new Rectangle((int)x,(int)y,width,height);
        
    }
    
    
    
    
    
    
}
