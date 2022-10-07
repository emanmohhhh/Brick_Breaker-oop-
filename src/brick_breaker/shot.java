/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author GenuinE
 */
public class shot extends game {
     
    public ArrayList<shootgun> shoot;
    
    public shot(){
        shoot= new ArrayList<shootgun>();
    }
    
    public void tick(){
        for(int i=0;i<shoot.size();i++){
            shoot.get(i).tick();
    
        }
    }
    
    public void render(Graphics g){
        
        
        for(int i=0;i<shoot.size();i++){
            shoot.get(i).render(g);
            
            
        
    }
        
    }
    
public void addbullet(shootgun block){
    shoot.add(block);
    
}






    
}
