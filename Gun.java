import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A gun is a subclass of the RangedWeapons class.
 * Fires projectiles of the type bullet
 * 
 * @author Matthew Holmes
 * @version v1
 */
public class Gun extends RangedWeapons
{
    /**
     * constructor - set the image of the gun
     */
    public Gun()
    {
        //self\\
        
        //bullet\\
        scale = 15;
        projectile = new GreenfootImage ("BulletRound.png");
        lifeTime = 55;
        damageAmount = 20;
        speed = 6;
        multiHit = true;
        attackRateMax = 5;
        soundLevel = 60;
        soundName = "gun.wav";
    } // end constructor
    /**
     * Act - Will attach itself to the Character
     * and rotate to wherever the mouse is facing.
     * Will fire a bullet whenever the space key is pressed.
     */
    public void act() 
    {
        attach();
        checkFire(); 
    } // end method act   
} // end class Gun
