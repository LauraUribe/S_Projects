import java.awt.Color;
import java.awt.Graphics;
import java.math.*;

public abstract class Vehicle implements Runnable  // abstract - blueprint vehicle subclasses
{
	int xposition, yposition, velocity, tempvelocity;
	boolean carmove;
	Color color;
	
	RacecarWindow racecarwindow;
	// constructor for car....these values are passed here and then they will be drawn 
	public Vehicle(int xposition, int yposition, int velocity, Color color, RacecarWindow racecarwindow)
	// all of this will be called in draw() method
	{
		// System.out.println("Got to public vehicle!");
		this.xposition = xposition;
		this.yposition = yposition;
		this.velocity = velocity;
		this.color = color;
		tempvelocity = velocity;
		this.racecarwindow = racecarwindow;  // passes 'RacecarWindow', aka 'racecarwindow' to this class, in this case 'Vehicle'
		carmove=false;
	}
	
	/* public void draw(Graphics g)  -- truck vs car diff drawings, so not here
	// x, y, length, height
	{
		g.setColor(color);  // sets the color for these to be drawn on the body; passes 'color'
		g.fillRect(xposition, yposition, 50, 20);  // car body
		// g.fillRect(xposition + 5, yposition - 8, 10, 20);  // roof of truck  // (0,0) is top left corner, must subtract to
		// get the roof to be on the top part;
		g.drawOval(xposition, yposition + 15, 10, 10);  // wheel1
		g.drawOval(xposition + 40, yposition + 15, 10, 10);  // wheel2
		
	}
		*/

	public boolean clicked(int xclick, int yclick)
	// s = (int) (Math.random()*20);  // starrynight help
	// global variable 
	
	{
		// System.out.println("Got to clicked!");
		if ((Math.abs((xclick - xposition)) < (xposition/2) && ((Math.abs(yclick - yposition)) < (xposition/2))))  // formula for car click
			return true;  // says it registered it has been clicked, according to the 'if statement'
		return false;  // otherwise, false click
			
	}

	public void velocity()
	{
		// int tempvelocity = 0;
		System.out.println("Velocity for this car is: " + tempvelocity);
		
		tempvelocity =+ velocity;
		carmove = true;
	}
	
	public void run()
	{
		while(true)
		{
			if(carmove)
			{
				xposition = xposition + tempvelocity;
				racecarwindow.carcomponent.repaint();  // repaints the window with the updated movements
			}
			try  // generated by compiler
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)  // generated by compiler
			{ 
				e.printStackTrace();
			}
		}
	}
}

	

