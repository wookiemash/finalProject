import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An item called Tv
 * 
 * @author Matthew
 * @version V1
 */
public class Tv extends PickUps
{
    // initialize
    /**
     * contstuctor - sets the name and category of the Tv instance
     */
    public Tv()
    {
        // sets the name this item for the world to reference
        type = "Tv";
        category = "electronic";
        points = 40;
        scale = 40;
        size(scale, scale);
    } // end Constructor Tv
} // end class Tv
