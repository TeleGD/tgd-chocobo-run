package fr.tgd.menus;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import fr.tgd.util.FontManager;

public class MainMenu implements Scene {

	private String nom = "Menu Principal";
	private String[] items = { "Jouer", "Quitter", "Scores" };

	public MainMenu() {

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.red);
		g.setFont(FontManager.menuTitreTTF);

		int x = 200;
		int y = 200;

		g.drawString(this.nom, x, y);

		x += 20;
		y += 60;
	
		g.setColor(Color.white);
		g.setFont(FontManager.menuItemsTTF);

		for (String i : this.items) {

			g.drawString(i, x, y);
			y += 30;

		}
	}

}
