import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main class for all of the props in the world
 * Props do NOT affect gameplay in any way
 * and are only added for a cosmetic touch
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Props extends Actor
{
    // the scale for all props - can be set to a different scale for each image
    protected int scale;
    /**
     * size - allow each prop to pass in its desired
     * size (for the image) and update it accordingly
     */
    public void size(int width, int height)
    {
        getImage().scale(width, height);
    } // end method damage
} // end class Pros
