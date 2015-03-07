package fr.tgd.world;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

public class World
{
	ArrayList<Wall> walls = new ArrayList<Wall>();
	
	public void addWall(Wall wall)
	{
		walls.add(wall);
	}
	
	public void removeWall(Wall wall)
	{
		walls.remove(wall);
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
}
