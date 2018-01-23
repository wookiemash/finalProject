import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Bow is a subclass of the RangedWeapons class.
 * Fires projectiles of the type Arrow
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Bow extends RangedWeapons
{
    /**
     * construtor - set the size of the bow
     */
    public Bow()
    {
        //self\\
        scale = 60;
        size(scale, scale);
        //bullet\\
        scale = 80;
        projectile = new GreenfootImage ("BulletArrow.png");
        lifeTime = 70;
        damageAmount = 100;
        speed = 5;
        multiHit = true;
        attackRateMax = 28;
        soundName = "bow.wav";
        soundLevel = 80;
    } // end Constructor Bow
    /**
     * attach weapon to character and check if user tried to fire
     */
    public void act() 
    {
        attach();
        checkFire(); 
    } // end method act   
} // end class bow
