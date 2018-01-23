import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * choose the level the user wants to play
 * 
 * @author Matthew
 * @version Holmes
 */
public class LevelSelector extends Buttons
{
    private int maxDelay;
    private int clickDelay;
    public LevelSelector()
    {
        choice = "FirstWorld";
        position = 0;
        maxDelay = 10;
        clickDelay = maxDelay;
    } // end contsructor Play
    /**
     * Act - checks if the user clicked to change the level. If yes, update the game accordingly
     */
    public void act() 
    {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            isClicked = didClick(mouse, choice, position);
            if (isClicked == true && clickDelay < 1) {
                Menu menu = (Menu) getWorld();
                if (choice == "FirstWorld") {
                        choice = "ThirdWorld";
                        clickDelay = maxDelay;
                        menu.setCountryName("ThirdWorld");
                } else {
                        choice = "FirstWorld";
                        clickDelay = maxDelay;
                        menu.setCountryName("FirstWorld");
                } // end if/else
            } // end if statement
            clickDelay--;
    } // end method act
} // end class level selector
