import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the background for the text of the hud to go ontop of
 * 
 * @author Matthew Holmes
 * @version V1
 */
public class hudBackground extends Buttons
{
    /**
     * constructor - set the scale of the button
     */
    public hudBackground(int width, int height) {
        getImage().scale(width, height);
    } // end constuct
} // end class HudBackground
