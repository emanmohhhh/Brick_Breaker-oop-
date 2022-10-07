/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouse implements MouseListener{
   @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
       
        int mx = me.getX();
        int my = me.getY();
    
     
        if(mx>+frame.width/2-50 && mx<=frame.width/2+50){
            if(my >= 150 && my<=200){
                if(panel.s==panel.state.menu)
            
                        panel.s=panel.state.levels;
                else if(panel.s==panel.state.levels){
                   panel.level=1;
                    
                            panel.s=panel.state.game;}


            }
        }
        
        if(mx>+frame.width/2-50 && mx<=frame.width/2+50){
            if(my >= 250 && my<=300){
                if(panel.s==panel.state.levels){
                   panel.level=2;
                    
                            panel.s=panel.state.game;}
            }
        
      
        
        }
        
         if(mx>+frame.width/2-50 && mx<=frame.width/2+50){
            if(my >= 350 && my<=400){
                if(panel.s==panel.state.levels){
                   panel.level=3;
                    
                            panel.s=panel.state.game;}
            }
         }
              if(mx>+frame.width/2-50 && mx<=frame.width/2+50){
            if(my >= 450 && my<=500){
                if(panel.s==panel.state.levels){
                   
                    
                            panel.s=panel.state.enemy;}
            }
        
      
        
        }
     
         }
   
            
    

    

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
}
