package fr.tgd.world;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import fr.tgd.util.Collisions;

public class World {
	static ArrayList<Wall> walls = new ArrayList<Wall>();
	static ArrayList<Bonus> bonuses = new ArrayList<Bonus>();

	private double w = 500;

	public void addWall(Wall wall) {
		walls.add(wall);
	}

	public void removeWall(Wall wall) {
		walls.remove(wall);
	}
	
	public void removeAllWalls(){
		walls.removeAll(walls);
	}

	public double getW() {
		return w;
	}

	public void render(Graphics g) {
		for (Wall wall : walls) {
			wall.render(g);
		}
		for (Bonus bonus :bonuses) {
			bonus.render(g);
		}
	}

	public void update(int delta) {
		for (Wall wall : walls) {
			wall.update(delta);
		}
		for (Bonus bonus : bonuses) {
			bonus.update(delta) ;
		}
	}

	public static ArrayList<Wall> getWalls() {
		return walls;
	}
	
	public static ArrayList<Bonus> getBonuses() {
		return bonuses;
	}

	public Wall getCollidingWall(Circle c) {
		for (Wall wall : walls) {
			if(Collisions.collisionCircleRect(c,wall))
			return wall;
		}
		return null;
	}
	
	public Bonus getCollidingBonus(Circle c) {
		for (Bonus bonus : bonuses) {
			if(Collisions.collisionCircleCircle(c,bonus))
			return bonus;
		}
		return null;
	}
}
