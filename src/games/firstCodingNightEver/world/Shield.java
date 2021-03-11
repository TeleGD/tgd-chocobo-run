package games.firstCodingNightEver.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import games.firstCodingNightEver.World;

public class Shield extends Bonus{

	public Shield(World world, double x, double y, int radius){
		super(world, x, y, radius);
	}

	public void update(int delta){
		super.update(delta);
	}

	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillOval((float) x-radius, (float) y-radius, 10, 10);
	}

	public void used(){
		this.world.character.setInvincible(true);
		this.world.character.setColor(Color.green);
		this.world.character.getTimerShield().start();
	}

}
