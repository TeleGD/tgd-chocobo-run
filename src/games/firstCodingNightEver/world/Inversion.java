package games.firstCodingNightEver.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import games.firstCodingNightEver.World;

public class Inversion extends Bonus{

	public Inversion(World world, double x, double y, int radius) {
		super(world, x, y, radius);
	}

	public void update(int delta){
		super.update(delta);
	}

	public void render(Graphics g){
		g.setColor(Color.cyan);
		g.fillOval((float) x-radius, (float) y-radius, 10, 10);
	}

	public void used(){
		this.world.character.inv=true;
		this.world.character.setColor(Color.cyan);
		this.world.character.setSpeedX(-0.3f);
		this.world.character.getTimerInv().start();

	}



}
