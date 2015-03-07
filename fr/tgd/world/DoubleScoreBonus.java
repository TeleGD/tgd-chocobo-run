package fr.tgd.world;

import fr.tgd.main.WorldGenGame;
import fr.tgd.util.Collisions;

public class DoubleScoreBonus extends Bonus {

	public DoubleScoreBonus(double x, double y, int radius) {
		super(x, y, radius);
	}
	
	public void update(int delta){
		super.update(delta);
		if(timer.getTime()>5000 && !Collisions.collisionCircleAnyRect(WorldGenGame.character)){
			WorldGenGame.character.setInvicible(false);
			timer.stop();
		}
	}
	
	public void used(){
		WorldGenGame.character.setMult(2);
	}

}
