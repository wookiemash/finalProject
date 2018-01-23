import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main menu of the game
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Menu extends World
{
    // INITIALIZE \\
    private int money;
    final int WIDTH;
    final int HEIGHT;
    private String countryName;
    /**
     * Constructor for the menu
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        //sets the WIDTH and HEIGHT of all the buttons
        WIDTH = 125;
        HEIGHT = 50;
        countryName = "FirstWorld";
        prepare();
    } // end constructor for the Menu
    
    /**
     * prepare - adds all the buttons to the menu world
     */
    public void prepare()
    {
       // creates the play button
       Play playButton = new Play();
       addObject(playButton, getWidth()/2, getHeight()/2-100);
       playButton.getImage().scale(WIDTH, HEIGHT);
       
       // creates the level Selector button
       LevelSelector levelButton = new LevelSelector();
       addObject(levelButton, getWidth()/2, getHeight()/2);
       levelButton.getImage().scale(WIDTH, HEIGHT);
       
       // creates the quite button
       Quit quitButton = new Quit();
       addObject(quitButton, getWidth()/2, getHeight()/2+100);
       quitButton.getImage().scale(WIDTH, HEIGHT);
    } // end method prepare
    
    /**
     * setCountryName - sets the name of the country the character is going to spawn in.
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    } // end method setCountryName
    
    /**
     * createSurvivalWorld - spawns the survivalWorld and passes the name of the country that
     * the character is going to be playing in. enemies are based off this parameter.
     */
    public void createSurvivalWorld() {
        Greenfoot.setWorld(new SurvivalWorld(countryName));
    } // end method createSurvivalWorld
} // end class Menu
