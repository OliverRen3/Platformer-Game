import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList ;


/**
 * Class for the player
 * @author Oliver Ren
 * @version june 2022
 */

public class Player extends Thing {
    
    
    private int direction;
    private int vMovement;
    private boolean isAirborne;
    private int speed;
    private boolean doubleJump;
    private  int hp;
    private int dash;
    private int dashCooldown;
    private boolean isAlive;
    private boolean levelComplete;
    
    Player(int positionX, int positionY, int sizeX, int sizeY){
        super(positionX, positionY,  sizeX,  sizeY);   
        
        direction= 0;
        vMovement = 0;
        isAirborne = false;
        speed = 10;
        doubleJump = true;
        dashCooldown = 0;
        isAlive = true;
        this.levelComplete = false;
    }
    
    
    public void draw(Graphics g){
        
        
        g.setColor(Color.green);
        g.fillRect(positionX, positionY,  sizeX, sizeY);
        
        
    }
    /**
     * move
     * @move the character if possible
     * @params: terrainList 
     */
    
    public void move(ArrayList terrainList){
        
        
        Boolean isMoveable = true;
        //counts down the dash cooldown
        if (dashCooldown > 0){
            dashCooldown = dashCooldown -1;   
            
        }
        //resets the characters speed after their dash ends
        if (this.dash <= 0 && this.speed > 10){
            this.speed = 10;
        }
        //increases the players speed while dashing and decreases the dash duration
        if (this.dash > 0){
            if (this.speed == 10 ){
                this.speed = 30;   
            }
            this.dash = this.dash - 5;
        }
        
        
        this.isAirborne = true;
        
        this.gravity();
        
        //determines the player's coordinates if they were to move like the were going to 
        Rectangle movedPlayerX = new Rectangle (this.positionX + (this.speed * this.direction), positionY, 50, 50);
        Rectangle movedPlayerY = new Rectangle (this.positionX , this.positionY  - ( 1* this.vMovement), 50, 50);
        
        //sorts through all terrain
        for ( int i = 0; i < terrainList.size();i++){
            
            if (movedPlayerX.intersects(((Terrain)terrainList.get(i)).getBox())== true){
                isMoveable = false;      
            }
            //if the player is inable to move in the X direction, set their position to be equal to the left/right of the object that they are walking into
            if(movedPlayerX.intersects(((Terrain)terrainList.get(i)).getBox()) && this.positionX + 50 <= ((Terrain)terrainList.get(i)).getX()){
                
                this.positionX = ((Terrain)terrainList.get(i)).getX() -  50;
                movedPlayerX = new Rectangle (this.positionX + (10 * this.direction), positionY, 50, 50);
            }
            
            if(movedPlayerX.intersects(((Terrain)terrainList.get(i)).getBox()) && this.positionX >= ((Terrain)terrainList.get(i)).getX() + ((Terrain)terrainList.get(i)).getSizeX()){
                
                this.positionX = ((Terrain)terrainList.get(i)).getX() + ((Terrain)terrainList.get(i)).getSizeX();
                movedPlayerX = new Rectangle (this.positionX + (10 * this.direction), positionY, 50, 50);
            }
            
            //if the player is approaching terrain from above, sets their airborn to false, sets their positionY to be equal to on top of the object
            if(movedPlayerY.intersects(((Terrain)terrainList.get(i)).getBox()) && this.positionY + 50 <= ((Terrain)terrainList.get(i)).getY()){
                this.isAirborne = false;
                
                this.doubleJump = true;
                this.vMovement = 0;
                this.positionY = ((Terrain)terrainList.get(i)).getY() - 50;
                movedPlayerY = new Rectangle (this.positionX +1, this.positionY  - ( 1* this.vMovement), 50, 50);
                
            }
            //if player approaches terrain from below sets their positionY to be equal to the bottom of the terrain and resets their V velocity to 0
            if(movedPlayerY.intersects(((Terrain)terrainList.get(i)).getBox()) && this.positionY  >= ((Terrain)terrainList.get(i)).getY() + ((Terrain)terrainList.get(i)).getSizeY()){
                this.vMovement = 0;
                this.positionY = ((Terrain)terrainList.get(i)).getY()  + ((Terrain)terrainList.get(i)).getSizeY();
                movedPlayerY = new Rectangle (this.positionX +1, this.positionY  - ( 1* this.vMovement), 50, 50);
            }
        }
        
        //if no collision occurs, move the player based on their direction
        if (isMoveable == true){
            this.positionX = this.positionX + (this.speed * this.direction);
            
        }
        //moves the player based on their vertical momentum  
        this.positionY =  this.positionY  - ( 1* this.vMovement);
        
    }
    
    public  void  setDirection(int direction){
        this.direction = direction;   
        
    }
    //if the player is airborne and not dashing, decrease their vertical momentum
    public void gravity(){
        if ( this.isAirborne ==true && this.dash ==0 ){
            this.vMovement = this.vMovement - 1;
        }
    }
    
    public int  getDirection(){
        return this.direction;
    }
    
    public int  getVMovement(){
        return this.vMovement;
    }
    
    public Boolean  getAirborne(){
        return this.isAirborne;
    }
    
    public Boolean  getDoubleJump(){
        return this.doubleJump;
    }
    
    void setVMovement(int jumpV){
        this.vMovement = jumpV;
        
    }
    void setDoubleJump(boolean status){
        this.doubleJump = status;
    }
    void setAirborne(boolean status){
        this.isAirborne = status;
    }
    
    void setDash(int duration){
        this.dash = duration;    }
    
    void setCooldown(int cd){
        this.dashCooldown = cd;    
    }
    
    int getCooldown(){
        return this.dashCooldown;    
    }
    
    void setIsAlive(boolean status){
        this.isAlive = status; 
    }
    
    boolean getIsAlive(){
        
        return this.isAlive; 
    }
    
    void setLevelComplete(boolean status){
        this.levelComplete = status; 
    }
    
    boolean getLevelComplete(){
        
        return this.levelComplete; 
    }
    
    
    void setSpeed(int duration){
        this.dash = duration;    }  
}