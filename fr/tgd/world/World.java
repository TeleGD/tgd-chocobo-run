package fr.tgd.world;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

public class World
{
	static ArrayList<Wall> walls = new ArrayList<Wall>();
	
	private Character character = new Character(0, 0, 0, 0, 0);
	private double w = 500;
	
	public void addWall(Wall wall)
	{
		walls.add(wall);
	}
	
	public void removeWall(Wall wall)
	{
		walls.remove(wall);
	}
	
	public double getW()
	{
		return w;
	}
	
	public void render(Graphics g)
	{
		for(Wall wall : walls)
		{
			wall.render(g);
		}
	}
	
	public void update(int delta)
	{
		for(Wall wall : walls)
		{
			wall.update(delta);
		}
	}
	
	public static ArrayList<Wall> getWalls(){
		return walls;
	}
}
