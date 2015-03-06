import java.util.Random;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame{	//Classe principale WindowGame
	
    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new Game(), largeurW, hauteurW, false).start(); 
    }
	
	GameContainer container;
	
	//======================================================================================
	//DECLARATION DES CONSTANTES
	//======================================================================================
	
	static public int hauteurW=600,largeurW=800; 

	//======================================================================================
	//DECLARATION DES VARIABLES
	//======================================================================================
	
	//======================================================================================
	//CREATEUR
	//======================================================================================
	
    public Game() {
        super("Nuit Coding");
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

    }

    //======================================================================================
    //FONCTION UPDATE
    //======================================================================================

    public void update(GameContainer container, int delta) throws SlickException {
    	
    	
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
