/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author GenuinE
 */
public class frame {
    
    public static int width = 920;
    public static int height = 570;
    
    private JFrame frame;
    private panel p;
   
    public frame(){
        frame = new JFrame("brick breaker");
        p = new panel();
        display();
     }
    
    
    public void display(){     
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(p);
        frame.setVisible(true);
        p.run();
        
            }
    
    
}

