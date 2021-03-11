package games.firstCodingNightEver;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import games.firstCodingNightEver.world.BonusGenerator;
import games.firstCodingNightEver.world.Character;
import games.firstCodingNightEver.world.WallGenerator;
import games.firstCodingNightEver.world.Map;

public class World extends BasicGameState {

	static public int hauteurW;
	static public int largeurW;
	static public int[] scoreList;

	private int ID;
	private int state;

	public Map map;
	private WallGenerator gen;
	private BonusGenerator ben;
	public Character character;
	public boolean[] currentKeysPressed;

	static {
		World.hauteurW = 600;
		World.largeurW = 800;
		World.scoreList = new int[5];
	}

	public World(int ID) {
		this.ID = ID;
		this.state = 0;
	}

	@Override
	public int getID() {
		return this.ID;
	}

	public void init(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois au chargement du programme */
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée à l'apparition de la page */
		if (this.state == 0) {
			this.play(container, game);
		} else if (this.state == 2) {
			this.resume(container, game);
		}
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée à la disparition de la page */
		if (this.state == 1) {
			this.pause(container, game);
		} else if (this.state == 3) {
			this.stop(container, game);
			this.state = 0; // TODO: remove
		}
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		/* Méthode exécutée environ 60 fois par seconde */
		g.setColor(Color.white);
		g.fillRect(0, 0, container.getWidth(), container.getHeight());
		g.translate((int) ((container.getWidth() - map.getW()) / 2), 0);
		map.render(g);
		character.render(g);
		g.translate(-(int) ((container.getWidth() - map.getW()) / 2), 0);
		g.setColor(Color.black);
		g.fillRect((float) (container.getWidth() - map.getW()) / 2 - 20, 0,
				20, container.getHeight());
		g.fillRect((float) ((container.getWidth() - map.getW()) / 2 + map
				.getW()), 0, 20, container.getHeight());

	}

	public void addScore(int score) {
		int min = scoreList[0];
		int imin = 0;
		for (int i = 1; i < 5; i++) {
			int k = scoreList[i];
			if (k < min) {
				min = k;
				imin = i;
			}
		}
		if (score >= min) {
			scoreList[imin] = score;
		}
	}

	public void update(GameContainer container, StateBasedGame game, int delta) {
		/* Méthode exécutée environ 60 fois par seconde */
		Input input = container.getInput();
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			this.setState(1);
			game.enterState(2 /* MainMenu */);
		}
		map.update(delta);
		character.update(delta);
		gen.update(delta);
		ben.update(delta);

		if (character.isDead()) {

			int dernierScore = (int) this.character.getScore();
			game.enterState(3 /* GOMenu */);
			addScore(dernierScore);
			character.setDead(false);
			map.removeAllWalls();
			character.setScore(0);
		}

	}

	public void play(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois au début du jeu */
		Map map = new Map();
		this.map = map;
		this.gen = new WallGenerator(this);
		this.ben = new BonusGenerator(this);
		this.character = new Character(this, 400d, 500d, 100, 0.3f, 10);
		this.currentKeysPressed = new boolean[2];
	}

	public void pause(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la mise en pause du jeu */
		Character character = this.character;
		character.getTimerShield().pause();
		character.getTimerDouble().pause();
		character.getTimerAccel().pause();
		character.getTimerInv().pause();
	}

	public void resume(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la reprise du jeu */
		character.getTimerShield().resume();
		character.getTimerDouble().resume();
		character.getTimerAccel().resume();
		character.getTimerInv().resume();
	}

	public void stop(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois à la fin du jeu */
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return this.state;
	}

	public void keyReleased(int key, char c) {
		switch (key) {
		case Input.KEY_LEFT:
				this.currentKeysPressed[0]=false;
				if(this.currentKeysPressed[1])
					character.setMovement(1);
				if(this.currentKeysPressed[0]==false && this.currentKeysPressed[1]==false)
					character.setMoving(false);
				break;
		case Input.KEY_RIGHT:
				this.currentKeysPressed[1]=false;
				if(this.currentKeysPressed[0])
					character.setMovement(0);
				if(this.currentKeysPressed[0]==false && this.currentKeysPressed[1]==false)
					character.setMoving(false);
				break;
		case Input.KEY_LSHIFT:
			if(character.getIsDash())
			character.setSpeedX(character.getSpeedX()/2);
			character.setIsDash(false);
			break;

		case Input.KEY_S:
			break;
		}
	}

	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_LEFT:
			this.currentKeysPressed[0]=true;
			character.setMoving(true);
			character.setMovement(0);
			break;
		case Input.KEY_RIGHT:
			this.currentKeysPressed[1]=true;
			character.setMoving(true);
			character.setMovement(1);
			break;
		case Input.KEY_LSHIFT:
			if (character.getStamina() >= 50) {
				character.setSpeedX(character.getSpeedX()*2);
				character.setIsDash(true);
			}
			break;
		}
	}

}
