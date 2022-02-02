import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Turns extends Actor
{
    public void act()
    {
        //Setzen des Turn-Counters
        setImage(new GreenfootImage("Turns left: " + CandyFlushWorld.turns, 24, Color.GREEN, Color.BLACK));
    }
}
