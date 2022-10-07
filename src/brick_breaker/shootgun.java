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

/**
 *
 * @author GenuinE
 */
public class shootgun extends game{
    

     private double bulletx;
     private double bullety;
     private BufferedImage img;
     private boolean used;
     private boolean ispaddlebig;
        public shootgun(double x,double y,BufferedImage img){
            bulletx=x;
            bullety =y;
            this.img=img;
            used=false;
            ispaddlebig=false;
       
           
           
            
            
           
            
        }
        
        
        public void tick(){
            if(!used){
                bullety--;}
        }
       
        
        public void render(Graphics g){
               if(!used){
        
             if(panel.checkp){
                g.drawImage(img,(int) bulletx+60,(int) bullety+10, 55, 43, null);
                ispaddlebig=true;
             }
             else
             g.drawImage(img,(int) bulletx+30,(int) bullety+10, 55, 43, null);
               }
         }
        
        public Rectangle getrec(){
            if(ispaddlebig){
                return new Rectangle((int)bulletx+60,(int)bullety+10,40,30);
            }
            else
            return new Rectangle((int)bulletx+30,(int)bullety+10,40,30);
        }
        
        public double getbullety(){
            return bullety;
        }
        
        public void setbullety(double bullety){
            this.bullety=bullety;
            
        }
        
        public boolean getused(){
            return used;
        }
        
        public void setused(boolean used){
            this.used=used;
        }
         



}

        
        
    
    
    

