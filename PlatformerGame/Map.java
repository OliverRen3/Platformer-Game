import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for map objects
 * @author terrain Ren
 * @version june 2022
 */
public class Map {
    
    
    ArrayList<Terrain> terrainList;
    ArrayList<Hazard> hazardList;
    
    void addTerrain(Terrain terrain){ 
        terrainList.add(terrain);
    }
    
    
    Map(int level){
        terrainList= new ArrayList<Terrain>();
        hazardList= new ArrayList<Hazard>();
        
        Terrain top = new Terrain(0, 0, 1120, 50);
        Terrain bottom = new Terrain(0, 580, 1600, 50);
        Terrain left = new Terrain(0, 0, 50, 900);
        Terrain right = new Terrain(1070, 0, 50, 900);
        

        terrainList.add(top);
        terrainList.add(bottom);
        terrainList.add(left);
        terrainList.add(right);
        
        //sets up the map based on the given level value
        if (level == 1){
            
            hazardList.add(new Goal (100,100 , 100, 100));
            terrainList.add(new Terrain(100, 300, 500, 100));
            terrainList.add(new Cannon(100, 200, 300, 100, 1, 0));
            hazardList.add(new Fire(400, 799, 500, 101));
            terrainList.add(new Terrain(1100, 500, 500, 100));
            
        }
        
        if (level == 2){
            
            terrainList.add(new Terrain(700, 500, 200, 75));  
            terrainList.add(new Cannon(500, 800, 100, 20, 0, 1));    
            terrainList.add(new Cannon(1000, 800, 100, 20, 0, 1));
            terrainList.add(new Terrain(700, 500, 200, 75));
            hazardList.add(new Goal (750,100 , 100, 100));
            terrainList.add(new Terrain(700, 200, 200, 25));
            terrainList.add(new Terrain(100, 300, 300, 75));
            terrainList.add(new Terrain(1200, 300, 300, 75));        
        }
        
        if (level == 3){
            
            hazardList.add(new Goal (100,200 , 100, 100));
            terrainList.add(new Terrain(300, 550, 1500, 75));
            hazardList.add(new Fire(600, 549, 400, 75));
            terrainList.add(new Cannon(1400, 700, 100, 100, -1, 0));   
            terrainList.add(new Cannon(100, 450, 100, 100, 1, 0));    
            terrainList.add(new Terrain(100, 300, 1200, 75));
            hazardList.add(new Fire(500, 299, 400, 75));
            terrainList.add(new Cannon(1400, 200, 100, 100, -1, 0));   
            
            
        }
    }
    ArrayList<Terrain> getTerrainList(){ 
        return this.terrainList;
        
    }
    ArrayList<Hazard> getHazardList(){
        
        return this.hazardList;
        
    }
    void setHazardList(ArrayList<Hazard> newList){
        
        this.hazardList = newList;
        
    }
    
    void addHazard ( Hazard hazard){
        hazardList.add(hazard);
    }
    
    void removeHazard ( int index){
        hazardList.remove(index);
    }
    
}


