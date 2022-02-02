import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ShuffleButton extends Actor
{
    public ShuffleButton(){
        //Bild setzen
        getImage().scale(getImage().getWidth()/15, getImage().getHeight()/15);
    }
    public void act() {
        //Wenn Shuffle Button gedrückt wird
        if (Greenfoot.mouseClicked(this)) {
            ((CandyFlushWorld)getWorld()).shuffleFields();
        }
    }
}
