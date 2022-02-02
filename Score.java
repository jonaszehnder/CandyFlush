import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor
{
    public void act()
    {
        setImage(new GreenfootImage("Score : " + CandyFlushWorld.points, 24, Color.GREEN, Color.BLACK));
    }
}
