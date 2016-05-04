package APCSProject;

import java.awt.Graphics;

public abstract class Thing implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	
	public Thing()
	{
		this(5,5,5,5);
	}
	
	public Thing(int x, int y)
	{
		xPos=x;
		yPos=y;
		width=5;
		height=5;
	}
	
	public Thing(int x,int y, int w, int h)
	{
		xPos=x;
		yPos=y;
		width=w;
		height=h;
	}
	
	@Override
	public void setPos(int x, int y) {
		// TODO Auto-generated method stub
		xPos=x;
		yPos=y;
		
	}
	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		xPos=x;
	}
	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		yPos=y;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xPos;
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}
	
	public void setWidth(int w) {
		width = w;
	}

	public void setHeight(int h) {
		height = h;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public abstract void setSpeed( int s );
	public abstract int getSpeed();
	public abstract void draw(Graphics window);
	
	
	
	

}
