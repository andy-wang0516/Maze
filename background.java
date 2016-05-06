package maze;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static java.lang.Character.*;

import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class background extends Canvas implements KeyListener, Runnable
{	private int[][] walls = new int[800][600];
	private Person ship;
	private theMazeItself m;
	private Alien alienOne, alienTwo,alien3,alien4,alien5,alien6;
	private boolean alive1, alive2, alive3,alive4,alive5,alive6;
	private boolean leftT, rightT, leftD, rightD;
	private boolean fired = false;
	private int lr = 0;

	/* uncomment once you are ready for this part
	 *
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	*/

	private boolean[] keys;
	private BufferedImage back;

	public background()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		m = new theMazeItself(0,0);
		ship = new Person(20,50,5);
		alienOne = new Alien(100,100,1);
		alienTwo = new Alien(100,20,1);
		alien3 = new Alien(200,100,1);
		alien4 = new Alien(200,20,1);
		alien5 = new Alien(300,100,1);
		alien6 = new Alien(300,20,1);
		//a = new Ammo(ship.getX()+20,ship.getY(),1);
	
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		Graphics2D twoDGraph = (Graphics2D)window;
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		Graphics graphToBack = back.createGraphics();
		//m.draw(graphToBack);
	//	graphToBack.setColor(Color.WHITE);
		//graphToBack.fillRect(0,0,800,600);
		
m.draw(graphToBack);
//Test method
try {
	System.out.println(m.GetPixelColor(20, 50));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//Test method
try {
	leftT = m.GetPixelColor(ship.getX(), ship.getY());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	rightT = m.GetPixelColor(ship.getX()+30, ship.getY());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	rightD = m.GetPixelColor(ship.getX()+30, ship.getY()-30);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	leftD = m.GetPixelColor(ship.getX(), ship.getY()-30);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
	if (ship.getX() > -5 && leftT == false && leftD == false)
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
	if (ship.getX() < 736 && rightT == false && rightD == false)
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
	if (ship.getY() > -15 && leftT == false && rightT == false)
		if(keys[2] == true)
		{
			ship.move("UP");
		}
	if (ship.getY() < 490 && rightD == false && leftD == false)
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}

		//add in collision detection
		


		
		alienTwo.draw(graphToBack);
		alienOne.draw(graphToBack);
		alien3.draw(graphToBack);
		alien4.draw(graphToBack);
		alien5.draw(graphToBack);
		alien6.draw(graphToBack);
		
		ship.draw(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

