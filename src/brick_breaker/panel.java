/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick_breaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;

/**
 *
 * @author GenuinE
 */
public class panel extends JPanel {

    
    private String username;
    private int user_score;
    private String password;
    
    
    
    
    
    
        
    public static enum state{
        menu,game,levels,log,enemy
    };
    
    
   public static state s=state.log;
   public static int level;
    
  
    
 private BufferedImage background_image;
 private BufferedImage bullet_image;
 private BufferedImage paddle_image;
 private BufferedImage enemy_image;
    
 private boolean running;
    
    
    
    private ball b;
    private paddle p;
    private brick bricks;
    private power[] powerup;
    private shot paddle_shot;
    
    private int score;
    private int life;
    
   public static boolean checkp;
   
  private boolean in_game;
 
   private boolean checkuser;
   private boolean log;
    
    
 private menu menu_main = new menu();
 private level_menu menu_level = new level_menu();
 
 private int bullet;
 
 private  boolean map;
 
 private int power_num ;
 
 private enemy enemy_level;
 
 private int enemy_life;

    
    
  
   
    
    public panel(){
   checkuser=false;
   log=false;
   map=false;
   level=0;
   running=true;
 
    init();
        this.setFocusable(true);
        this.requestFocus();
        
        this.addMouseListener(new mouse());
        
 
       
       
     
       
            
     
        
        this.addKeyListener(new KeyListener(){
          
              
           
            
            public void keyTyped(KeyEvent ke) {
            
                  

                
                
                
                
                        
            }

            @Override
            public void keyPressed(KeyEvent ke) {
           
           if(ke.getKeyCode()==KeyEvent.VK_RIGHT){
                    if(p.getx()>=frame.width-p.getpaddlewidth())
                       // p.setx(fr)=frame.width-p.paddlewidth;
                       p.setx(frame.width-p.getpaddlewidth());
                    else
                        p.moveright();
                 
                    }
           
           if(ke.getKeyCode()==KeyEvent.VK_LEFT){
               
               if(p.getx()<=0)
                   //p.x=0;
                 p.setx(0);
               else
                   p.moveleft();
               
           }
           
             if(ke.getKeyCode()==KeyEvent.VK_SPACE ){
             
                      
                      
      
                   if(bullet>0){
                  
                 paddle_shot.addbullet(new shootgun(p.getx(),p.gety(),bullet_image));
                 bullet--;
                   }
                   if(s==state.enemy){
              paddle_shot.addbullet(new shootgun(p.getx(),p.gety(),bullet_image));
             }
                }
             
             if(ke.getKeyCode()==KeyEvent.VK_ENTER){
                if(!in_game){
                    
        
                 init();
                 map=false;
                    
                  
                  
                  
                    
                }
             }
            
             
            
            
            }
            @Override
            public void keyReleased(KeyEvent ke){
             
                
                         
                   
            
                
                             
                   
            }              
                
         
                 
            
         });
   
                }
    
        public void check_user(String username, String password){
      
          try {
              Class.forName("com.mysql.jdbc.Driver");
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
          }
{
                try {
                    
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/brick_breaker", "root", "Root1");
                    Statement stmt = c.createStatement();
                    ResultSet rs =stmt.executeQuery("select password,score from users where username='"+username+"'");
                    if(rs.next()){
                      user_score=rs.getInt("score");
                      String pass = rs.getString("password");
                      
                        if(pass.equals(password)){
        
                            checkuser=true;
                            c.close();
                            stmt.close();
                            rs.close();
                        }
                   }
                  
                     } catch (SQLException ex) {
                    Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
              }
}      
  
    }
    
   
   
     public void update_score(int score){
      
          try {
              Class.forName("com.mysql.jdbc.Driver");
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
          }
{
                try {
                    
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/brick_breaker", "root", "Root1");
                   
                    
                
                      Statement stmt=c.createStatement();
                      String sql="update users set score='"+score+"'where username='"+username+"'";
                      stmt.executeUpdate(sql);
                      
                      
    
                         
                          
                            c.close();
                            stmt.close();
                            
                        
                  
                     } catch (SQLException ex) {
                    Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
              }
}      
  
    }
    
    
    
    
    
    
    
    
    
    public void log(){
        
        log=true;
        this.setLayout(null);
        JLabel label = new JLabel("username: ");

        label.setBounds(frame.width/2-40, 50, 80,50);
        label.setForeground(Color.yellow);
        this.add(label);
        
        JTextField userText = new JTextField(20);
        userText.setBounds(frame.width/2-40,90,80,25);
        this.add(userText);
        
        JLabel label2 = new JLabel("password:");
        label2.setBounds(frame.width/2-40, 120 ,90, 80);
        label2.setForeground(Color.yellow);
        this.add(label2);
        
        
        JPasswordField userText2 = new JPasswordField(20);
        userText2.setBounds(frame.width/2-40,180,80,25);
        this.add(userText2);
       
        
        JButton button = new JButton("login");
        button.setBounds(frame.width/2-40,230,80,25);
        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            username = userText.getText();
            password = userText2.getText();
            check_user(username,password);
                System.out.println(checkuser);
            }
        });
        
  
               }
    
    
    public void init(){
        
        
        in_game=true;
        srcs();
        p = new paddle(paddle_image);
        b = new ball(ball_image);
       enemy_level=new enemy(enemy_image);
        bricks = new brick(4,14);
        
   
     
        score=0;
        life = 3;
        
     
        
        powerup = new power[100];
        
        power_num=0;
        bullet=0;
        checkp=false;
        paddle_shot=new shot();
        enemy_life=25;
        
    }
    
    private BufferedImage ball_image;
    
   
   
    public void srcs(){
       
        try {
          
            paddle_image = ImageIO.read(this.getClass().getResourceAsStream("srcs/paddle.png"));
                        ball_image = ImageIO.read(this.getClass().getResourceAsStream("srcs/ball.png"));
             background_image = ImageIO.read(this.getClass().getResourceAsStream("srcs/background.jpg"));
            bullet_image = ImageIO.read(this.getClass().getResourceAsStream("srcs/bullett.png"));
            enemy_image = ImageIO.read(this.getClass().getResourceAsStream("srcs/enemy.gif"));


           
        } catch (IOException ex) {
            Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
        }
               
       
    }
    
    
    
    public void checkcoll(){
        
        
        Rectangle paddle = p.getRect();
        Rectangle ball = b.getRect();
        Rectangle enemy=enemy_level.getrec();
        
        for(int i=0;i<power_num;i++){
            Rectangle pp = powerup[i].getrect();
            if(pp.intersects(paddle))
                if(!powerup[i].getown()){
                   if(powerup[i].getcolor()==Color.red){
                     life--;}
                   else if(powerup[i].getcolor()==Color.yellow){
                   p.setpaddlewidth(p.getpaddlewidth()+100);
                   checkp=true;
                   
                   }
                   else if(powerup[i].getcolor()==Color.BLUE){
                       bullet+=10;
                       
                   }
                    powerup[i].setown(true);
                 
                }
                  
            
                    
        }
        
        
        
        
       
        if(ball.intersects(paddle))
            b.setvy(-b.getvy());
        
       
    
       
        
        for(int i=0;i<bricks.getarr().length;i++){
            for(int j=0;j<bricks.getarr()[i].length;j++){
                int c = bricks.getarr()[i][j];
                if(c>0){
                    int width = bricks.getbrickwidth();
                    int height = bricks.getbrickheight();
                    int x = j*60+50;
                    int y = i*60+50;
                    double brickleft, brickright, bricktop,brickbottom;
                    double ballleft,ballright,balltop,ballbottom;
                    brickleft=x;
                    brickright=x+width;
                    brickbottom=y+height;
                    bricktop=y;
                    
                    ballleft=b.getx()-b.getsize();
                    ballright=b.getx()+b.getsize();
                    ballbottom=b.gety()+b.getsize();
                    balltop=b.getvy()-b.getsize();
                    
                    
                    
                Rectangle the_brick = new Rectangle(x,y,width,height);
                
                for(int g=0;g<paddle_shot.shoot.size();g++){
                    Rectangle bullet = paddle_shot.shoot.get(g).getrec();
                    if(bullet.intersects(the_brick)){
                        if(bricks.getarr()[i][j]>3){
         
          
                 generatepower(x,y,c ,width ,height );
                  bricks.setbrick(i, j, 3);
                  paddle_shot.shoot.get(g).setused(true);

        paddle_shot.shoot.get(g).setbullety(-paddle_shot.shoot.get(g).getbullety());

                  
                    
                                 
                     
                       
                      
                 } 
 
                                        
                   else{
                      
                  bricks.hit(i, j);
                  score+=5;
                  paddle_shot.shoot.get(g).setbullety(-paddle_shot.shoot.get(g).getbullety());
                  paddle_shot.shoot.get(g).setused(true);
                  
                  
                    
                   }
                        
                    
                }
                }
                if(ball.intersects(the_brick)){
                 if(bricks.getarr()[i][j]>3){
         
          
                 
                  generatepower(x,y,c,width,height);
                  bricks.setbrick(i, j, 3);
                  
                  
                  
                    
                                 
                     
                      
                      
                 } 
 
                                        
                   else{
              
                       bricks.hit(i, j);
                   
                     
                  
                    score+=5;
                    
                   
                    
                   }
                
                 if(ballright>=brickleft||ballleft<=brickright){
                     if(balltop>=brickbottom||ballbottom<=bricktop){
      
                         b.setvy(-b.getvy());
                         b.setvx(-b.getvx());
                     }
                     else{
                         b.setvy(-b.getvy());
                     }
                 }
                 
                 else
                     b.setvx(-b.getvx());
                 
                
                
                
                }           
                    
                    

                    
                }
                
                    
            }
        
    }
    
              for(int g=0;g<paddle_shot.shoot.size();g++){
                    Rectangle bullet = paddle_shot.shoot.get(g).getrec();
                    if(bullet.intersects(enemy)){
                        paddle_shot.shoot.get(g).setused(true);
                        paddle_shot.shoot.get(g).setbullety(-paddle_shot.shoot.get(g).getbullety());
                        enemy_life--;
                        
                        
                    }
     }
     
    }
        
    
    
        
                
                    
            
              
                
                
           
        
    
    
    public void tick(){
        if(s==state.game){
        checkcoll();
        
        b.tick();
        p.tick();
        
         
         for(int i=0;i<power_num;i++){
             powerup[i].tick();
         }
         
        } 
        if(s==state.enemy){
            p.tick();
            enemy_level.tick();
            checkcoll();
        }
      
        
        paddle_shot.tick();
        
 
          
         }  
      

        
     
    public void render(){
        
        repaint();
      
        
    }
    public void run(){
        
        
           while(running){
                if(in_game){
               
                    
                    tick();
                    repaint();
                    
                }
               try{     
                    Thread.sleep(9);
                } catch (InterruptedException ex) {
                    Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
      
            
}
    
  
    
    

    @Override
    protected void paintComponent(Graphics g) {
        
        if(level==1||level==2){
            life=1;
        }
       g.drawImage(background_image, 0, 0, frame.width, frame.height ,null);
        if(s==state.game){
            if(!map){
            
        bricks.init();
            map=true;}
            
            
        b.render(g);
        p.render(g);
        
             
             for(int i=0;i<power_num;i++){
                 powerup[i].render(g);
             }
             
             bricks.render(g);
         
         g.setColor(Color.white);
         g.drawString("Score: "+score, 20, 20);
         
         g.setColor(Color.yellow);
         g.drawString("Life: "+life, frame.width-65, 20);
         
         g.setColor(Color.white);
         g.drawString("bullet: "+bullet, frame.width/2, 20);
         
         if(b.lose()||life==0){
             g.setColor(Color.red);
             
            
            g.setFont(new Font("Serif",Font.BOLD,50));
           
            g.drawString("Game Over",frame.width/2-110, frame.height/2-50);
            g.drawString("Restart: Enter",frame.width/2-110, frame.height/2-50+70);
            // running = false;
             in_game=false;
             
             if(score>user_score)
                 update_score(score);
          
                 
     
             
         }
         
         if(bricks.win()){
             g.setColor(Color.red);
             
            
            g.setFont(new Font("Serif",Font.BOLD,50));
           
            g.drawString("winner",frame.width/2-110, frame.height/2-50);
            in_game=false;
         }
    
 
         
   
     
     paddle_shot.render(g);}
        else if(s== state.menu){
            g.setColor(Color.white);
            g.drawString("Username: "+username, 10, 20);
              
            g.setColor(Color.white);
            g.drawString("High Score: "+user_score, frame.width-95, 20);
               menu_main.render(g);
               
                
            
        }
        
        else if(s==state.levels){
            menu_level.render(g);
        }
        
        else if(s==state.log){
            if(!log){
            
            log();}
     if(checkuser){
        this.removeAll();
        s =state.menu;
    }    
     
        
     
    }
        if(s==state.enemy){
            g.setColor(Color.white);
         g.drawString("enemy_life: "+enemy_life, 20, 20);
            p.render(g);
            enemy_level.render(g);
              paddle_shot.render(g);
        }
        if(enemy_life==0){
            
           in_game=false;
            g.setFont(new Font("Serif",Font.BOLD,50));
           
            g.drawString("winner",frame.width/2-110, frame.height/2-50);
        }
    
    }
    
 
    
 
 

    
    
    
    
    
    
    
    
    

    public void generatepower(int x , int y , int num, int width, int height){
         powerup[power_num]=new power(x,y,num,width,height);
         power_num++;
    }
    
   
    
   
    
    
}
