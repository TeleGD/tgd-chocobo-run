package fr.tgd.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import fr.tgd.main.WorldGenGame;
import fr.tgd.util.Collisions;

public class AccelerationBonus extends Bonus{

	public AccelerationBonus(double x, double y, int radius) {
		super(x, y, radius);
	}
	
	public void update(int delta){
		super.update(delta);
		if(timer.getTime()>3000 && !Collisions.collisionCircleAnyRect(WorldGenGame.character)){
			WorldGenGame.character.setInvincible(false);
			timer.stop();
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.magenta);
		g.fillOval((float) x-radius, (float) y-radius, 10, 10);
	}
	
	public void used(){
		WorldGenGame.character.setColor(Color.magenta);
		WorldGenGame.character.setWallSpeed(WorldGenGame.character.getWallSpeed()+0.2f);
		WorldGenGame.character.getTimerAccel().start();
		
	}

	
	
}
