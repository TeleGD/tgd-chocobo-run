package games.chocoboRun.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import games.chocoboRun.World;

public class DoubleScoreBonus extends Bonus {

	public DoubleScoreBonus(World world, double x, double y, int radius) {
		super(world, x, y, radius);
	}

	public void update(int delta){
		super.update(delta);
	}

	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillOval((float) x-radius, (float) y-radius, 10, 10);
	}

	public void used(){
		this.world.character.setMult(2);
		this.world.character.setColor(Color.red);
		this.world.character.getTimerDouble().start();
	}

}
