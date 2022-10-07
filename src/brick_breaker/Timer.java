/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.util.Date;

/**
 *
 * @author GenuinE
 */
public class Timer {
    
   private Date start;
   private long msecond;
   private long second;
   private boolean used;
    
    public Timer(){
        used = false;
    }
    
    public void settime(){
        start= new Date();
    }
    
    public long getTime(){
        if(used){
            Date now = new Date();
            msecond=now.getTime()-start.getTime();
            second = msecond/1000;
        }
        
        return second;
    }
    
    
    public boolean getused(){
        return used;
    }
    
    public void setused(boolean used){
        this.used=used;
        
    }
    
    
    
    
}
