import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ShuffleButton extends Actor
{
    public ShuffleButton(){
        getImage().scale(getImage().getWidth()/15, getImage().getHeight()/15);
    }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            ((CandyFlushWorld)getWorld()).shuffleFields();
        }
    }
}
