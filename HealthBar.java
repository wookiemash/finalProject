import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shows the players health at the bottom of the screen
 * 
 * @author Matthew Holmes 
 * @version v1
 */
public class HealthBar extends Actor
{
    // initialize
    private int y;
    private int scaleConstant;
    private int scale;
    private int time;
    public HealthBar() {
        time = 0;
        scale = 300;
        scaleConstant = 100;
        y = 30;
        getImage().scale(scale, y);
    } // end constuct
    
    /**
     * update the health bar
     */
    public void update(int health) {
        time = scaleConstant - health;
        scaleConstant = health;
    } // end method update
    
    /**
     * update the health bar
     */
    public void act() {
        if (time > 0) {
            scale -= 3;
            if ( scale < 1) {
                scale = 1;
            } // end if 
            getImage().scale(scale, y);
        } // end if
        time--;
    } // end method act
} // end class HealthBar
