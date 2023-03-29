import java.awt.Rectangle;
/**
 * Class for all product objects
 * @author Oliver Ren
 * @version April 2021
 */ 

abstract class Thing {
    
    int positionX;
    int positionY;
    Rectangle box;
    
    int sizeX;
    int sizeY;
    
    Thing(int positionX, int positionY, int sizeX, int sizeY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.box = new Rectangle(positionX, positionY, sizeX, sizeY);
    }
    
    public void setBox(){
        this.box = new Rectangle(positionX, positionY, sizeX, sizeY);
    }
    
    public Rectangle getBox(){
        return this.box;   
    }
    public Boolean collisionCheck(Rectangle other){
        
       // System.out.println( this.box.intersects(other));
        return this.box.intersects(other);
        
    }
    
    int getX(){
        
     return positionX;   
    }
    
    int getSizeX(){
        
     return this.sizeX;   
    }
    
     int getSizeY(){
        
     return this.sizeY;   
    }
      int getY(){
        
     return positionY;   
    }
    
         public void setX(int positionX){
       this.positionX = positionX;
       
   }
   
    public void setY(int positionY){
       this.positionY = positionY;
       
   }

    
    
}