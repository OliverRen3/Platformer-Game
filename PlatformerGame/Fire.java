import java.awt.Graphics;
import java.awt.Color;
/**
 * Class for fire objects
 * @author Oliver Ren
 * @version june 2022
 */

class Fire extends Hazard {
    
    Fire(int positionX, int positionY,int sizeX, int sizeY){
        super(positionX, positionY, sizeX, sizeY);   
    }
    void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(positionX, positionY,  sizeX, sizeY);        
    }
    
    void collisionEvent(Thing player){
//kills the player if they contact it
        ((Player)player).setIsAlive(false);
    }
}