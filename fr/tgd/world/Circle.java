package fr.tgd.world;

import org.newdawn.slick.Graphics;

public abstract class Circle extends Entity{

	int radius;

	public Circle(double x,double y,int radius){
		super(x,y);
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
