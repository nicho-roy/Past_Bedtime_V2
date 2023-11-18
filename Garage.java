import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Garage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garage extends Room
{
    /**
     * Constructor for objects of class Garage.
     * 
     */
    public Garage(Player playerObj, Door door, Entity entity)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, playerObj, door, entity); 
        
        prepare();
        
        if (door.id == 5) {
            addObject(playerObj,100,100);
        }
    }
    private void prepare() {
        Door door6 = new Door(6);
        door6.setRotation(270);
        addObject(door6, 4,100);
    }
    public void act() {
        chasing();    
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,100,100);
    }
}
