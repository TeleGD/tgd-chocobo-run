package fr.tgd.main;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import fr.tgd.world.Entity;

public class Character extends Circle  {
	protected int stamina=100;
	protected float speedX;
	protected int movement;
	protected boolean isMoving;
	protected double nextX;
	public Character(double x, double y, int stamina, float speedX, double radius ) {
		super(x, y,radius);
		this.stamina = stamina;
		this.speedX = speedX;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public float getSpeedX() {
		return speedX;
	}
	public void setSpeedX(float speed) {
		this.speedX = speed;
	}
	
	public void movement(int delta) {
		if(isMoving){
			switch(movement) {
			case 0 :
				nextX=x+speedX*delta;
				if(!) {
					x=nextX;
				}
				while(){
					nextX--;
				}
				x=nextX;
				break;
			
			case 1 :
				nextX=x+speedX*delta;
				if(!){
					x=nextX;
				}
				while(){
					nextX++;
				}
				
			}
		}
		}	
		
	
	
	@Override
	public void update() {
		
	}
	@Override
	public void render(Graphics g) {
		g.circle(radius);
	}
	
	
	
	
}
