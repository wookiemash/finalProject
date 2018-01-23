import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends PickUps
{
    /**
     * Constructor - initialize the diamond
     */
    public Diamond() {
        // sets the name this item for the world to reference
        type = "Diamond";
        category = "monetary";
        points = 60;
        scale = 40;
        size(scale, scale);        
    } // end constructor Diamond
}
