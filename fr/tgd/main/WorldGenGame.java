package fr.tgd.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import fr.tgd.world.WallGenerator;
import fr.tgd.world.World;

public class WorldGenGame extends BasicGame{
	public static void main(String[] args) throws SlickException {
			new AppGameContainer(new WorldGenGame(), largeurW, hauteurW, false).start(); 
    }
	
	World world = new World();
	WallGenerator gen = new WallGenerator(world) ;
	
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
	
    public WorldGenGame() {
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
    	g.setColor(Color.white);
    	g.fillRect(0, 0, container.getWidth(), container.getHeight());
    	g.translate((int)((container.getWidth()-world.getW())/2), 0);
    	world.render(g);
    	g.translate(-(int)((container.getWidth()-world.getW())/2), 0);
    }

    //======================================================================================
    //FONCTION UPDATE
    //======================================================================================

    int time = 0;
    public void update(GameContainer container, int delta) throws SlickException {
    	world.update(delta);
    	gen.update();
    	
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
