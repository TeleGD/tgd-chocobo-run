package fr.tgd.menus;

import java.awt.Font;
import java.io.File;
import java.io.FileWriter;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;





import fr.tgd.main.WorldGenGame;

public class Game extends StateBasedGame {


	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game(), 800, 600, false);
		app.setTargetFrameRate(60);
		app.setVSync(true);
		app.setShowFPS(true);
		app.start();
	}

	public Game() {
		super("CodingNight");
	}


	@Override
	public void initStatesList(GameContainer container) throws SlickException {

		addState(new MainMenu());
		addState(new GOMenu());
		addState(new PauseMenu());
		addState(new WorldGenGame());
		addState(new HelpMenu());
		addState(new ScoreMenu());

	}





}
