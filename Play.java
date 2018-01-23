import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a button that starts the game
 * and loads the SurvivalWorld
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Play extends Buttons

{
    public Play()
    {
        choice = "Play";
        position = -100;
    } // end contsructor Play
    /**
     * Act - gets a reference to the mouse and runs the 
     * super class method didClick. If this returns true,
     * Start the game and load the SurvivalWorld.
     */
    public void act() 
    {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            isClicked = didClick(mouse, choice, position);
            if (isClicked == true)
            {
                Menu menu = (Menu) getWorld();
                menu.createSurvivalWorld();
            } // end if statement
    } // end method act
} // end class play
