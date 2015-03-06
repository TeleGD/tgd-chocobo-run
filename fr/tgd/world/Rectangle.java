package fr.tgd.world;

import org.newdawn.slick.Graphics;

public abstract class Rectangle extends Entity{

	double width,hight;
	
	public Rectangle(double x,double y,double width,double hight){
		super(x,y);
		this.width=width;
		this.hight=hight;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}
	
	public abstract void update(int delta);
	public abstract void render(Graphics g);
}

