package fr.tgd.menus;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tgd.main.WorldGenGame;
import fr.tgd.world.Character;
import fr.tgd.world.World;

public class HelpMenu extends BasicGameState {

	public static int ID = 6;

	private String nom = "Aide";
	private String[] items = {
			"Double Score : 2x plus de points pendant un temps limit� !",
			"Ghost : Vous pouvez traverser les murs !",
			"Acc�l�ration : Le d�filement acc�l�re soudainement !",
			"Inversion : Les contr�les sont maintenant � l'envers !",
			"Retour Menu" };

	public int nbrOption = items.length;

	public String[] getItems() {
		return this.items;
	}

	static GameContainer container;
	static StateBasedGame game;
	int selection = nbrOption - 1;

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
			game.enterState(MainMenu.ID);
			break;
		}
	}

	public void execOption() {
		switch (selection) {
		case 0:
			game.enterState(WorldGenGame.ID);
			break;
		case 1:
			container.exit();
			break;
		case 2:
			game.enterState(GOMenu.ID);
			break;

		}
	}

	public int getID() {
		return ID;
	}

}
