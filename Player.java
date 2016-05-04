package APCSProject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;


public class Player extends Thing
{
	private int speed;
	private Image image;

	public Player() {
		this(0, 0, 10, 10, 0);
	}

	public Player(int x, int y) {
		this(x, y, 10, 10, 0);
	}

	public Player(int x, int y, int s) {
		this(x, y, 30, 30, s);
	}

	public Player(int x, int y, int w, int h, int s) {
		super(x, y, w, h);
		speed = s;
		try
		{
			image = ImageIO.read(new File("src/APCSProject/Gommba2.gif"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.print(" ");
		}
	}

	
	public void move(String direction) {
		if (direction.equals("RIGHT") && getX() < (730))
			setX(getX() + getSpeed());
		else if (direction.equals("LEFT") && getX() > (0))
			setX(getX() - getSpeed());
		if (getX() > 720) 
		{
			direction = "LEFT";
			setY(getY() + 5);
		}
		if (getX() < 10) 
		{
			direction = "RIGHT";
			setY(getY() + 5);
		}
	}
	
	/// methods that need to be implemented
	@Override
	public void setSpeed(int s) {
		// TODO Auto-generated method stub
		speed=s;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public void draw(Graphics window) {
		// TODO Auto-generated method stub
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}
	
}
