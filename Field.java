import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Field extends Actor
{
    private Colour COLOUR;
    private int x;
    private int y;
    public Field(int x, int y){
        this.x = x;
        this.y = y;
        switch(Greenfoot.getRandomNumber(5)){
            case 0:
                setColour(Colour.RED);
                break;
            case 1:
                setColour(Colour.GREEN);
                break;
            case 2:
                setColour(Colour.LIME);
                break;
            case 3:
                setColour(Colour.YELLOW);
                break;
            case 4:
                setColour(Colour.BLUE);
                break;
        }
    }
    public void act(){
        if (Greenfoot.mouseClicked(this)) {
            setImage(new GreenfootImage(getColour().toString().toLowerCase() + "Clicked.png"));
            getImage().scale(getImage().getWidth()/10, getImage().getHeight()/10);
            ((CandyFlushWorld)getWorld()).setClickedTiles(this);
        }
    }
    public Colour getColour(){
        return COLOUR;
    }
    public void setColour(Colour colour){
        switch(colour){
            case RED: 
                this.COLOUR = Colour.RED; 
                setImage(new GreenfootImage("red.png"));
                break;
            case GREEN: 
                this.COLOUR = Colour.GREEN; 
                setImage(new GreenfootImage("green.png"));
                break;
            case LIME: 
                this.COLOUR = Colour.LIME; 
                setImage(new GreenfootImage("lime.png"));
                break;
            case YELLOW: 
                this.COLOUR = Colour.YELLOW; 
                setImage(new GreenfootImage("yellow.png"));
                break;
            case BLUE:
                this.COLOUR = Colour.BLUE; 
                setImage(new GreenfootImage("blue.png"));
                break;
        }
        getImage().scale(getImage().getWidth()/10, getImage().getHeight()/10);
    }
    public int getXPlace(){
        return this.x;
    }
    public int getYPlace(){
        return this.y;
    }
}
