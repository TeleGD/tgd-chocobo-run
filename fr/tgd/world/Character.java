package fr.tgd.world;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import fr.tgd.main.WorldGenGame;
import fr.tgd.util.Collisions;
import fr.tgd.util.Timer;

public class Character extends Circle  {
	protected int stamina;
	protected float speedX;
	protected int movement;
	protected boolean isDash;
	protected int speedDash;
	public static double wallSpeed = 0.1;
	private World world;
	private boolean dead=false;
	protected static double c;
	private boolean invincible=false;
	private int mult=1;
	private Color color=Color.black;
	
	private Timer timerShield=new Timer();
	private Timer timerDouble=new Timer();
	private Timer timerAccel=new Timer();
	
	public double getWallSpeed() {
		return wallSpeed;
	}
	public void setWallSpeed(double wallSpeed) {
		Character.wallSpeed = wallSpeed;
	}
	public int getMult() {
		return mult;
	}
	public void setMult(int mult) {
		this.mult = mult;
	}
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
	public boolean isInvincible() {
		return invincible;
	}
	public void setInvincible(boolean invicible) {
		this.invincible = invicible;
	}
	public float getSpeedX() {
		return speedX;
	}
	public void setSpeedX(float speed) {
		this.speedX = speed;
	}
	
	public void movement(int delta) {
		if(Collisions.collisionCircleAnyRect(this)&&invincible == false){
			die();
		}
		if(Collisions.collisionCircleAnyCircle(this)){
			WorldGenGame.world.getCollidingBonus(this).used();
			World.getBonuses().remove(WorldGenGame.world.getCollidingBonus(this));
		}
		if(isMoving){
			switch(movement) {
			case 0 :
				x-=speedX*delta;
				 if ((Collisions.collisionCircleAnyRect(this)&&!invincible) || this.x<=radius){
					 x+=speedX*delta;
					 }
				break;
			case 1 : 
				x+=speedX*delta;
				 if((Collisions.collisionCircleAnyRect(this)&&!invincible) || this.x>=world.getW()-radius){
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
		wallSpeed = 0.1;
		dead = true;
		color=Color.black;
		mult=1;
	}
	
	public void score(int delta){
		c+=wallSpeed*delta*mult;
	}
	
	public static double getScore(){
		return c;
	}
	public void setScore(double score){
		c=score;
	}
	
	public boolean isDead(){
		return dead;
	}
	public void setDead(Boolean dead){
		this.dead = dead;
	}
	
	
	
	public void update(int delta) {
	movement(delta);
	if(timerShield.getTime()>5000 && !Collisions.collisionCircleAnyRect(this)){
		color=Color.black;
		invincible=false;
		timerShield.stop();
	}
	if(timerDouble.getTime()>5000 && !Collisions.collisionCircleAnyRect(this)){
		color=Color.black;
		mult=1;
		timerDouble.stop();
	}
	if(timerAccel.getTime()>5000 && !Collisions.collisionCircleAnyRect(this)){
		color=Color.black;
		wallSpeed-=0.2f;
		timerAccel.stop();
	}
	recoverStamina();
	consumeStamina();
	score(delta);
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.drawOval((float) x-radius, (float) y-radius, 20, 20);
		g.setColor(Color.black);
		g.fillRect(-150, 25, stamina/100, 25);
		g.drawString(""+(int)getScore(),-150,50);
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	public Timer getTimerShield() {
		return timerShield;
	}
	public Timer getTimerDouble() {
		return timerDouble;
	}
	public Timer getTimerAccel() {
		return timerAccel;
	}
	
	
	
}
