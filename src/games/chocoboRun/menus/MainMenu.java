package games.chocoboRun.menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState{

	private int ID;

	private String nom = "Menu Principal";
	private String[] items = { "Jouer", "Scores", "Help", "Quitter" };

	public int nbrOption = items.length;

	public String[] getItems() {
		return this.items;
	}

	private GameContainer container;
	private StateBasedGame game;
	int selection = 0;

	public MainMenu(int ID) {
		this.ID = ID;
	}

	@Override
	public int getID() {
		return this.ID;
	}

	 public void init(GameContainer container, StateBasedGame game) {
	        this.container = container;
	        this.game=game;
	 }

	 public void update(GameContainer container, StateBasedGame game, int delta) {

	 }

	 public void render(GameContainer container, StateBasedGame game, Graphics g) {

		 	g.setColor(Color.red);

			g.drawString(this.nom,200, 200);

			g.setColor(Color.white);

			for (int i = 0; i < nbrOption; i++) {
				g.drawString(this.items[i], 300, 280 + 50 * i);
			}
			g.drawString(">>", 230, 280 + 50 * selection);
	 }

	 @Override
	public void keyPressed(int key,char c) {
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
			game.enterState(0 /* World */);
			break;
		case 1:
			game.enterState(1 /* ScoreMenu */);
			break;
		case 2:
			game.enterState(6 /* HelpMenu */);
			break;
		case 3:
			container.exit();
			break;
		}
	}

}
