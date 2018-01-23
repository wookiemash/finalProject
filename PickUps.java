import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main class for all pickups
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class PickUps extends Actor
{
    // INITIALIZE \\
    // name of each pickup
    protected String type;
    protected int dangerRadius;
    protected String category;
    protected int points;
    protected int scale;
    /**
     * pickedUp - called whenever an item is picked up.
     * asks the world to tell the user the name of the 
     * item the user just walked over in-game.
     */
    public void pickedUp()
    {
          SurvivalWorld world = (SurvivalWorld) getWorld();
          dangerRadius = setRadius();
          world.score(points);
          world.dispText(type, dangerRadius);
    }
    
    /**
     * setRadius - set the radius for which the enemies search when this object is picked up.
     */
    public int setRadius() {
        String country;
        int radius;
        SurvivalWorld world = (SurvivalWorld) getWorld();
        country = world.getCountry();

        if ( country == "America")
        {
            if ( category == "electronic") {
                    radius = 125;
            } else if ( category == "monetary") {
                    radius = 150;
            } else {
                    radius = 200;
            } // end if/else
        } else {
            if ( category == "electronic") {
                    radius = 400;
            } else if ( category == "monetary") {
                    radius = 500;
            } else {
                    radius = 200;
            } // end if/else
        } // end if/else statement      
        return radius;
    } // end method setRadius
    
    /**
     * size - set the size of the pickup
     */
    public void size(int width, int height)
    {
        getImage().scale(width, height);
    } // end method damage
} // end class pickups
