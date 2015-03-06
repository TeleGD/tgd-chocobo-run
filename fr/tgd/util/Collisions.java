package fr.tgd.util;

import fr.tgd.world.Circle;
import fr.tgd.world.Rectangle;
import fr.tgd.world.World;

public class Collisions {
	public static double distanceCircleRect(Circle circle, Rectangle rectangle){

		if(circle.getY()+circle.getRadius()<rectangle.getY()){
			if(circle.getX()+circle.getRadius()<rectangle.getX()){
				return (Math.sqrt(Math.pow((rectangle.getY()-circle.getY()),2)+Math.pow((rectangle.getX()-circle.getX()),2)));
			}else if(circle.getX()>rectangle.getX()+rectangle.getWidth()){
				return (Math.sqrt(Math.pow((rectangle.getY()-circle.getY()),2)+Math.pow((rectangle.getX()+rectangle.getWidth()-circle.getX()),2)));
			}else{
				return (rectangle.getY()-circle.getY());
			}
		}else if(circle.getY()>rectangle.getY()+rectangle.getHight()){
			if(circle.getX()+circle.getRadius()<rectangle.getX()){
				return (Math.sqrt(Math.pow((rectangle.getY()+rectangle.getHight()-circle.getY()),2)+Math.pow((rectangle.getX()-circle.getX()),2)));
			}else if(circle.getX()>rectangle.getX()+rectangle.getWidth()){
				return (Math.sqrt(Math.pow((rectangle.getY()+rectangle.getHight()-circle.getY()),2)+Math.pow((rectangle.getX()+rectangle.getWidth()-circle.getX()),2)));
			}else{
				return (circle.getY()-(rectangle.getY()+rectangle.getHight()));
			}
		}else{
			if(circle.getX()+circle.getRadius()<rectangle.getX()){
				return rectangle.getX()-circle.getX();
			}else if(circle.getX()>rectangle.getX()+rectangle.getWidth()){
				return circle.getX()-(rectangle.getX()+rectangle.getWidth());
			}else{
				return 0;
			}
		}

	}

	public static double distanceCircleCircle(Circle circle1, Circle circle2){

		double dist = Math.sqrt(Math.pow((circle1.getY()-circle2.getY()),2)+Math.pow((circle1.getX()-circle2.getX()),2));
		
		if(dist<=circle1.getRadius()+circle2.getRadius()){
			return 0;
		}
		else{
			return dist;
		}

	}
	
	public static boolean collisionCircleRect(Circle circle, Rectangle rectangle){
		return (distanceCircleRect(circle,rectangle)<=0);
	}
	
	public static boolean collisionCircleAnyRect(Circle circle){
		for(int i=0;i<World.getWalls().size();i++){
			if(collisionCircleRect(circle,World.getWalls().get(i))){
				return true;
			}
		}
		return false;
	}
	
	public static boolean collisionCircleCircle(Circle circle1, Circle circle2){
		return (distanceCircleCircle(circle1,circle2)<=0);
	}

}
