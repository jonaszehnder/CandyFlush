import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShuffleButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShuffleButton extends Objects
{
    public ShuffleButton(){
        getImage().scale(getImage().getWidth()/15, getImage().getHeight()/15);
    }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            ((MyWorld)getWorld()).shuffleFields();
        }
    }
}
