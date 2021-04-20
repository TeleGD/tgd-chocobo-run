package games.chocoboRun.world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import games.chocoboRun.World;

public class WallGenerator {

	private static int minInterval=200;
	private static int maxInterval=450;
	private static double coef=0.0015;
	private static int holeSize = 50;

	private World world;
	private int nextInterval;
	private int time;
	public Random rand;
	public int nbWall;

	public WallGenerator(World world) {
		this.world = world;
		this.rand = new Random();
	}

	public void update(int delta) {
		time += delta;
		if (time > 200 / this.world.character.wallSpeed) {
			ArrayList<Double> wallPos = calcWallPos();

			for(int i=0; i<(wallPos.size())/2+1; i++)
			{
				double xLeft = 0, xRight = this.world.map.getW();
				if(i!=0)
					xLeft = wallPos.get(2*i-1);
				if(i != (wallPos.size())/2)
					xRight = wallPos.get(2*i);
				Wall wall = new Wall(this.world, xLeft, 0, xRight-xLeft, 20);
				this.world.map.addWall(wall);
				this.world.character.wallSpeed += coef;
				nbWall++;
			}
			time=0;
			nextInterval= rand.nextInt(maxInterval-minInterval)+minInterval ;
		}
	}

	private ArrayList<Double> calcWallPos() {
		ArrayList<Double> pos = new ArrayList<Double>();
		ArrayList<WallDim> dims = new ArrayList<WallDim>();
		for(int i=0; i<3; i++)
		{
			dims.add(new WallDim((double)rand.nextInt((int)this.world.map.getW()-holeSize*2)+holeSize, (double)holeSize));
		}

		boolean holeMerged = true;
		while(holeMerged)
		{
			dims.sort(new WallDimComparator());


			holeMerged = false;
			for(int i=0; i<dims.size() && !holeMerged; i++)
			{
				for(int j=i+1; j<dims.size() && !holeMerged; j++)
				{
					double xLi = dims.get(i).getXLeft();
					double xRi = dims.get(i).getXRight();
					double xRj = dims.get(j).getXRight();
					double xLj = dims.get(j).getXLeft();
					if(xRi > xLj)
					{
						double xC = (xLi+xRj)/2;
						double dim = (xRj-xLi)/2;

						dims.remove(j);
						dims.remove(i);
						dims.add(new WallDim(xC, dim));
						holeMerged = true;
					}
				}
			}
		}

		for(int i=0; i<dims.size(); i++)
		{
			pos.add(dims.get(i).getXLeft());
			pos.add(dims.get(i).getXRight());
		}
		Collections.sort(pos);
		return pos;
	}

	private class WallDim
	{
		public double center, dim;

		public WallDim(double center, double dim)
		{
			this.center = center;
			this.dim = dim;
		}

		public double getXLeft()
		{
			return center - dim;
		}

		public double getXRight()
		{
			return center + dim;
		}
	}

	private class WallDimComparator implements Comparator<WallDim>
	{

		@Override
		public int compare(WallDim o1, WallDim o2) {
			return (int) (o1.center-o2.center);
		}

	}
}
