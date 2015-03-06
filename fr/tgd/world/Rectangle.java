package fr.tgd.world;

import org.newdawn.slick.Graphics;

public abstract class Rectangle extends Entity{

	int width,hight;
	
	public Rectangle(double x,double y,int width,int hight){
		super(x,y);
		this.width=width;
		this.hight=hight;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}
	
	public abstract void update(int delta);
	public abstract void render(Graphics g);
}

