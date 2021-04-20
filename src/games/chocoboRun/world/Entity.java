package games.chocoboRun.world;

import org.newdawn.slick.Graphics;

import games.chocoboRun.World;

public abstract class Entity {

	protected World world;
	protected double x, y;

	public Entity(World world, double x, double y) {
		super();
		this.world = world;
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	public abstract void update(int delta);
	public abstract void render(Graphics g);

}
