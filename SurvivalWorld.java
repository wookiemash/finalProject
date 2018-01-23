import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; // (Import java list)
/**
 * The main world. Inititates the world and starts the game.
 * Also, keeps track of the score and ends the game
 * 
 * @author Matthew Holmes
 * @version V1
 */
public class SurvivalWorld extends World
{
    // INITIALIZE \\    
    protected Character character = new Character();
    private int score;
    private int pickUpCount;
    private int totalItems;
    private int timerRadius;
    private int timerRadiusDefault;
    private int timerText;
    private int timerTextDefault;
    private boolean radiusChanged;
    protected String country;
    private int totalEnemies;
    //found @https://stackoverflow.com/questions/12231453/syntax-for-creating-a-two-dimensional-array
    private int spawnLocations[][] = {{100, 600},{400, 160},{800, 100},{700, 650}};
    /**
     * Constructor for objects of class Survival World
     */
    public SurvivalWorld(String countryName)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000,700, 1);
        //timers
        country = countryName;
        timerTextDefault = 200;
        timerText = timerTextDefault;
        
        radiusChanged = false;
        
        // number of each object to spawn initially
        pickUpCount = 5;
        
        //add all the neccessary objects into the world
        prepare();
        
    }

    /**
     * Spawn enemies as necassary and checks if dispText
     * needs to be set to null
     */
    public void act()
    {
        spawnEnemies();
    } // end method act

    /**
     * Populates the world with all the objects that
     * need to be present at the beginning of the game
     */
    public void prepare()
    {
        // add the character to the world
        addObject(character, 90, 300); //predifined character in the constructor
        
        // add gun and set default radius
        if (country == "FirstWorld") {
            timerRadiusDefault = 400;
            addObject( new Gun(), 10, 10);
            totalEnemies = 10;
        } else {
            timerRadiusDefault = 800;
            addObject( new Bow(), 10, 10);
            totalEnemies = 18;
        } // end if        

        // loops designed to populate the world less tediously
        for (int i = 0; i < (spawnLocations.length); i++) {
            int x = spawnLocations[i][0];
            int y = spawnLocations[i][1];
            addObject(new HouseBackground(), x ,y);
            addObject(new House(), x, y);
            addObject(new DoorClosed(), x, y);
        } // end for
        
        for(int i=1; i<pickUpCount; i++)
        {
            //addObject(new Tree(), Greenfoot.getRandomNumber((getWidth()-100) + 50), Greenfoot.getRandomNumber((getHeight()-100) + 50));
            addObject(new Tv(), Greenfoot.getRandomNumber((getWidth()-100) + 50), Greenfoot.getRandomNumber((getHeight()-100) + 50));
            addObject(new Diamond(), Greenfoot.getRandomNumber((getWidth()-100) + 50), Greenfoot.getRandomNumber((getHeight()-100) + 50));
        } // end for        
        
        // hud
        addObject(new hudBackground(280, 40), 150, 30);
        addObject(new HealthBar(), 500, 675);
    } // end method prepare

    private void spawnEnemies() {
        // Spawn enemies at a 1 percent chance every act cycle
        List<Enemy> enemiesList = getObjects(Enemy.class);
        //finding the length of a list found @https://stackoverflow.com/questions/6846841/how-do-i-get-length-of-list-of-lists-in-java
        int len = enemiesList.size();
        if (Greenfoot.getRandomNumber(100) < 5 && len < totalEnemies)
        {
            int spawnLoc = Greenfoot.getRandomNumber(spawnLocations.length);            
            int x = spawnLocations[spawnLoc][0];
            int y = spawnLocations[spawnLoc][1];
            
            Enemy enemy = new Enemy(country);
            // add code to remove this door after a certain amount of time, thereby closing the door. need ref for all doors opened tho
            DoorOpened door = new DoorOpened();
            addObject(door, x, y);
            addObject(enemy, x, y);
            // set the "previous"location of the enemy
                /* This just allows the enemy's code to 
                   run without the program breaking becuase
                   the previous x and previous y are not set till
                   after one move cycle
                 */
            enemy.initialize(x, y);
        } // end if statement
    } // end method spawnEnemies
    
    /**
     * dispText - 
     */
    public void dispText(String name, int dangerRadius)
    {
        int x = 150;
        int y = 25;
        String prefix;
        if (name != null)
        {
            totalItems++;
            showText("Total number of items is: " +totalItems, x, y);
            if (totalItems == (pickUpCount-1)*2) {
                addObject(new YouWon(), getWidth()/2, getHeight()/2); 
                Greenfoot.delay(250);
                Greenfoot.setWorld(new Menu());
            } // end if        
            // found @goo.gl/wX5WV5
            char firstL = name.charAt(0); //access the first letter of my string
            
            /* checks if the first letter of the object we picked up is
               a vowel, if yes: set the prefix to an. if no: set the 
               prefix to a (really just an ocd thing).
            */
            switch (firstL)
            {
                case 'A':
                    prefix = "an";
                case 'E':
                    prefix = "an";
                case 'I':
                    prefix = "an";
                case 'O':
                    prefix = "an";
                case 'U':
                    prefix = "an";
                default:
                    prefix = "a";
            } // end switch statement
            //disp the name of the object we just picked up
            showText("You just picked up " + prefix + " " + name, x + 50, y + 50);
            
            // make a call to all enemies to check if they should attack player
            // aka figure out how to do a for each loop
            List<Enemy> enemiesList = getObjects(Enemy.class);
            for (Enemy enemy : enemiesList)
            {
                enemy.updateMinDistance(dangerRadius);
            } // end for each loop
            timerRadius = timerRadiusDefault;
        }
        //removes the latest found item text if it has been displayed for the desired time
        else if (name == null && timerText < 1)
        {
            showText("", x, y + 50);
            timerText = timerTextDefault;
        }
        else
        {
            timerText--;
        }// end if/else
        
        if (radiusChanged == true)
        {
            timerRadius--;
            if (timerRadius < 1)
            {
                radiusChanged = false;
                
                // found from chapter 7 of the greenfoot book
                /* get all the enemys in the world and updates
                   the the "search" distance for the character
                 */
                List<Enemy> enemiesList = getObjects(Enemy.class);
                for (Enemy enemy : enemiesList)
                {
                    enemy.resetDistance();
                } // end for each loop
            } // end if
        } // end if
    } // end method showText
    
    /**
     *  get the current country that the game is simulating
     */
    public String getCountry() {
        return country;
    } // end method country
    
    /**
     * runs if user looses the game.
     */
    public void lost() {
        addObject(new GameOver(), getWidth()/2, getHeight()/2);
        showText("Score: " +score, getWidth()/2, getHeight()/2+60);
        Greenfoot.delay(250);
        Greenfoot.setWorld(new Menu());
    } // end method lost
    
    /**
     * score - keeps the current score of the character
     */
    public void score(int points) {
        score += points;
    } // end method score
}
