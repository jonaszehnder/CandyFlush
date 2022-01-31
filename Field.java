import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fields here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Field extends Objects
{
    private Colour COLOUR;
    
    public Field(){
        switch(Greenfoot.getRandomNumber(5)){
            case 0: COLOUR = Colour.RED;
                    setImage(new GreenfootImage("red.png"));
                    break;
            case 1: COLOUR = Colour.GREEN;
                    setImage(new GreenfootImage("green.png"));
                    break;
            case 2: COLOUR = Colour.LIME;
                    setImage(new GreenfootImage("lime.png"));
                    break;
            case 3: COLOUR = Colour.YELLOW;
                    setImage(new GreenfootImage("yellow.png"));
                    break;
            case 4: COLOUR = Colour.BLUE;
                    setImage(new GreenfootImage("blue.png"));
                    break;
        }
        getImage().scale(getImage().getWidth()/10, getImage().getHeight()/10);
    }
    
    public Colour getColour(){
        return COLOUR;
    }
}
