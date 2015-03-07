package fr.tgd.world;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Graphics;

public class BonusGenerator {
	private World world ;
	private int time ;
	private double x,y ;
	public Random rand = new Random();
	
	public BonusGenerator(World world) {
		this.world = world;
	}
	
	public void update(int delta) {
		time++;
		for (int i=0; i<11;i++) {
			if ((WallGenerator.nbWall)%10 == 0 ) {
				Bonus bonus = new Bonus(x,y,5 ) ;
			}
		}
	}
	
	public void randBonus(double x , double y ) {
		this.x = rand.nextInt(500) ; 
		this.y = rand.nextInt(600) ;
	}
	
	public void render(Graphics g )  {
		g.drawOval(x1, y1, width, height);
		
	}
}
