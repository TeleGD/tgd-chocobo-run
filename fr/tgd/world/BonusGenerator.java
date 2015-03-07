package fr.tgd.world;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import fr.tgd.main.WorldGenGame;
import fr.tgd.util.Collisions;


public class BonusGenerator {
	private World world ;
	private int nextInterval,time ;
	private static int minInterval=200;
	private static int maxInterval=450;
	public Random rand = new Random();
	
	public BonusGenerator(World world) {
		this.world = world;
	}
	
	public void update(int delta,GameContainer container) {
			time++;
			if (time>nextInterval/(Character.wallSpeed)*18){
				int posX=rand.nextInt((int)world.getW());
				Bonus bonus = new Shield(posX,0,5);
				World.bonuses.add(bonus);
				if(Collisions.collisionCircleAnyRect(bonus))
					World.bonuses.remove(bonus);
				time=0;
			}
			nextInterval= rand.nextInt(maxInterval-minInterval)+minInterval ; 
	}

}
