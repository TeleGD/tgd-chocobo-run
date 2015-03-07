package fr.tgd.main;
import java.util.Random;

import fr.tgd.world.Character;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class CharacterGame extends BasicGame{	//Classe principale WindowGame

	
    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new CharacterGame(), largeurW, hauteurW, false).start(); 
    }
	
	GameContainer container;
	
	//======================================================================================
	//DECLARATION DES CONSTANTES
	//======================================================================================
	
	static public int hauteurW=600,largeurW=800; 
	static public Character character;
	//======================================================================================
	//DECLARATION DES VARIABLES
	//======================================================================================
	
	//======================================================================================
	//CREATEUR
	//======================================================================================
	
    public CharacterGame() {
        super("Nuit Coding");
    }
    
    //======================================================================================
    //FONCTION INIT
    //======================================================================================

    public void init(GameContainer container) throws SlickException {
        this.container = container;
        container.setShowFPS(false);
        character = new Character(400d,500d,100,0.3f,20);
    }
    
    //======================================================================================
    //FONCTION RENDER
    //======================================================================================

    public void render(GameContainer container, Graphics g) throws SlickException {
    	character.render(g);
    }

    //======================================================================================
    //FONCTION UPDATE
    //======================================================================================

    public void update(GameContainer container, int delta) throws SlickException {
    	character.update(delta);
    	
    }
    //======================================================================================
    //ENTREES CLAVIER
    //======================================================================================

    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
        switch (key) {
        case Input.KEY_LEFT: character.setMoving(false);
        					 break;
        case Input.KEY_RIGHT: character.setMoving(false);
        					  break;
        case Input.KEY_LSHIFT: character.setSpeedX(0.3f);
        	break;
       
        case Input.KEY_S:break;
    }
    }
    
    

    public void keyPressed(int key, char c) {
        switch (key) {
            case Input.KEY_LEFT: character.setMoving(true);
            					 character.setMovement(0);
            					 break;
            case Input.KEY_RIGHT: character.setMoving(true);
			 					  character.setMovement(1);
            					  break;
            case Input.KEY_LSHIFT: 
            	if (character.getStamina()>=2500) {
            		character.setStamina(character.getStamina()-2500);
            		character.setSpeedX(0.9f);
            	}
            					 
            case Input.KEY_S:break;
        }
    }
    
}
