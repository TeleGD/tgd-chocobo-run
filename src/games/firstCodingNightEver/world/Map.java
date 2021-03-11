package games.firstCodingNightEver.world;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

import games.firstCodingNightEver.util.Collisions;

public class Map {

	public List<Wall> walls;
	public ArrayList<Bonus> bonuses;

	private double w;

	public Map() {
		this.walls = new ArrayList<Wall>();
		this.bonuses = new ArrayList<Bonus>();
		this.w = 500;
	}

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
