package fr.tgd.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tgd.menus.GOMenu;
import fr.tgd.menus.MainMenu;
import fr.tgd.world.BonusGenerator;
import fr.tgd.world.Character;
import fr.tgd.world.WallGenerator;
import fr.tgd.world.World;

public class WorldGenGame extends BasicGameState {

	public static int ID = 1;

	public static World world = new World();
	private WallGenerator gen = new WallGenerator(world);
	private BonusGenerator ben = new BonusGenerator(world);
	public static Character character;
	

	private GameContainer container;
	StateBasedGame game;
	
	public static Integer[] scoreList = new Integer[] {0, 0, 0, 0, 0};

	// ======================================================================================
	// DECLARATION DES CONSTANTES
	// ======================================================================================

	static public int hauteurW = 600, largeurW = 800;

	// ======================================================================================
	// DECLARATION DES VARIABLES
	// ======================================================================================

	// ======================================================================================
	// CREATEUR
	// ======================================================================================

	// ======================================================================================
	// FONCTION INIT
	// ======================================================================================

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException{
		this.container = container;
		container.setShowFPS(false);
		character = new Character(world, 400d, 500d, 100, 0.3f, 10);
		this.game = game;
	}

	// ======================================================================================
	// FONCTION RENDER
	// ======================================================================================

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
		g.fillRect(0, 0, container.getWidth(), container.getHeight());
		g.translate((int) ((container.getWidth() - world.getW()) / 2), 0);
		world.render(g);
		character.render(g);
		g.translate(-(int) ((container.getWidth() - world.getW()) / 2), 0);
		g.setColor(Color.black);
		g.fillRect((float) (container.getWidth() - world.getW()) / 2 - 20, 0,
				20, container.getHeight());
		g.fillRect((float) ((container.getWidth() - world.getW()) / 2 + world
				.getW()), 0, 20, container.getHeight());

	}

	// ======================================================================================
	// FONCTION UPDATE
	// ======================================================================================

	int time = 0;
	
	public void addScore(Integer score) {
		Integer min = scoreList[0];
		int imin = 0;
		for (int i=1; i<5; i++) {
			int k=scoreList[i];
			if (k<min) {
				min = k;
				imin = i;
			}
		}
		if (score >= min) {
			scoreList[imin] = score;
		}
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		world.update(delta);
		character.update(delta);
		gen.update(delta);
		ben.update(delta,container);
		
		if (character.isDead()) {
			addScore((int)character.getScore());
			character.setScore(0);
			game.enterState(GOMenu.ID);
			character.setDead(false);
			world.removeAllWalls();
		}
		
		

	}

	// ======================================================================================
	// ENTREES CLAVIER
	// ======================================================================================

	public boolean[] currentKeysPressed = new boolean[] { false, false };

	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			game.enterState(MainMenu.ID);
		}
		switch (key) {
		case Input.KEY_LEFT:
			if (currentKeysPressed[1]) {
				character.setMoving(true);
				character.setMovement(1);
			} else {
				character.setMoving(false);
			}
			currentKeysPressed[0] = false;
			break;
		case Input.KEY_RIGHT:
			if (currentKeysPressed[0]) {
				character.setMoving(true);
				character.setMovement(0);
			} else {
				character.setMoving(false);
			}
			currentKeysPressed[1] = false;
			break;
		case Input.KEY_LSHIFT:
			character.setSpeedX(0.3f);
			character.setIsDash(false);
			break;

		case Input.KEY_S:
			break;
		}
	}

	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_LEFT:
			character.setMoving(true);
			character.setMovement(0);
			currentKeysPressed[0] = true;
			break;
		case Input.KEY_RIGHT:
			character.setMoving(true);
			character.setMovement(1);
			currentKeysPressed[1] = true;
			break;
		case Input.KEY_LSHIFT:
			if (character.getStamina() >= 50) {
				character.setSpeedX(0.9f);
				character.setIsDash(true);
			}
			break;

		case Input.KEY_S:
			game.enterState(GOMenu.ID);
			break;
		}
	}

	public int getID() {
		return ID;
	}
}
