import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for cannon objects
 * @author Oliver Ren
 * @version june 2022
 */

public class Cannon extends Terrain {
    
    int directionY;
    int directionX;
    int bulletTimer;
    
    Cannon(int positionX, int positionY,int sizeX, int sizeY, int directionX,int directionY){
        super(positionX, positionY, sizeX, sizeY);   
        
        this.directionY  = directionY;
        this.directionX =  directionX;
        this.bulletTimer = 50;
        
    }
    
    public void draw(Graphics g){
        
        
        g.setColor(Color.black);
        g.fillRect(positionX, positionY,  sizeX, sizeY);
        
    }
    
    public void shoot(Map m){
        
        this.bulletTimer = bulletTimer + 1;//counts up the bullet timer
        
        if (this.bulletTimer == 150){
            //if the bullet timer is reached, fires a bulllet    
            this.bulletTimer = 0;
            
            //position of the bullet created is determined by the direction it is being fired in
            if( directionX > 0){
                
                
                Bullet bullet = new Bullet(this.sizeX + this.positionX + 1 ,this.positionY + (this.sizeY/2) -10 , 20, 20, this.directionX, this.directionY);
                m.addHazard(bullet);
            }
            
            if( directionX < 0){
                
                
                Bullet bullet = new Bullet(this.positionX - 21 ,this.positionY + (this.sizeY/2) -10 , 20, 20, this.directionX, this.directionY);
                
                m.addHazard(bullet);
            }
            
            if( directionY > 0){
                
                
                Bullet bullet = new Bullet(this.sizeX/2 + this.positionX - 10 ,this.positionY -21 , 20, 20, this.directionX, this.directionY);
                m.addHazard(bullet);
            }
            
            if( directionY < 0){
                
                
                Bullet bullet = new Bullet(this.sizeX -1 ,this.positionY + (this.sizeY/2) -10 , 20, 20, this.directionX, this.directionY);
                m.addHazard(bullet);
            }
        }
    }   
    
    
}