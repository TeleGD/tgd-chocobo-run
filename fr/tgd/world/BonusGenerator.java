package fr.tgd.world;

import java.util.ArrayList;
import java.util.Random;

public class BonusGenerator {
	private World world ;
	private int time ;
	public Random rand = new Random();
	
	public BonusGenerator(World world) {
		this.world = world;
	}
	
	public void update(int delta) {
		time++;
		if ((WallGenerator.nbWall)%10 == 0 ) {
			Bonus bonus = new Bonus(, ,5 ) ;
		}
		
	}
	
	
	
}
