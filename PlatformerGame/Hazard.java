import java.awt.Graphics;
import java.awt.Color;

/**
 * Class for hazard objects
 * @author Oliver Ren
 * @version june 2022
 */

abstract class Hazard extends Obstacle {
    
    Hazard(int positionX, int positionY,int sizeX, int sizeY){
        super(positionX, positionY, sizeX, sizeY);
        
        
    }
    
    abstract void draw(Graphics g);
      
    abstract void collisionEvent(Thing player);    
}