package fr.tgd.menus;

import org.newdawn.slick.Graphics;

public class MainMenu implements Scene {

	private String[] items = { "Jouer", "Quitter", "Scores" };

	public MainMenu() {

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {
		int x = 10;
		int y = 30;
		for (String i : this.items) {
			g.drawString(i, x, y);
			y += 20;
		}
	}

}
