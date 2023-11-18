import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class PonchoGunSlingers1 extends World
{
    private long lastFrameTimeMS;
    private double timeStepDuration;
    /**
     * Constructor for objects of class PonchoGunSlingers1.
     */
    public PonchoGunSlingers1()
    {
        super(1200, 600, 1);
        prepare();
        lastFrameTimeMS = System.currentTimeMillis();
        timeStepDuration = 1.0 / 60;
    }
    
    public void started()
    {
        lastFrameTimeMS = System.currentTimeMillis();
    }
    
    public void act()
    {
        timeStepDuration = (System.currentTimeMillis() - lastFrameTimeMS) / 200.0;
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
        Cowboy cowboy =  new  Cowboy();
        addObject(cowboy, 128, 486);
        cowboy.setLocation(38,465);
        Platform platform = new Platform();
        addObject(platform,74,497);
        Platform platform2 = new Platform();
        addObject(platform2,425,345);
        Platform platform3 = new Platform();
        addObject(platform3,641,151);
        Platform platform4 = new Platform();
        addObject(platform4,676,449);
        Platform platform5 = new Platform();
        addObject(platform5,1018,451);
    }
}
