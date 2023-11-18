import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class LivingRoom extends Room
{
    int chaseTick=0;
    /**
     * Constructor for objects of class LivingRoom.
     */
    public LivingRoom(Player playerObj, Door door, Entity entity)
    {
        super(800, 600, 1, playerObj, door, entity); 
        
        prepare();
        
        if (door.id == 7) {
            addObject(playerObj,700,500);
        }
        if (door.id == 14) {
            addObject(playerObj,100,100);
        }
        
    }
    public void act() {
        chasing();     
    }
    
    private void prepare() {
        Door door8 = new Door(8);
        door8.setRotation(180);
        addObject(door8, 700,596);
        
        Door door13 = new Door(13);
        door13.setRotation(270);
        addObject(door13, 4,100);
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,100,100);
    }
}
