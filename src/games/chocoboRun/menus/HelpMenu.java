package games.chocoboRun.menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HelpMenu extends BasicGameState {

	private int ID;

	private String nom = "Aide";
	private String[] items = {
			"Double Score : 2x plus de points pendant un temps limité !",
			"Ghost : Vous pouvez traverser les murs !",
			"Accélération : Le défilement accélère soudainement !",
			"Inversion : Les contrôles sont maintenant à l'envers !",
			"Retour Menu" };

	public int nbrOption = items.length;

	public String[] getItems() {
		return this.items;
	}

	private GameContainer container;
	private StateBasedGame game;
	int selection = nbrOption - 1;

	public HelpMenu(int ID) {
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

		for (int i = 0; i < nbrOption; i++) {
			g.drawString(this.items[i], 150, 280 + 50 * i);
		}
		g.drawString(">>", 80, 280 + 50 * selection);


		g.setColor(Color.red);
		g.fillOval(120, 285, 10, 10);
		g.setColor(Color.green);
		g.fillOval(120, 335, 10, 10);
		g.setColor(Color. magenta);
		g.fillOval(120, 385, 10, 10);
		g.setColor(Color.cyan);
		g.fillOval(120, 435, 10, 10);


	}

	@Override
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_ENTER:
			game.enterState(2 /* MainMenu */);
			break;
		}
	}

	public void execOption() {
		switch (selection) {
		case 0:
			game.enterState(0 /* World */);
			break;
		case 1:
			container.exit();
			break;
		case 2:
			game.enterState(3 /* GOMenu */);
			break;

		}
	}

}
