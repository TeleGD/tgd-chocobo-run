package fr.tgd.world;

import org.newdawn.slick.Graphics;

public abstract class Entity {
	protected double x, y;
	
	public Entity(double x, double y) {
		super();
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

	public abstract void update();
	public abstract void render(Graphics g);
	
}
