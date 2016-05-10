package APCSProject;
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
{	
	private boolean[][] walls = new boolean[800][600];
	private Person ship;
	private theMazeItself m;
	private Mushroom m1, m2,m3,m4,m5,m6;
	private boolean alive1, alive2, alive3,alive4,alive5,alive6;
	private boolean leftT, rightT, leftD, rightD;
	private boolean fired = false;
	private int lr = 0;

	/* uncomment once you are ready for this part
	 *
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	*/
	private ArrayList<Mushroom> group;
	private boolean[] keys;
	private BufferedImage back;

	public background()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		m = new theMazeItself(0,0);
		ship = new Person(20,50,4);
		m1 = new Mushroom(100,400,1);
		m2 = new Mushroom(50,20,1);
		m3 = new Mushroom(600,100,1);
		m4 = new Mushroom(3,300,1);
		m5 = new Mushroom(300,100,1);
		m6 = new Mushroom(400,220,1);
		/*group.add(m1);
		group.add(m2);
		group.add(m3);
		group.add(m4);
		group.add(m5);
		group.add(m6);*/
		
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

try {
	System.out.println(m.GetPixelColor(0, 0));
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//m.createMazwall();
//System.out.println(m.getMW(0, 0));



	
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
	
		//array of mushrooms
	
		/*group.draw(graphToBack);
	

	
		// collision detection
		group.removeDeadOnes(ship);
	
		twoDGraph.drawImage(back, null, 0, 0);
		back = null;*/
//for(Mushroom m: group)
//{
	/*if(ship.getX() == m1.getX() && ship.getY() == m1.getY() )
	{
		System.exit(1);
		
		}
//}
	if(ship.getX() == m2.getX() && ship.getY() == m2.getY() )
	{
		System.exit(1);
	}
	if(ship.getX() == m3.getX() && ship.getY() == m3.getY() )
	{
		System.exit(1);
	}
	if(ship.getX() == m4.getX() && ship.getY() == m4.getY() )
	{
		System.exit(1);
	}
		
	if(ship.getX() == m5.getX() && ship.getY() == m5.getY() )
	{
		System.exit(1);
	}
	if(ship.getX() == m6.getX() && ship.getY() == m6.getY() )
	{
		System.exit(1);
	}
		*/
	
	
		m1.draw(graphToBack);
		m2.draw(graphToBack);
		m3.draw(graphToBack);
		m4.draw(graphToBack);
		m5.draw(graphToBack);
		m6.draw(graphToBack);
		
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

