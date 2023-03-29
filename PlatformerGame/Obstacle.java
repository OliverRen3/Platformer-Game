import java.awt.Graphics;
import java.awt.Color;

/**
 * Class for object objects
 * @author Oliver Ren
 * @version june 2022
 */

abstract class Obstacle extends Thing {
  
    Obstacle(int positionX, int positionY,int sizeX, int sizeY){
        super(positionX, positionY,sizeX, sizeY);   
        
    }
    
    abstract void draw(Graphics g);
    
    
    
    
}