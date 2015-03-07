package fr.tgd.world;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Bonus extends Circle {

	public Bonus(double x, double y, int radius) {
		super(x, y, radius);
	}
	
	
	public void update(int delta){
		setY(getY()+Character.wallSpeed*delta);
	}
	
	public void render(Graphics g){
		g.setColor(Color.green);
		g.drawOval((float) x-radius, (float) y-radius, 10, 10);
	}
	
	
	
	
	
}
