import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enemy - main objective in life is to walk around and kill the enemy based
 *  on certain factors of the game world.
 * 
 * @author Matthew Holmes 
 * @version V1
 */
public class Enemy extends Damagable

{
    //private int fallSpeed;
    private int speed;
    private int timer;
    private int previousX;
    private int previousY;
    private int health;
    private int minDistanceDefault;
    private int minDistance;
    private boolean isAttacking;
    private int damageAmount;

    /**
     * Enemy constructor - intitalizes all the enemies variables.
     */
    public Enemy(String country)
    {
        isAttacking = false;
        timer = 0;
        getImage().scale(60, 60);                          
        if ( country == "FirstWorld") {
            damageAmount = 10;
            health = 100;
            minDistanceDefault = 100;
            speed = 3;
        } else {
            damageAmount = 25;
            health = 150;
            minDistanceDefault = 200;
            speed = 4;
        } // end if/else
        minDistance = minDistanceDefault;
    } // end constructor Enemy
    
    /**
     * intitialize - set the "previous" location of the actor. There is no actual previous location 
     * because the enemy is just spawned, but the program will break if it is not set to something.
     */
    public void initialize(int x, int y)
    {
        previousX = x;
        previousY = y;
    } // end method initialize
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }
    
    /**
     * movement - decides where the enemy should face and move to that location.
     * Also checks for necassary crowd control affects.
     */
    public void movement()
    {
        //code for the character reference(line directly below only) found @https://www.greenfoot.org/topics/1455
        Character character = (Character) getWorld().getObjects(Character.class).get(0);
        
        // find the line from the character to enemy
        int x = Math.abs(character.getX() - getX());
        int y = Math.abs(character.getY() - getY());
        double hypotenuse = Math.sqrt(x*x + y*y);
        if ( hypotenuse < minDistance)
        {
            turnTowards(character.getX(), character.getY());
            isAttacking = true;
        } // end if statement
        else
        {
            timer--;
            if (timer < 0)
            {
                timer += Greenfoot.getRandomNumber(70) + 40;
                turn(Greenfoot.getRandomNumber(359));
                isAttacking = false;
            } // end if statement
        } // end if/else statement
        
        if (isAttacking) {
            int blockDistance = 20;
            Actor isBlocked;
            // check in form of self to see if anyone is blocking this.enemy
            do {
                isBlocked = getOneObjectAtOffset((getX()-previousX)*blockDistance, (getY()-previousY)*blockDistance, Enemy.class);
                if (isBlocked != null) {
                    break;
                } // end if
                blockDistance -= 2;
            } while (blockDistance > 0); // end do while
            
    
            if ( isBlocked ==null)
            {
                previousX = getX();
                previousY = getY();
                move(2);
            }
            else
            {
                move(-1);
            }
        } else {
            move(2);
        } // end if/else
    } // end method movement
    
    /* the method below are called outside of this actor only*/
    /**
     * updateMinDistance - set the new distance for how far the enemy should
     * look for the character in the world.
     */
    public void updateMinDistance(int newDistance)
    {
        minDistance = newDistance;
    } // end method updateMinDistance
    
    /**
     * resetDistance - reset the search distance for the enemy to its default
     */
    public void resetDistance()
    {
        minDistance = minDistanceDefault;
    } // end method restDistance
    
    /**
     * getter for isAttacking
     */
    public boolean getIsAttacking() {
        return isAttacking;
    } // end method getIsAttacking
    
    /**
     * getter for enemy damage amount
     */
    public int damageAmount() {
        return damageAmount;
    } // end method damageAmount
} // end class enemy
