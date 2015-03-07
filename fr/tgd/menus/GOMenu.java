package fr.tgd.menus;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tgd.main.WorldGenGame;
import fr.tgd.menus.MainMenu;
import fr.tgd.world.Character;
import fr.tgd.world.WallGenerator;
import fr.tgd.world.World;


public class GOMenu extends BasicGameState {

	public static int ID = 3;

	private String nom = "GAME OVER,     score : "+WorldGenGame.dernierScore;
	private String[] items = { "Re-jouer", "Quitter" };

	public int nbrOption = items.length;

	public String[] getItems() {
		return this.items;
	}

	static StateBasedGame game;

	static GameContainer container;
	int selection = 0;

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		this.game = game;
		this.container = container;
		container.setShowFPS(false);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		g.setColor(Color.red);
		// g.setFont(FontManager.menuTitre1TTF);

		g.drawString(this.nom, 200, 200);

		g.setColor(Color.white);
		// g.setFont(FontManager.menuItemsTTF);

		for (int i = 0; i < nbrOption; i++) {
			g.drawString(this.items[i], 300, 280 + 50 * i);
		}

		g.drawString(">>", 230, 280 + 50 * selection);

	}

	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_DOWN:
			if (selection < nbrOption - 1)
				selection++;
			else
				selection = 0;
			break;
		case Input.KEY_UP:
			if (selection > 0)
				selection--;
			else
				selection = nbrOption - 1;
			break;
		case Input.KEY_ENTER:
			execOption();
			break;

		}
	}

	public void execOption() {

		switch (selection) {
		case 0:
			game.enterState(WorldGenGame.ID);
			break;
		case 1:
			game.enterState(MainMenu.ID);
			break;

		}
	}

	public int getID() {
		return ID;
	}

}
