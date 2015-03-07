package fr.tgd.world;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import fr.tgd.main.WorldGenGame;
import fr.tgd.util.Collisions;
import fr.tgd.util.Timer;

public abstract class Bonus extends Circle {
	
	Timer timer = new Timer();
	public Bonus(double x, double y, int radius) {
		super(x, y, radius);
	}
	
	
	public void update(int delta){
		setY(getY()+Character.wallSpeed*delta);
		
		if(timer.getTime()>5000 && !Collisions.collisionCircleAnyRect(WorldGenGame.character)){
			WorldGenGame.character.setInvincible(false);
			timer.stop();
		}

	}
	
	public abstract void render(Graphics g);
	
	public void used(){
		timer.start();
	}
	
	
	
	
	
}
