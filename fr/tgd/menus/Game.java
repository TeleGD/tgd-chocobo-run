package fr.tgd.menus;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.tgd.main.WorldGenGame;

public class Game extends StateBasedGame {

  public static void main(String[] args) throws SlickException {
    new AppGameContainer(new Game(), 800, 600, false).start();
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


  }
}