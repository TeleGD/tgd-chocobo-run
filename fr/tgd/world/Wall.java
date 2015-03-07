package fr.tgd.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


public class Wall extends Rectangle {
	

	public Wall(double x, double y, double w , double h) {
		super(x, y,w,h);
	}
	
	public void update(int delta) {
		setY(getY()+Character.wallSpeed*delta);
	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHight());
	}
	
	
}


