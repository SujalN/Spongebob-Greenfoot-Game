import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the background and world setup of the game. All
 * other class files execute their methods based on this class.
 * 
 * @author Sujal Nahata
 * @version v1 08/09/2019
 */
public class WaterWorld extends World
{
    /**
     * The background is set as the class image (the picture displaying
     * cartoonistic marine life) and sized to 800 by 600 pixels.
     */
    public WaterWorld()
    {    
        super(800, 600, 1);
        prepare();
    }
    /**
     * Images of PirateGold are created at the top of the interaction screen.
     * They spawn at random horizontal locations.
     */
    public void dropGold(){
        PirateGold g = new PirateGold();
        addObject(g,Greenfoot.getRandomNumber(getWidth()),10);
    }
    /**
     * Images of CrabTrap are created at the top of the interaction screen.
     * They spawn at random horizontal locations.
     */
    public void dropTrap(){
        CrabTrap t = new CrabTrap();
        addObject(t,50+Greenfoot.getRandomNumber(getWidth()-100),10);
    }
    /**
     * The PirateGold and CrabTrap elements are dropped at random times.
     */
    public void act(){
        if (Greenfoot.getRandomNumber(120)==5){
            dropGold();
        }
        if (Greenfoot.getRandomNumber(720)==20){
            dropTrap();
        }
    }
    /**
     * A Sbob is spawned at (399, 527) with a size of 328 by 537 pixels.
     */
    private void prepare()
    {
        Sbob sbob = new Sbob();
        addObject(sbob, 328, 537);
        sbob.setLocation(399, 527);
    }
}
