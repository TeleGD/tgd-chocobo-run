package fr.tgd.world;

import java.awt.Color;

import org.newdawn.slick.Graphics;

import fr.tgd.util.Collisions;

public class Character extends Circle  {
	protected int stamina;
	protected float speedX;
	protected int movement;
	protected boolean isDash;
	protected int speedDash;
	public static double wallSpeed = 0.1;
	private World world;
	private boolean dead=false;
	protected double c;
	private boolean invicible=false;
	
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
	public Character(World world, double x, double y, int stamina, float speedX, int radius) {
		super(x, y,radius);
		this.world = world;
		this.stamina = stamina;
		this.speedX = speedX;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public boolean isInvicible() {
		return invicible;
	}
	public void setInvicible(boolean invicible) {
		this.invicible = invicible;
	}
	public float getSpeedX() {
		return speedX;
	}
	public void setSpeedX(float speed) {
		this.speedX = speed;
	}
	
	public void movement(int delta) {
		if(Collisions.collisionCircleAnyRect(this)){
			die();
		}
		if(isMoving){
			switch(movement) {
			case 0 :
				x-=speedX*delta;
				 if (Collisions.collisionCircleAnyRect(this) || this.x<=radius){
					 x+=speedX*delta;
					 }
				break;
			case 1 : 
				x+=speedX*delta;
				 if(Collisions.collisionCircleAnyRect(this) || this.x>=world.getW()-radius){
					 x-=speedX*delta;}
				break;
		}
		}
	}
	
		
	public void consumeStamina() {
		if (isDash && stamina>=0){
			stamina-=20;
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
	
	public void die(){
		c=0;
		wallSpeed = 0.1;
		dead = true;
	}
	
	public void score(int delta){
		c+=wallSpeed*delta;
	}
	
	public double getScore(){
		return c;
	}
	
	public boolean isDead(){
		return dead;
	}
	public void setDead(Boolean dead){
		this.dead = dead;
	}
	
	
	
	public void update(int delta) {
	movement(delta);
	recoverStamina();
	consumeStamina();
	score(delta);
	}

	public void render(Graphics g) {
		g.drawOval((float) x-radius, (float) y-radius, 20, 20);
		g.fillRect(-150, 25, stamina/100, 25);
		g.drawString(""+(int)getScore(),-150,50);
	}
	
	
	
}
