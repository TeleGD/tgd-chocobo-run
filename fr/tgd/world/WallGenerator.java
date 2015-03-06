package fr.tgd.world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class WallGenerator {
	private World world ;
	private int nextInterval,time ;
	private static int minInterval=50 ;
	private static int maxInterval=100 ;
	public Random rand = new Random();
	
	private static int holeSize = 25 ; 
	
	public WallGenerator(World world) {
		this.world= world;
	}
	
	public void update() {
		time++ ; 
		if(time > nextInterval) {
			ArrayList<Double> wallPos = calcWallPos();
			
			for(int i=0; i<(wallPos.size())/2+1; i++)
			{
				double xLeft = 0, xRight = 800;
				if(i!=0)
					xLeft = wallPos.get(2*i-1);
				if(i != (wallPos.size())/2)
					xRight = wallPos.get(2*i);
				Wall wall = new Wall(xLeft, 0, xRight-xLeft, 20);
				world.addWall(wall);
			}
			
			time=0;
			nextInterval= rand.nextInt(maxInterval-minInterval)+minInterval ; 
		}
	}

	private ArrayList<Double> calcWallPos() {
		ArrayList<Double> pos = new ArrayList<Double>();
		
		for (int i =0 ; i< 3 ;i++){
			int x = rand.nextInt(800);
			pos.add((double)(x-holeSize));
			pos.add((double)(x+holeSize)) ;
		}
		Collections.sort(pos);
		return pos;
	}
}
