package fr.tgd.world;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import fr.tgd.util.Collisions;

public class Character extends Circle  {
	protected int stamina;
	protected float speedX;
	protected int movement;
	protected boolean isDash;

	
	public boolean getIsDash() {
		return isDash;
	}
	public void setIsDash(boolean isDash) {
		this.isDash =isDash;
	}
	public int getMovement() {
		return movement;
	}
	public void setMovement(int movement) {
		this.movement = movement;
	}
	public boolean isMoving() {
		return isMoving;
	}
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	protected boolean isMoving;
	public Character(double x, double y, int stamina, float speedX, int radius) {
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
				x-=speedX*delta;
				 if (Collisions.collisionCircleAnyRect(this) || this.x<=200){
					 x+=speedX*delta;
					 }
				break;
			case 1 : 
				x+=speedX*delta;
				 if(Collisions.collisionCircleAnyRect(this) || this.x>=600){
					 x-=speedX*delta;}
				break;
		}
		}
	}
	
		
	public void consumeStamina() {
		if (isDash && stamina>=0){
			stamina-=30;
		}else {setIsDash(false);
				setSpeedX(0.3f);
		}
	}
		
	public int recoverStamina(){
		if(stamina<10000){//12s pour devenir full
			stamina++;
		}
		return stamina;
	}
	
	public int score(){
		int c=0;
		c=(int)(c++);
		return c;
	}
	
	public void update(int delta) {
	movement(delta);
	recoverStamina();
	consumeStamina();
	score();
	System.out.println(stamina);
	}

	public void render(Graphics g) {
		g.drawOval((float) x, (float) y, 10, 10);
		g.fillRect(10, 25, stamina/100, 25);
		g.drawString(""+score(),10, 50);
	}
	
	
	
	
}
