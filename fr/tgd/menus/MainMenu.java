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


import fr.tgd.main.WorldGenGame;
import fr.tgd.world.Character;
import fr.tgd.world.World;

public class MainMenu extends BasicGameState{
	
	public static int ID = 2;

	private String nom = "Menu Principal";
	private String[] items = { "Jouer", "Scores", "Help", "Quitter" };

	public int nbrOption = items.length;

	public String[] getItems() {
		return this.items;
	}

	static GameContainer container;
	static StateBasedGame game;
	int selection = 0;

	 public void init(GameContainer container, StateBasedGame game) throws SlickException {
	        this.container = container;
	        container.setShowFPS(false);
	        this.game=game;
	 }

	 public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	    	
	 }

	 public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
			
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
			game.enterState(WorldGenGame.ID);
			break;
		case 1:
			game.enterState(ScoreMenu.ID);
			break;
		case 2:
			game.enterState(HelpMenu.ID);
			break;
		case 3:
			container.exit();
			break;
		}
	}
	
	public int getID(){
		return ID;
	}

}
