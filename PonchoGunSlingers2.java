import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PonchoGunSlingers2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PonchoGunSlingers2 extends World
{
    private long lastFrameTimeMS;
    private double timeStepDuration;
    /**
     * Constructor for objects of class PonchoGunSlingers2.
     * 
     */
    public PonchoGunSlingers2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1);
        lastFrameTimeMS = System.currentTimeMillis();
        timeStepDuration = 1.0 / 60;
        prepare();
    }
    public void started()
    {
        lastFrameTimeMS = System.currentTimeMillis();
    }
    public void act()
    {
        timeStepDuration = (System.currentTimeMillis() - lastFrameTimeMS) / 1000.0;
        lastFrameTimeMS = System.currentTimeMillis();
    }
    public double getTimeStepDuration()
    {
        return timeStepDuration;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cowboy cowboy = new Cowboy();
        addObject(cowboy,128,486);
        cowboy.setLocation(41,522);
        cowboy.setLocation(16,482);
        cowboy.setLocation(26,477);
        cowboy.setLocation(21,468);
        cowboy.setLocation(21,466);
    }
}
