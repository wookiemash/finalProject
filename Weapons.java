import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main class for base weapon functionality
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Weapons extends Actor
{
    // INITIALIZE \\
    protected int scale;
    // fix attack rate
    protected int attackRate;
    protected int attackRateMax;
    protected int damageAmount;
    protected boolean multiHit;
    /**
     * constructor - initialize the weapon's damage, size, and attack rate
     */
    public Weapons()
    {
        scale = 60;
        damageAmount = 10;
        multiHit = false;
        attackRateMax = 5;
    } // end constructor Weapons
    
    /**
     * size - set the size of the weapon
     */
    public void size(int width, int height)
    {
        getImage().scale(width, height);
    } // end method damage
    
    /**
     * attack - attacks an enemy it collides with
     */
    public void attack()
    {
        Enemy enemy = (Enemy) getOneObjectAtOffset(0,0, Enemy.class);
        if (enemy != null)
        {
            enemy.damage(damageAmount);
            if (multiHit == false)
            {
                getWorld().removeObject(this);
            } // end if statment
        } // end if statement
    } // end method attack
    
    /**
     *  attach - move the this.weapon ontop of the character so the character appears to be holding it
     */
    public void attach()
    {
        Character character = (Character) getWorld().getObjects(Character.class).get(0);
        setLocation(character.getX()+35, character.getY()+15);

        if (null != Greenfoot.getMouseInfo())
        {       
            MouseInfo mouse = Greenfoot.getMouseInfo();
            turnTowards(mouse.getX() , mouse.getY());
        } // end if statement
    } // end method attach
} // end class weapons
