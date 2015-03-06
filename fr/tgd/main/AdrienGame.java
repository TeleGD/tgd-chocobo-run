package fr.tgd.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import fr.tgd.menus.MainMenu;
import fr.tgd.menus.Scene;

public class AdrienGame extends BasicGame{	//Classe principale WindowGame

    private static AdrienGame instance = new AdrienGame();
    
    public static void main(String[] args) throws SlickException {
        new AppGameContainer(instance, largeurW, hauteurW, false).start(); 
        
    }
	
	GameContainer container;
	
	//======================================================================================
	//DECLARATION DES CONSTANTES
	//======================================================================================
	
	static public int hauteurW=600,largeurW=800; 
	private Scene currentScene;

	//======================================================================================
	//DECLARATION DES VARIABLES
	//======================================================================================
	
	//======================================================================================
	//CREATEUR
	//======================================================================================
	
    public AdrienGame() {
        super("Nuit Coding");
        currentScene = new MainMenu();
    }
    
    public static void setScene(Scene scene)
    {
    	instance.currentScene = scene;
    }
    
    public static Scene getScene()
    {
    	return instance.currentScene;
    }
    
    //======================================================================================
    //FONCTION INIT
    //======================================================================================

    public void init(GameContainer container) throws SlickException {
        this.container = container;
        container.setShowFPS(false);
    }
    
    //======================================================================================
    //FONCTION RENDER
    //======================================================================================

    public void render(GameContainer container, Graphics g) throws SlickException {
    	currentScene.draw(g);
    }

    //======================================================================================
    //FONCTION UPDATE
    //======================================================================================

    public void update(GameContainer container, int delta) throws SlickException {
    	currentScene.update();
    }
    //======================================================================================
    //ENTREES CLAVIER
    //======================================================================================

    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
        if (Input.KEY_UP == key || Input.KEY_DOWN == key) {

        }
        if (Input.KEY_Z == key || Input.KEY_S == key) {

        }
    }
    

    public void keyPressed(int key, char c) {
        switch (key) {
            case Input.KEY_UP:;break;
            case Input.KEY_DOWN:break;
            case Input.KEY_Z:break;
            case Input.KEY_S:break;
        }
    }
    
}
