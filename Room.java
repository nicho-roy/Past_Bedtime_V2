import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Room extends World
{
    public Entity entity;
    public int chaseTick=0;
    /**
     * Constructor for objects of class Room.
     */
    public Room(int width, int height, int cells, Player playerObj, Door door, Entity entityObj)
    {
        super(width, height, cells);
        entity = entityObj;
        
    }
}
