/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author GenuinE
 */
public class level_menu {
    
     private Rectangle level1 = new Rectangle(frame.width/2-50,150,100,50);
     private Rectangle level2= new Rectangle(frame.width/2-50,250,100,50);
     private Rectangle level3 = new Rectangle(frame.width/2-50,350,100,50);
     private Rectangle level4 = new Rectangle(frame.width/2-50,450,100,50);
    
    public void render (Graphics g){
        Graphics2D g2 =(Graphics2D)g;
        Font f= new Font("arial",Font.BOLD,50);
        g.setFont(f);
        g.setColor(Color.yellow);
        g.drawString("brick breaker", frame.width/2-150, 90);
        Font f1= new Font("arial",Font.BOLD,30);
        g.setFont(f1);
        g.drawString("level 1", level1.x+4, level1.y+30);
        g2.draw(level1);
        g.drawString("level 2", level2.x+4, level2.y+30);
        g2.draw(level2);
        g.drawString("level 3", level3.x+4, level3.y+30);
        g2.draw(level3);
        g.drawString("level 4", level4.x+4, level4.y+30);
        g2.draw(level4);
        
        
    }
}
