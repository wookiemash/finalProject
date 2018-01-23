import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Inherites from its Super class Damageable. The is the Object that 
 * the user will be controlling throughout the duration of the game.  
 * The Character can move around, control the mouse, and pick up items.
 * 
 * @author Matthew Holmes 
 * @version V1
 */
public class Character extends Damagable

{
    //INITIALIZE \\
    private int takeDamageDelay;
    private int takeDamageDelayMax;
    private GreenfootImage animation;
    private int animTimer;
    private int animTimerMax;
    /**
     * constructor - initialize character timers
     */
    public Character()
    {
       takeDamageDelayMax = 34;
       takeDamageDelay = takeDamageDelayMax;
       getImage().scale(60, 70);
       animTimerMax = 20;
       animTimer = animTimerMax;
    } // end consturctor Character

    /**
     * Act - Checks if the User wants to move the Character,
     * mouse, or has tried to pick up an item.
     */
    public void act() 
    {
        checkKeyPressed();
        isOverPickUp();
        takeDamage();
    } // end method act

    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPressed()
    {
        boolean isMovingLeft  = false;
        boolean isMovingRight = false;

        if (Greenfoot.isKeyDown("shift"))
        {
            speed = 4;  
        }
        else
        {
            speed = 2;
        } // end if/else

        if ((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) && (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down"))) 
        {
            
        } else if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
            isMovingLeft = true;
            setLocation(getX(), getY()+speed);
        } else if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            isMovingRight = true;
            setLocation(getX(), getY()-speed);
        } // end if/else

        if ((Greenfoot.isKeyDown("d")|| Greenfoot.isKeyDown("right")) && (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")))
        {           
            
        } else if (Greenfoot.isKeyDown("d")|| Greenfoot.isKeyDown("right")) {
            isMovingLeft  = false;
            isMovingRight = true;
            setLocation(getX()+speed, getY());
        } else if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            isMovingRight = false;
            isMovingLeft  = true;
            setLocation(getX()-speed, getY());
        } // end if/else
        
        animations(isMovingLeft, isMovingRight);
    } // end method checkKeyPress()

    /**
     * check if the character has walked over an
     * item and tried to interact with it. If 
     * yes, pickup item and alert the world
     */
    private void isOverPickUp()
    {
        PickUps pickUp = (PickUps) getOneIntersectingObject(PickUps.class);
        if (pickUp != null && Greenfoot.isKeyDown("f"))
        {
            pickUp.pickedUp();
            removeTouching(PickUps.class);
        }
    } // end method isOverPickUp
    
    /**
     * check if the character should take damage from an overlapping enemy
     */
    private void takeDamage() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        takeDamageDelay--;
        if (takeDamageDelay < 1 && enemy != null && enemy.getIsAttacking()) {
            health -= enemy.damageAmount();
            HealthBar healthBar = (HealthBar) getWorld().getObjects(HealthBar.class).get(0);
            healthBar.update(health);
            GreenfootSound gfs = new GreenfootSound("damageTaken.wav");
            gfs.setVolume(90);
            gfs.play();
            if (health < 0) {
                SurvivalWorld world = (SurvivalWorld) getWorld();
                world.lost();             
            } else {
                takeDamageDelay = takeDamageDelayMax;
            } // end if/else
        } // end if
    } // end method takeDamage
    
    /**
     * animations - set the character image based on certain conditions
     */
    private void animations(boolean isMovingLeft, boolean isMovingRight) {
        String currentImage = "alien idle.png";
        animTimer--;
        if(animTimer == 0) {
            animTimer = animTimerMax;
        } // end if
        
        if (isMovingLeft) {
            if (animTimer < 10) {
                currentImage = "alien walk l2.png";
            } else {
                currentImage = "alien walk l1.png";
            } // end if/else
        } // end if
        
        if (isMovingRight) {
            if ( animTimer < 10) {
                currentImage = "alien walk r2.png";
            } else {
                currentImage = "alien walk r1.png";
            } // end if/else
        } // end if
        animation = new GreenfootImage (currentImage);
        setImage(animation);
    } // end method animations
} // end class character
