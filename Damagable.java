import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Super class for all characters and enemies
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Damagable extends Actor
{
    // INITIALIZE \\
    protected int health;
    protected int speed;
    /**
     * constructor - set the health of all actors who take damage
     */
    public Damagable()
    {
        health = 100;
    } // end constructor Damagable

    /**
     * damage - takes in the damage amount and takes it away from the
     * players health. If the health is less than or equal to 1, remove
     * the character or enemy from the map
     */
    public boolean /*did damage*/ damage(int damageAmount)
    {
        health -= damageAmount;
        if (health <= 0)
        {
            SurvivalWorld world = (SurvivalWorld) getWorld();
            world.score(20);
            getWorld().removeObject(this);  
            return true;
        }
        else
        {
            return false;
        } // end if/else statement
    } // end method damage
} // end class damageble
