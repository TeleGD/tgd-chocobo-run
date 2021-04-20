package games.chocoboRun.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import games.chocoboRun.World;
import games.chocoboRun.util.Collisions;
import games.chocoboRun.util.Timer;

public class Character extends Circle {

	protected int stamina;
	public float speedX;
	protected int movement;
	protected boolean isDash;
	protected int speedDash;
	public double wallSpeed;
	private boolean dead;
	protected double c;
	private boolean invincible;
	private int mult;
	private Color color;
	public boolean inv;
	protected boolean isMoving;
	private Timer timerShield;
	private Timer timerDouble;
	private Timer timerAccel;
	private Timer timerInv;

	public double getWallSpeed() {
		return wallSpeed;
	}

	public void setWallSpeed(double wallSpeed) {
		this.wallSpeed = wallSpeed;
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
		this.isDash = isDash;
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

	public Character(World world, double x, double y, int stamina,
			float speedX, int radius) {
		super(world, x, y, radius);
		this.stamina = stamina;
		this.speedX = speedX;
		this.wallSpeed = .1;
		this.mult = 1;
		this.color = Color.black;
		this.timerShield = new Timer();
		this.timerDouble = new Timer();
		this.timerAccel = new Timer();
		this.timerInv = new Timer();
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
		if (Collisions.collisionCircleAnyRect(this, this.world.map) && invincible == false) {
			die();
		}
		if (Collisions.collisionCircleAnyCircle(this, this.world.map)) {
			world.map.getCollidingBonus(this).used();
			this.world.map.bonuses.remove(
					world.map.getCollidingBonus(this));
		}
		if (world.currentKeysPressed[1]
				|| world.currentKeysPressed[0]) {
			if (isMoving) {
				switch (movement) {
				case 0:
					x -= speedX * delta;
					if ((Collisions.collisionCircleAnyRect(this, this.world.map) && !invincible)|| this.x <= radius|| this.x >= this.world.map.getW() - radius) {
						x += speedX * delta;
					}
					break;
				case 1:
					x += speedX * delta;
					if ((Collisions.collisionCircleAnyRect(this, this.world.map) && !invincible)|| this.x >= this.world.map.getW() - radius|| this.x <= radius) {
						x -= speedX * delta;
					}
					break;
				}
			}
		}
	}

	public void consumeStamina(int delta) {
		if (isDash && stamina > 0) {
			stamina -= 10 * delta;
		} else if (stamina <= 0) {
			setIsDash(false);
			if(inv)
				setSpeedX(-0.3f);
			else
				setSpeedX(0.3f);


			if (isDash && stamina>0){
				stamina -= 10 * delta;
			}else if(stamina <=0) {
				setIsDash(false);
				if(inv)
					setSpeedX(-0.3f);
				else
					speedX=0.3f;
			}
		}
	}

	public int recoverStamina(int delta) {
		if (stamina < 10000) {// 12s pour devenir full
			stamina += delta;
		}
		return stamina;
	}

	public void die() {
		wallSpeed = 0.1;
		dead = true;
		color = Color.black;
		mult = 1;
		this.world.currentKeysPressed[0] = false;
		this.world.currentKeysPressed[1] = false;
	}

	public void score(int delta) {
		c += wallSpeed * delta * mult;
	}

	public double getScore() {
		return c;
	}

	public void setScore(double score) {
		c = score;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(Boolean dead) {
		this.dead = dead;
	}

	public void update(int delta) {
		movement(delta);
		if (timerShield.getTime() > 5000
				&& !Collisions.collisionCircleAnyRect(this, this.world.map)) {
			color = Color.black;
			invincible = false;
			timerShield.stop();
		}
		if (timerDouble.getTime() > 5000
				&& !Collisions.collisionCircleAnyRect(this, this.world.map)) {
			color = Color.black;
			mult = 1;
			timerDouble.stop();
		}
		if (timerAccel.getTime() > 5000
				&& !Collisions.collisionCircleAnyRect(this, this.world.map)) {
			color = Color.black;
			if (wallSpeed <= 0.2f)
				wallSpeed = 0.1f;
			else
				wallSpeed -= 0.2f;
			timerAccel.stop();
		}
		if(timerInv.getTime()>5000 && !Collisions.collisionCircleAnyRect(this, this.world.map)){
			color=Color.black;
			speedX=0.3f;
			inv = false;
			timerInv.stop();
		}
		recoverStamina(delta);
		consumeStamina(delta);
		score(delta);

	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((float) x - radius, (float) y - radius, 20, 20);
		g.setColor(Color.black);
		g.fillRect(-150, 450, stamina / 100, 25);
		g.drawString("" + (int) getScore(), -150, 500);
	}

	public void setColor(Color color) {
		this.color = color;
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

	public Timer getTimerInv() {
		return timerInv;
	}

}
