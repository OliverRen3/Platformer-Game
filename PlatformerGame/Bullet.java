import java.awt.Graphics;
import java.awt.Color;
/**
 * Class for bullet objects
 * @author Oliver Ren
 * @version june 2022
 */

class Bullet extends Hazard {
    
    private int directionX;
    private int directionY;
    
    Bullet(int positionX, int positionY,int sizeX, int sizeY, int directionX, int directionY){
        super(positionX, positionY, sizeX, sizeY);   
        
        this.directionY  = directionY;
        this.directionX =  directionX;
        
    }
    void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(positionX, positionY,  sizeX, sizeY);
        
    }
    
    void collisionEvent(Thing player){
        
        ((Player)player).setIsAlive(false);
    }
    
    void move (){
        
        this.positionX = positionX + (5*directionX);
        this.positionY = positionY - (5*directionY);
        
    }
}