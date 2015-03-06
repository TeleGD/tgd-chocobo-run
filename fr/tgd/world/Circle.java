package fr.tgd.world;

public class Circle extends Entity{
	
	int radius;
	
	public Circle(double x,double y,int radius){
		super(x,y);
		this.radius=radius;
	}

	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
	

}
