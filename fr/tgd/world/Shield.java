package fr.tgd.world;

import fr.tgd.main.WorldGenGame;

public class Shield extends Bonus{
	
	public Shield(double x,double y, int radius){
		super(x,y,radius);
	}

	public void used(){
		WorldGenGame.character.setInvicible(true);
	}
	
}
