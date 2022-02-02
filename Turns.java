import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Turns extends Actor
{
    public void act()
    {
        setImage(new GreenfootImage("Turns left: " + CandyFlushWorld.turns, 24, Color.GREEN, Color.BLACK));
    }
}
