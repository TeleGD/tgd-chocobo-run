package fr.tgd.main;

import org.newdawn.slick.Input;

import fr.tgd.world.Entity;

public class Character extends Entity {
	protected int stamina=100;
	protected float speed=0.3f;
	protected double radius;
	public Character(double x, double y, int stamina, float speed, double radius ) {
		super(x, y);
		this.stamina = stamina;
		this.speed = speed;
		this.radius= radius;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public float getSpeed() {
		return speed;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public void movements(int delta){
		
	}
	@Override
	public void update() {
		
	}
	@Override
	public void render() {
		
	}
	
	
	
	
}
