package fr.tgd.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import fr.tgd.main.WorldGenGame;
import fr.tgd.util.Collisions;

public class Inversion extends Bonus{

	public Inversion(double x, double y, int radius) {
		super(x, y, radius);
	}
	
	public void update(int delta){
		super.update(delta);
	}
	
	public void render(Graphics g){
		g.setColor(Color.cyan);
		g.fillOval((float) x-radius, (float) y-radius, 10, 10);
	}
	
	public void used(){
		WorldGenGame.character.inv=true;
		WorldGenGame.character.setColor(Color.cyan);
		WorldGenGame.character.setSpeedX(-0.3f);
		WorldGenGame.character.getTimerInv().start();
		
	}

	
	
}
