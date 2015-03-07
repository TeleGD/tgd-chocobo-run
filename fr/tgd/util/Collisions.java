package fr.tgd.util;

import fr.tgd.world.Circle;
import fr.tgd.world.Rectangle;
import fr.tgd.world.World;

public class Collisions {
	public static double distanceCircleRect(Circle circle, Rectangle rectangle){

		//DESSUS
		if(circle.getY()<rectangle.getY()){
			//GAUCHE
			if(circle.getX()<rectangle.getX()){
				return distancePointPoint(circle.getX(),circle.getY(),rectangle.getX(),rectangle.getY());
			//DROITE
			}else if(circle.getX()>rectangle.getX()+rectangle.getWidth()){
				return distancePointPoint(circle.getX(),circle.getY(),rectangle.getX()+rectangle.getWidth(),rectangle.getY());
			//MILIEU
			}else{
				return (rectangle.getY()-circle.getY());
			}
		//DESSOUS
		}else if(circle.getY()>rectangle.getY()+rectangle.getHight()){
			//GAUCHE
			if(circle.getX()<rectangle.getX()){
				return distancePointPoint(circle.getX(),circle.getY(),rectangle.getX(),rectangle.getY()+rectangle.getHight());
			//DROITE
			}else if(circle.getX()>rectangle.getX()+rectangle.getWidth()){
				return distancePointPoint(circle.getX(),circle.getY(),rectangle.getX()+rectangle.getWidth(),rectangle.getY()+rectangle.getHight());
			//MILIEU
			}else{
				return (circle.getY()-(rectangle.getY()+rectangle.getHight()));
			}
		//MILIEU
		}else{
			//GAUCHE
			if(circle.getX()<rectangle.getX()){
				return rectangle.getX()-circle.getX();
			//DROITE
			}else if(circle.getX()>rectangle.getX()+rectangle.getWidth()){
				return circle.getX()-(rectangle.getX()+rectangle.getWidth());
			//MILIEU
			}else{
				return 0;
			}
		}

	}
	
	public static double distancePointPoint(double x1, double y1, double x2, double y2){
		return (Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)));
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
		return (distanceCircleRect(circle,rectangle)<=circle.getRadius());
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
	
	public static boolean collisionCircleAnyCircle(Circle circle){
		for(int i=0;i<World.getBonuses().size();i++){
			if(collisionCircleCircle(circle,World.getBonuses().get(i))){
				return true;
			}
		}
		return false;
	}

}
