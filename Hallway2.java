import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Hallway2 extends Room
{
    /**
     * Constructor for objects of class Hallway2.
     */
    public Hallway2(Player playerObj, Door door, Entity entity) // Player player
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 200, 1, playerObj, door, entity); 
        //entity = entity;
        
        /*StairwayLight light = new StairwayLight();
        addObject(light, 1100, 33);
        */
        
        furniture();
        prepare();
        
        if (door.id == 13) {
            addObject(playerObj,1100,100);
        }
        if (door.id == 16) {
            addObject(playerObj,100,100);
        }
        
        entity.chase=true;
    }
    public void furniture() {
        
    }
    public void prepare() {
        addObject(entity,20,100);
        
        Door door14 = new Door(14);
        door14.setRotation(90);
        addObject(door14, 1196,100);
    }
}
