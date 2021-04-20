package games.chocoboRun.menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import games.chocoboRun.World;

public class ScoreMenu extends BasicGameState {

	private int ID;

	private String nom = "Meilleurs Scores";

	private String[] items = new String[6];

	public int nbrOption = items.length;

	public String[] getItems() {
		return this.items;
	}

	private StateBasedGame game;
	int selection = 0;

	public ScoreMenu(int ID) {
		this.ID = ID;
	}

	@Override
	public int getID() {
		return this.ID;
	}

	public void init(GameContainer container, StateBasedGame game) {
		this.game = game;
	}

	public void update(GameContainer container, StateBasedGame game, int delta) {

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) {

		g.setColor(Color.red);

		g.drawString(this.nom, 200, 200);

		g.setColor(Color.white);

		items[0] = "Retour Menu";

		for (int k = 1; k< nbrOption; k++) {
			items[k] = Integer.toString(World.scoreList[k-1]);
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
			game.enterState(2 /* MainMenu */);
			break;
		}
	}

}
