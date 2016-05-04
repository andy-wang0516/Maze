package Maze;
import javax.swing.JFrame;
import java.awt.Component;

public class Maze extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Maze()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		Background theGame = new Background();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		Maze run = new Maze();
	}
}
