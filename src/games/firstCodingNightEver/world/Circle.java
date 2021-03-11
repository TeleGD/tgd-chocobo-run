package games.firstCodingNightEver.world;

import org.newdawn.slick.Graphics;

import games.firstCodingNightEver.World;

public abstract class Circle extends Entity{

	int radius;

	public Circle(World world, double x, double y, int radius) {
		super(world, x, y);
		this.radius=radius;
	}


	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public abstract void update(int delta);
	public abstract void render(Graphics g);


}
