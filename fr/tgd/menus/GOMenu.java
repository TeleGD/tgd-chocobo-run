package fr.tgd.menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import fr.tgd.util.FontManager;

public class GOMenu implements Scene {
	
	private String nom = "GAME OVER";
	private String[] items = { "Re-jouer", "Quitter" };

	public int nbrOption = items.length;

	public String[] getItems() {
		return this.items;
	}

	static GameContainer container;
	int selection = 0;

	public GOMenu() {

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.red);
		g.setFont(FontManager.menuTitre1TTF);

		g.drawString(this.nom, 200, 200);

		g.setColor(Color.white);
		g.setFont(FontManager.menuItemsTTF);

		for (int i = 0; i < nbrOption; i++) {
			g.drawString(this.items[i], 300, 280 + 50 * i);
		}

		g.drawString(">>", 230, 280 + 50 * selection);

	}

	@Override
	public void keyPressed(int key) {
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
	/*  case Input.KEY_ENTER:
			execOption();
			break;
		*/
		}
	}
	
}
