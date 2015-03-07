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
			if (time>nextInterval/(Character.wallSpeed)*10){
				int posX=rand.nextInt((int)world.getW());
				Bonus bonus=null;
				switch(rand.nextInt(4)){
				case 0:
					bonus = new Shield(posX,0,5);
					World.bonuses.add(bonus);
					break;
				case 1:
					bonus = new DoubleScoreBonus(posX,0,5);
					World.bonuses.add(bonus);
					break;
				case 2:
					bonus = new Inversion(posX,0,5);
					World.bonuses.add(bonus);
					break;
				case 3:
					bonus = new AccelerationBonus(posX,0,5);
					World.bonuses.add(bonus);
					break;
				}
				
				if(Collisions.collisionCircleAnyRect(bonus))
					World.bonuses.remove(bonus);
				time=0;
			}
			nextInterval= rand.nextInt(maxInterval-minInterval)+minInterval ; 
	}
}
