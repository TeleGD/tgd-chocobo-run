package fr.tgd.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import fr.tgd.main.WorldGenGame;
import fr.tgd.util.Collisions;

public class DoubleScoreBonus extends Bonus {

	public DoubleScoreBonus(double x, double y, int radius) {
		super(x, y, radius);
	}

	public void update(int delta){
		super.update(delta);
	}

	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillOval((float) x-radius, (float) y-radius, 10, 10);
	}

	public void used(){
		WorldGenGame.character.setMult(2);
		WorldGenGame.character.setColor(Color.red);
		WorldGenGame.character.getTimerDouble().start();
	}

}
