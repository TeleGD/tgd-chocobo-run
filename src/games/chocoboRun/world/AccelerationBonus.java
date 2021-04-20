package games.chocoboRun.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import games.chocoboRun.World;
import games.chocoboRun.util.Collisions;

public class AccelerationBonus extends Bonus{

	public AccelerationBonus(World world, double x, double y, int radius) {
		super(world, x, y, radius);
	}

	public void update(int delta){
		super.update(delta);
		if(timer.getTime()>3000 && !Collisions.collisionCircleAnyRect(this.world.character, this.world.map)){
			this.world.character.setInvincible(false);
			timer.stop();
		}
	}

	public void render(Graphics g){
		g.setColor(Color.magenta);
		g.fillOval((float) x-radius, (float) y-radius, 10, 10);
	}

	public void used(){
		this.world.character.setColor(Color.magenta);
		this.world.character.setWallSpeed(this.world.character.getWallSpeed()+0.2f);
		this.world.character.getTimerAccel().start();

	}



}
