import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SuperClass for all ranged weapons
 * 
 * @author Matthew Holmes 
 * @version v1
 */
public class RangedWeapons extends Weapons
{
    /* Initilize */
    protected GreenfootImage projectile;
    protected int rotation;
    protected int lifeTime;
    protected int DamageAmount;
    protected int scale;
    protected int speed;
    protected int attackRateMax;
    protected boolean multiHit;
    protected int attackRate;
    protected int soundLevel;
    protected String soundName;
    /**
     * checkFire - check if the user tried to fire. if yes fire the specified bullet
     */
    public void checkFire()
    {
        attackRate--;
        if (Greenfoot.isKeyDown("space") && attackRate < 1)
        {
            Bullet bullet = new Bullet(getRotation(), lifeTime, damageAmount, scale, speed, multiHit , projectile);
            getWorld().addObject(bullet, getX(), getY());
            attackRate = attackRateMax;
            
            //how to use greenfoot sounds found @ https://www.greenfoot.org/topics/8044/0
            GreenfootSound gfs = new GreenfootSound(soundName);
            gfs.setVolume(soundLevel);
            gfs.play();
        } // end if statement
    } // end method checkFire     
} // end class rangedWeapons
