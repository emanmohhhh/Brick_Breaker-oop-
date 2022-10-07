/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author GenuinE
 */
public class brick extends game {
    
 
 //  boolean checkb;
   
  private int[][] map;
  
  private int brickheight;
  private int brickwidth;
  
  private int row;
  private int col;
  private int total_bricks;
  
  private Color color;
  
   
   
    
   
   public brick(int row, int col){
  
       brickwidth=20;
       brickheight=10;
       
       
       
       
    this.row=row;
    this.col=col;
    
    map = new int [row][col];
    total_bricks=0;
      
      
       
   
       
   }
   
   public void init(){
         
      for(int i=0;i<row;i++){
          for(int j=0;j<col;j++){
              

              if(panel.level==2 || panel.level==3){
          
              map[i][j]=3;
              }
              
              if(panel.level==1){
                  map[i][j]=1;}
              
          }
      }
      
      if(panel.level==3){
      
      for(int j=0;j<map[0].length;j++){
         map[2][j]=4;
         map[1][j]=5;
         map[3][j]=6;
      }
      }
   
      
       
      
    
          
       
   }
      
   public void tick(){
       
   }

       
public void render(Graphics g){
      
       for(int i=0;i<map.length;i++){
           for(int j=0;j<map[i].length;j++){
               if(map[i][j]>0){
                   switch(map[i][j]){
                       case 1:  color=Color.YELLOW;
                       break;
                       case 2:  color=Color.PINK;
                       break;
                       case 3 : color=Color.ORANGE;
                       break;
                       case 4: color=power.lifed;
                       break;
                       case 5: color=power.paddle;
                       break;
                       case 6: color=Color.BLUE;
                       break;
                            
                   }
                  
                  
                  
                      
                   
                   g.setColor(color);
                   g.fillRect(j*60+50, i*60+50, brickwidth, brickheight);
                   
           }
               
               
                    
                
                
               
                      
                
                      
                      
                     
                   
             
               }
           }
      }
       



public int[][] getarr(){
    return map;
}

public int getbrickwidth(){
    return brickwidth;
}

public int getbrickheight(){
    return brickheight;
}





public void setbrick(int i, int j, int value){
    map[i][j]= value;
}


public void hit(int i,int j){
    if(map[i][j]>3)
        map[i][j]=3;
    else
        map[i][j]--;
   
    if(map[i][j]<0){
        map[i][j]=0;
        
    }
}


public boolean win(){
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
           total_bricks+=map[i][j];
        }
    }
    if(total_bricks==0)
        return true;
    total_bricks=0;
    
    return false;
}



}
     
      
      
      
      
      
      
   
  
 
  

   
           
       
   
 
  
   
   
   
   
   

