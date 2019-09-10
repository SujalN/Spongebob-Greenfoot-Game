import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the parent class for all falling objects in the game. Its code is 
 * universal amongst subclasses.
 * 
 * @author Sujal Nahata
 * @version v1 08/09/2019
 */
public class FallingObjects extends Actor
{
    private int dropSpeed = 1;
    private boolean onBottom = false;
    /**
     * Execute the fall method.
     */
    public void act() 
    {
        fall();
    }
    /**
     * If an object is not at the bottom of the screen, make it fall at 
     * dropSpeed.
     */
    public void fall()
    {
    if (! onBottom) {
          this.setLocation(getX(), getY() + dropSpeed);
          onBottom = checkBottom();
    }
    }
    /**
     * If the object generated is higher in the Y position that 570, it falls
     * at dropSpeed.
     */
    public boolean checkBottom()
    {
      if (getY() > 570){
          return true;
      }
      else {
          return false;
      }
    }
}
