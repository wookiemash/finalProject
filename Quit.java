import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Quites the game
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Quit extends Buttons
{
    public Quit()
    {
        choice = "Quit";
        position = 100;
    } // end contsructor Play
    /**
     * Act - stops the game if the player
     * clicks on the quite button.
     */
    public void act() 
    {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            isClicked = didClick(mouse, choice, position);
            if (isClicked == true)
            {
                Greenfoot.stop();
            } // end if statement
    } // end method act
} // end class quite
