package games.firstCodingNightEver.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import games.firstCodingNightEver.World;

public class Wall extends Rectangle {


	public Wall(World world, double x, double y, double w, double h) {
		super(world, x, y, w, h);
	}

	public void update(int delta) {
		setY(getY()+this.world.character.wallSpeed*delta);
	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHight());
	}


}
