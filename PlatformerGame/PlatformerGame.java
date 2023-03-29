import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
/**
 * [FinalProjectGame.java]
 * @author terrain Ren
 * @version june 2022
 * 2D platformer game
 */
public class PlatformerGame {

    int bulletTimer = 0;
    JFrame gameFrame;
    GamePanel gamePanel;
    MyKeyListener keyListener; 
    int level = 1;
    int gameState = 0;
    Player player = new Player(200, 750, 50 , 50);
    Map m = new Map(level);
    Rectangle test  = new Rectangle(300, 100, 100, 2000); 
    BufferedImage menu;
    BufferedImage helpScreen;
    
    
//------------------------------------------------------------------------------
    PlatformerGame(){
        gameFrame = new JFrame("Game Window");   
        gameFrame.setSize(1600,900);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        
        gamePanel = new GamePanel();     
        gameFrame.add(gamePanel); 
        
        keyListener = new MyKeyListener();
        gamePanel.addKeyListener(keyListener);        
        
        gameFrame.setVisible(true);    
    }
//------------------------------------------------------------------------------  
   
    public void run(){
        while (true) {
            

            if (gameState == 0){
                gameFrame.repaint();
            }
            
            if (gameState == 2){
                gameFrame.repaint();
            }
            
            if (gameState == 1){
             try  {Thread.sleep(10);} catch(Exception e){}
                //if player dies, resets their position and the map
                if (player.getIsAlive() == false){
                    player = new Player(200, 750, 50 , 50);
                    m = new Map(level);
                }
                
                 //if player reaches the goal, resets their position and changes the map
                if (player.getLevelComplete() == true){
                    level = level + 1;
                    player = new Player(50, 50, 50 , 50);
                    m = new Map(level);
                    
                    if (level > 3){
                        gameState = 0;
   
                    }
                }
               

                player.move(m.getTerrainList());
                player.setBox();
                
                
                for (int i= 0; i < m.getTerrainList().size(); i++){
                    if (m.getTerrainList().get(i) instanceof Cannon){
                        ((Cannon) m.getTerrainList().get(i)).shoot(m);
                    }
                }
                
                for (int i= 0; i < m.getHazardList().size(); i++){        //checks to see if player is collding with any hazards, and activates their effects if a collision occurs 
                    if (player.collisionCheck(m.getHazardList().get(i).getBox()) == true){
                        m.getHazardList().get(i).collisionEvent(player);
                    }
    
                    if (m.getHazardList().get(i) instanceof Bullet){
                        
                        //moves the bullet
                        ((Bullet)m.getHazardList().get(i)).move();
                        m.getHazardList().get(i).setBox();
                        
                        //deletes the bullet if it collides with any terrain
                        for (int i2 = 0; i2 < m.getTerrainList().size(); i2++){
                            if (m.getHazardList().get(i).collisionCheck(m.getTerrainList().get(i2).getBox())   ){          
                                m.removeHazard(i); 
                                i = i-1;
                                i2 =  m.getTerrainList().size();
                                
                            }
                        }
                        
                    }   
                    gameFrame.repaint();            
                }
     }
            
            
        }
        
        
        
        
    }  
//------------------------------------------------------------------------------  
    //act upon key and mouse events
    public class MyKeyListener implements KeyListener{   
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();

            if (e.getKeyCode() == KeyEvent.VK_ENTER ){
                //starts the game 
                if (gameState == 0){
                    gameState = 1;
                    level = 1;
                    player = new Player(200, 450, 50 , 50);
                    m = new Map(level);
                    
                 //returns from help screen to main menu   
                }
                if (gameState == 2){
                    gameState =0;   
                }
                
            }
            
            //goes from the main menu to the help screen
            if (e.getKeyCode() == KeyEvent.VK_SPACE && gameState == 0 ){
                
                gameState = 2;
                
            }  
            //changes the player's direction to be positive
            if (e.getKeyCode() == KeyEvent.VK_D){
                player.setDirection(1);   
                
                
            }
            
//changes the player's direction to be negative
            if (e.getKeyCode() == KeyEvent.VK_A){
                player.setDirection(-1);   
                
                
            }
            
            if (e.getKeyCode() == KeyEvent.VK_W ){
                
                //if the player is touching the ground, they are able to jump no watter what
                if (player.getAirborne() == false){
                    player.setVMovement(20); 
                }
                //if the player is airborne, they can only jump if they have a double jump available
                else  if (player.getDoubleJump() == true ){
                    player.setDoubleJump(false);
                    player.setVMovement(20); 
                }
                
            }
            
    //makes the player dash forward breifly
            if (e.getKeyCode() == KeyEvent.VK_E){
                if (player.getDirection() !=0 && player.getCooldown() == 0){
                    player.setDash(25);   
                    player.setCooldown(50); 
                    player.setVMovement(0);     
                }
                
            }
            
            
        }
        public void keyReleased(KeyEvent e){ 
            
            //if the direcitonal key the player was holdng is released, the player loses their horizontal movement
            if ((e.getKeyCode() == KeyEvent.VK_D) && (player.getDirection() == 1)){
                player.setDirection(0);
            }    
            
            if ((e.getKeyCode() == KeyEvent.VK_A) && (player.getDirection() == -1)){
                player.setDirection(0);
            }    
        }   
        public void keyTyped(KeyEvent e){
        }           
    }    
//---------------------------------------------------------------------d---------
    //draw everything
    public class GamePanel extends JPanel{
        GamePanel(){
            setFocusable(true);
            requestFocusInWindow();
        }
        
        @Override
        public void paintComponent(Graphics g){ 
            super.paintComponent(g); //required
            
            
            //draws the main menu
            if (gameState == 0){
                try {                
                    menu = ImageIO.read(new File("images/main menu.png"));
                } 
                catch (IOException ex){};  
                g.drawImage(menu, 0, 0, null);         
            }
            
            //drwas the help  screen
            if (gameState == 2){
                
                try {                
                    helpScreen = ImageIO.read(new File("images/help screen.png"));
                } 
                catch (IOException ex){};
                
                g.drawImage(helpScreen, 0, 0, null);
            }
            //draws the gameplay
            if (gameState == 1){         
                player.draw(g);  
                for (int i= 0; i < m.getTerrainList().size(); i++){
                    m.getTerrainList().get(i).draw(g);
                }
                
                for (int i= 0; i < m.getHazardList().size(); i++){
                    m.getHazardList().get(i).draw(g);
                }           
            }  
        }
    }    
//------------------------------------------------------------------------------
    public static void main(String[] args){
        PlatformerGame demo = new PlatformerGame();
        
        demo.run();
    }       
}