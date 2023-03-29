import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
/**
 * Class for goal objects
 * @author terrain Ren
 * @version june 2022
 */
 class Goal extends Hazard {
    
      private BufferedImage sprite;
      
     Goal(int positionX, int positionY,int sizeX, int sizeY){
        super(positionX, positionY, sizeX, sizeY);   
        
        try {                
            this.sprite = ImageIO.read(new File("images/Goal.png"));
        } 
        catch (IOException ex){System.out.println("File not found!");} 
    }
     
     void draw(Graphics g){
        
         g.drawImage(this.sprite, this.positionX, this.positionY, null);
        

        
     }
    //if the player contacts it, they pass the level
     void collisionEvent(Thing player){
         ((Player)player).setLevelComplete(true);
        
     }
}