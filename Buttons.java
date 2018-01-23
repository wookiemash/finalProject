import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates the main functionality of all buttons
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Buttons extends Actor
{
    // INITIALIZE \\
    protected String choice;
    protected boolean isClicked;
    protected int position;
    
    /**
     *  checks ifthe mouse is over and clicking on a button.
     *  if it is, run the appropriate action from the subclass
     */
    public boolean didClick(MouseInfo mouse, String choice, int position)
    {
        getWorld().showText(choice, getWorld().getWidth()/2, getWorld().getHeight()/2+position);
        boolean isClicked = false;
        if (mouse != null)
        {
            // check if the mouse is over the specified bounds
            if ((mouse.getX() > getX() - 60 && mouse.getX() < getX() + 60)
              &&(mouse.getY() > getY() - 25 && mouse.getY() < getY() + 25)
              &&(mouse.getButton() > 0)) 
            {
                isClicked = true;
            } // end if statment
        } // end if statement
        return isClicked;
    } // end method didClick
} // end class buttons
