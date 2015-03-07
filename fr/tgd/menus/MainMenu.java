package fr.tgd.menus;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.tgd.util.FontManager;
import fr.tgd.world.Character;
import fr.tgd.world.World;

public class MainMenu extends BasicGameState{
	
	int ID = 2;

	private String nom = "Menu Principal";
	private String[] items = { "Jouer", "Quitter", "Scores" };

	public int nbrOption = items.length;

	public String[] getItems() {
		return this.items;
	}

	static GameContainer container;
	int selection = 0;

	 public void init(GameContainer container, StateBasedGame game) throws SlickException {
	        this.container = container;
	        container.setShowFPS(false);
	 }

	 public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	    	
	 }

	 public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
			
		 	g.setColor(Color.red);
			g.setFont(FontManager.menuTitre2TTF);

			g.drawString("132", 0, 0);
			g.drawString("test",200f, 200f);

			g.setColor(Color.white);
			g.setFont(FontManager.menuItemsTTF);

			for (int i = 0; i < nbrOption; i++) {
				g.drawString(this.items[i], 300, 280 + 50 * i);
			}

			g.drawString(">>", 230, 280 + 50 * selection);
	 }

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
		case Input.KEY_ENTER:
			execOption();
			break;
		
		}
	}
	
	public void execOption() {
		switch (selection) {
		case 0:break;
			
		case 1:
			container.exit();break;
		case 2:break;
			
		}
	}
	
	public int getID(){
		return ID;
	}

}
