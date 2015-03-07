package fr.tgd.world;

import fr.tgd.main.WorldGenGame;

public class DoubleScoreBonus extends Bonus {

	public DoubleScoreBonus(double x, double y, int radius) {
		super(x, y, radius);
	}
	
	public void used(){
		WorldGenGame.character.score(delta,2);
	}

}
