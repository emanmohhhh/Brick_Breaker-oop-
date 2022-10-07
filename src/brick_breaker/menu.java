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
import javax.swing.JPanel;

/**
 *
 * @author GenuinE
 */
public class menu {
  
    private Rectangle playButton = new Rectangle(frame.width/2-50,150,100,50);
    private Rectangle helpButton = new Rectangle(frame.width/2-50,250,100,50);
    private Rectangle quitButton = new Rectangle(frame.width/2-50,350,100,50);
    
    
    
    public void render (Graphics g){
        Graphics2D g2 =(Graphics2D)g;
        Font f= new Font("arial",Font.BOLD,50);
        g.setFont(f);
        g.setColor(Color.yellow);
        g.drawString("brick breaker", frame.width/2-150, 100);
        Font f1= new Font("arial",Font.BOLD,30);
        g.setFont(f1);
        g.drawString("play", playButton.x+19, playButton.y+30);
        g2.draw(playButton);
        g.drawString("help", helpButton.x+19, helpButton.y+30);
        g2.draw(helpButton);
        g.drawString("quit", quitButton.x+19, quitButton.y+30);
        g2.draw(quitButton);
        
    }
    
}
