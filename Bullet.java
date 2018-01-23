import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Inherits from the Projectiles class
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Bullet extends RangedWeapons

{
    /**
     * constructor -  initializes the bullet to whatever it should be
     */
    public Bullet(int rotation, int lifeTime, int damageAmount, int scale, int speed, boolean multiHit, GreenfootImage projectile)
    {
        setImage(projectile);
        size(scale, scale);
        setRotation(rotation);
        this.lifeTime = lifeTime;
        this.damageAmount = damageAmount;
        this.speed = speed;
        this.multiHit = multiHit;
    } // end Bullet Constructor
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(speed);
        Destruct();
    } // end act method
    
    /**
     * Destruct - checks if the projectile should self destruct
     */
    public void Destruct()
    {
        lifeTime--;
        if (lifeTime < 1)
        {
            getWorld().removeObject(this);
        }
        else
        {
            // this is inherited from the Weapons class
            attack();
        } // end if/else statement
    } // end selfDestruct    
} // end class bullet
