package fr.tgd.util;

import fr.tgd.world.Circle;
import fr.tgd.world.Rectangle;

public class Collisions {
	public static double distanceCircleRect(Circle circle,double cx,double cy, Rectangle rectangle, double rx, double ry){

		if(cy+circle.getRadius()<ry){
			if(cx+circle.getRadius()<rx){
				return (Math.sqrt(Math.pow((ry-cy),2)+Math.pow((rx-cx),2)));
			}else if(cx>rx+rectangle.getWidth()){
				return (Math.sqrt(Math.pow((ry-cy),2)+Math.pow((rx+rectangle.getWidth()-cx),2)));
			}else{
				return (ry-cy);
			}
		}else if(cy>ry+rectangle.getHight()){
			if(cx+circle.getRadius()<rx){
				return (Math.sqrt(Math.pow((ry+rectangle.getHight()-cy),2)+Math.pow((rx-cx),2)));
			}else if(cx>rx+rectangle.getWidth()){
				return (Math.sqrt(Math.pow((ry+rectangle.getHight()-cy),2)+Math.pow((rx+rectangle.getWidth()-cx),2)));
			}else{
				return (cy-(ry+rectangle.getHight()));
			}
		}else{
			if(cx+circle.getRadius()<rx){
				return rx-cx;
			}else if(cx>rx+rectangle.getWidth()){
				return cx-(rx+rectangle.getWidth());
			}else{
				return 0;
			}
		}

	}

	public static double distanceCircleCircle(Circle circle1,double c1x ,double c1y, Circle circle2,double c2x ,double c2y){

		double dist = Math.sqrt(Math.pow((c1y-c2y),2)+Math.pow((c1x-c2x),2));
		
		if(dist<=circle1.getRadius()+circle2.getRadius()){
			return 0;
		}
		else{
			return dist;
		}

	}
	
	public static boolean collisionCircleRect(Circle circle, double cx, double cy, Rectangle rectangle, double rx, double ry){
		return (distanceCircleRect(circle,cx,cy,rectangle,rx,ry)<=0);
	}
	
	public static boolean collisionCircleCircle(Circle circle1, double c1x, double c1y, Circle circle2, double c2x, double c2y){
		return (distanceCircleCircle(circle1,c1x,c1y,circle2,c2x,c2y)<=0);
	}

}
