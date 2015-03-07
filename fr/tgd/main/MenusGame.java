package fr.tgd.main;

import java.awt.Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import fr.tgd.menus.*;
import fr.tgd.menus.Scene;
import fr.tgd.util.FontManager;

public class MenusGame extends BasicGame{	//Classe principale WindowGame

    private static MenusGame instance = new MenusGame();
    
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
	
    public MenusGame() {
        super("Nuit Coding");
        currentScene = new GOMenu();
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
        
    	Font menuTitre1Font = new Font("Goudy Stout", Font.BOLD, 40);
    	FontManager.menuTitre1TTF = new TrueTypeFont(menuTitre1Font, false);
    	Font menuItemsFont = new Font("Arial", Font.BOLD, 30);
    	FontManager.menuItemsTTF = new TrueTypeFont(menuItemsFont, false);
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
		case Input.KEY_ESCAPE:container.exit();break;
		default:
			currentScene.keyPressed(key);
			break;
	//	case Input.KEY_ENTER:execOption();
	//		break;
		}
	}
    
}
