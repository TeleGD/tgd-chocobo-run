package fr.tgd.menus;

import java.awt.Font;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tgd.main.WorldGenGame;
import fr.tgd.world.Character;
import fr.tgd.world.World;

public class ScoreMenu extends BasicGameState {

	public static int ID = 7;

	private String nom = "Meilleurs Scores";

	private String[] items = new String[6];

	public int nbrOption = items.length;

	public String[] getItems() {
		return this.items;
	}

	static GameContainer container;
	static StateBasedGame game;
	int selection = 0;

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.container = container;
		container.setShowFPS(false);
		this.game = game;
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		g.setColor(Color.red);

		g.drawString(this.nom, 200, 200);

		g.setColor(Color.white);

		items[0] = "Retour Menu";

		for (int k = 1; k< nbrOption; k++) {
			items[k] = WorldGenGame.scoreList[k-1].toString();
		}

		nbrOption = this.items.length;

		for (int i = 0; i < nbrOption; i++) {
			g.drawString(this.items[i], 300, 230 + 50 * i);
		}
		g.drawString(">>", 230, 230 + 50 * selection);
	}

	@Override
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_ENTER:
			game.enterState(MainMenu.ID);
			break;
		}
	}


	public int getID() {
		return ID;
	}

}
