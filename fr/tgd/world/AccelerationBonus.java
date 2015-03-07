package fr.tgd.world;

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
	
	public void used(){
		WorldGenGame.character.setWallSpeed(0.4);
	}

	
	
}
