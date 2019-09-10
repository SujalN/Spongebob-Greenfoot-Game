import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the character that the player controls. This 
 * character can be moved left and right to catch gold and dodge traps.
 * 
 * @author Sujal Nahata
 * @version v1 08/09/2019
 */
public class Sbob extends Actor
{
    private int gold = 0;
    private int trap = 0;
    /**
     * The character moves with respect to the player's left and right arrow
     * controls and the value of the gold varaible increases everytime the 
     * character catches gold.
     */
    public void act() 
    {
        if(canCatchGold()){
            CatchGold();
            gold = gold + 1;
        }
        if(canGetTrapped()){
            GetTrapped();
            trap = trap + 1;
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX() + 1, getY());
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX() - 1, getY());
        }
    }
    /**
     * This boolean method helps to determine whether gold is caught or not.
     */
    private boolean canCatchGold(){
        Actor gold = getOneObjectAtOffset(0, 0, PirateGold.class);
        if(gold != null) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * This is the method that executes code when gold is caught. 
     * It plays a "cha-ching" sound to indicate that event and removes that 
     * piece of gold.
     */
    private void CatchGold(){
        Actor gold = getOneObjectAtOffset(0, 0, PirateGold.class);
        if(gold != null) {
           Greenfoot.playSound("cha_ching.wav");
           getWorld().removeObject(gold);
        }
    }
    /**
     * This boolean method helps to determine whether the sbob character has 
     * touched a trap or not.
     */
    private boolean canGetTrapped(){
        Actor trap = getOneObjectAtOffset(0, 0, CrabTrap.class);
        if(trap != null) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * This is the method that executes code when the sbob is trapped. It 
     * plays a "bonk" sound to indicate that event and removes that piece of 
     * gold.
     */
    private void GetTrapped(){
        Actor trap = getOneObjectAtOffset(0, 0, CrabTrap.class);
        if(trap != null) {
            Greenfoot.playSound("bonk.wav");
            getWorld().removeObject(trap);
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
}