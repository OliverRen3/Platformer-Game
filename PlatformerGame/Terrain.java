import java.awt.Graphics;
import java.awt.Color;
 import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for terrain objects
 * @author terrain Ren
 * @version june 2022
 */

public class Terrain extends Obstacle {

    Terrain(int positionX, int positionY,int sizeX, int sizeY){
        super(positionX, positionY, sizeX, sizeY);   
    }
    
    public void draw(Graphics g){

        g.setColor(Color.blue);
        g.fillRect(positionX, positionY,  sizeX, sizeY);
        
    }
        
 
   
}