import lang.stride.*;
import java.util.*;
import greenfoot.*;


public class Player extends Actor

{
    public int tick=0;
    //public int walkTick=0;
    public int runTick=0;
    public int x;
    public int y;
    public String face; 
    public int sprint=0;
    public int stam=50;
    public int health=3;
    
    public int door;
    
    //======ITEMS=======
    public boolean breakerKey = false;
    /**
     * Act - do whatever the player wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //walk();
        //tick();
        //movement();
        if (stam>0) {
            sprint();
        } else {
            sprint=0;
        }
        getPosX();
        getPosY();
        moves();
        isMove();
        resetSprite();
        stamina();
        transitions();
        pickupKey();
        displayStatus();
        checkDeath();
    }
    
    public void transitions() {

        
        Room world = (Room) getWorld();
        Entity entity = world.entity;
        
        
        //Door door = (Door) getOneIntersectingObject(Door.class);
        List<Door> doors = getObjectsInRange(50, Door.class);
        if (doors.size() == 0) return;
        Door door = doors.get(0);
        
        if (door != null) {
            if (door.id == 1) {
                Greenfoot.setWorld( new  Hallway1(this, door, entity));
            }
            if (door.id == 2) {
                Greenfoot.setWorld( new  BasementSpawn(this, door, entity));
            }
            if (door.id == 3) {
                Greenfoot.setWorld( new  Closet(this, door, entity));
            }
            if (door.id == 4) {
                Greenfoot.setWorld( new  BasementSpawn(this, door, entity));
            }
            if (door.id == 5) {
                Greenfoot.setWorld( new  Garage(this, door, entity));
            }
            if (door.id == 6) {
                Greenfoot.setWorld( new  Hallway1(this, door, entity));
            }
            if (door.id == 7) {
                Greenfoot.setWorld( new  LivingRoom(this, door, entity));
            }
            if (door.id == 8) {
                Greenfoot.setWorld( new  Hallway1(this, door, entity));
            }
            if (door.id == 13) {
                Greenfoot.setWorld( new  Hallway2(this, door, entity));
            }
            if (door.id == 14) {
                Greenfoot.setWorld( new  LivingRoom(this, door, entity));
            }
        }
    }
    
    public void pickupKey() {
        Actor Key = getOneIntersectingObject(Key.class);
        if (Key != null) {
            World world = getWorld();
            world.removeObject(Key);
            breakerKey = true;
            Greenfoot.playSound("ItemPickupBase.wav");
        }
    }
    
    private void sprint() {
        if (Greenfoot.isKeyDown("shift")) {
            sprint=3;  //sprint multiplier
            stam--;    //stamina loss
        }
        else {
            sprint=0;
        }
        
        //CHEAT CODE
        if (Greenfoot.isKeyDown("space")) {
            sprint=20;  //sprint multiplier
        }
    }
    
    
    public void displayStatus() {
        World world = getWorld();
        world.showText("Health: "+health, 100,20);
        world.showText("Stamina: "+stam, 100,40);
    }
    public void checkDeath() {
        if (health<=0) {
            setLocation(100,100);
        }
    }
    public void stamina() {
        if (stam<800 && runTick>200) {
            stam+=50;
            runTick=0;
        }
        runTick++;
    }
    public void moves() {
        if (Greenfoot.isKeyDown("w")) {
            tick++;
            face="up";
            setLocation(x, y-3-sprint);
            if (tick>0 && tick<20) {
                setImage("PlayerBackWalk1.png"); 
            }
            if (tick>20) {
                setImage("PlayerBackWalk2.png"); 
            }
            if (tick>40) {
                tick=1;
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            tick++;
            face="left";
            setLocation(x-3-sprint, y);
            if (tick>0 && tick<20) {
                setImage("PlayerLeftWalk1.png");
            }
            if (tick>20) {
                setImage("PlayerLeftWalk2.png");
            }
            if (tick>40) {
                tick=1;
            }
        }
        if (Greenfoot.isKeyDown("s")) {
            tick++;
            face="down";
            setLocation(x, y+3+sprint);
            if (tick>0 && tick<20) {
                setImage("PlayerWalk1.png");
            }
            if (tick>20) {
                setImage("PlayerWalk2.png");
            }
            if (tick>40) {
                tick=1;
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            tick++;
            face="right";
            setLocation(x+3+sprint, y);
            if (tick>0 && tick<20) {
                setImage("PlayerRightWalk1.png");
            }
            if (tick>20) {
                setImage("PlayerRightWalk2.png");
            }
            if (tick>40) {
                tick=1;
            }
        }
    }
    public void isMove() {
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("d")) {
            moves();
        }
        else {
            tick=0;
        }
    }
    public void resetSprite() {
        if (tick==0 && face=="up") {
            setImage("playerBackIdle.png");
        }
        if (tick==0 && face=="left") {
            setImage("PlayerLeftIdle.png");
        }
        if (tick==0 && face=="down") {
            setImage("PlayerIdleV5.png");
        }
        if (tick==0 && face=="right") {
            setImage("PlayerRightIdle.png");
        }
    }
    public int getPosX() {
        x =getX();
        return x;
    }
    public int getPosY() {
        y =getY();
        return y;
    }
    
    
    /*
     * public void getPos() {
        x = getX();
        y = getY();
    }
     */
    
    
    
    
    /*
    public void walk() {
    if (walkTick==0) {
        setImage("PlayerIdleV5.png");
    }
    if (walkTick>0 && walkTick<20) {
        setImage("PlayerWalk1.png");
    }
    if (walkTick==20) {
        setImage("PlayerWalk2.png");
    }
    if (walkTick==40) {
        walkTick=0;
    }
    }
    public void tick() {
        tick++;
    }
    public void movement() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(x, y-3);
            walkTick++;
        } else if  (Greenfoot.isKeyDown("a")) {
            setLocation(x-3, y);
            walkTick++;
        } else if (Greenfoot.isKeyDown("s")) {
            setLocation(x, y+3);
            walkTick++;
        } else if (Greenfoot.isKeyDown("d")) {
            setLocation(x+3, y);
            walkTick++;
        }
        else {
            walkTick=0;
        }
    }
    */
    
    
}
