package games.firstCodingNightEver.world;

import java.util.Random;

import org.newdawn.slick.GameContainer;

import games.firstCodingNightEver.World;
import games.firstCodingNightEver.util.Collisions;


public class BonusGenerator {

	private static int minInterval=200;
	private static int maxInterval=450;

	private World world;
	private int nextInterval;
	private int time;
	public Random rand;

	public BonusGenerator(World world) {
		this.world = world;
		this.rand = new Random();
	}

	public void update(int delta) {
			time += delta;
			if (time > 1500 / this.world.character.wallSpeed){
				int posX=rand.nextInt((int)world.map.getW());
				Bonus bonus=null;
				switch(rand.nextInt(4)){
				case 0:
					bonus = new Shield(this.world, posX, 0, 5);
					this.world.map.bonuses.add(bonus);
					break;
				case 1:
					bonus = new DoubleScoreBonus(this.world, posX, 0, 5);
					this.world.map.bonuses.add(bonus);
					break;
				case 2:
					bonus = new Inversion(this.world, posX, 0, 5);
					this.world.map.bonuses.add(bonus);
					break;
				case 3:
					bonus = new AccelerationBonus(this.world, posX, 0, 5);
					this.world.map.bonuses.add(bonus);
					break;
				}

				if(Collisions.collisionCircleAnyRect(bonus, this.world.map))
					this.world.map.bonuses.remove(bonus);
				time=0;
			}
			nextInterval= rand.nextInt(maxInterval-minInterval)+minInterval ;
	}
}
