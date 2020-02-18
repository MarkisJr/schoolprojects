// Importing required components to use Graphics and JFrame
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent // Alternate class derived class
{
	private static final long serialVersionUID = 1L; //Declaring version for compatibility with other classes and/or objects
	
	public void paint(Graphics g) 
	{
		
		// Setting custom colors
		Color green = new Color(20,100,20);
		Color darkgreen = new Color(20,70,20);
		Color red = new Color(200,0,0);
		Color darkred = new Color(100,0,0);
		Color skyblue = new Color(0,255,255);
		Color brown = new Color (110, 33, 33);
		
		// Background
		g.setColor(skyblue);
		g.fillRect(0, 0, 600, 320);
		
		// Foreground using premade colors that come with the Color class
		g.setColor(Color.gray);
		g.fillRect(0, 320, 600, 180); // Concrete foot path
		
		g.setColor(Color.lightGray);
		g.fillRect(0, 380, 600, 20); // Gutter
		
		g.setColor(Color.darkGray);
		g.fillRect(0, 400, 600, 100);
		
		// Front of roof
		int xstri[] = {150, 250, 350}; // X coordinates
		int xytri[] = {150, 80, 150}; // Y coordinates
		Polygon tri = new Polygon(xstri,xytri,3); // New 3 sided polygon class for front of roof
		g.setColor(red);
		g.fillPolygon(tri);
		
		// Side of roof
		int xssidetri[] = {250,350,500,400}; // X coordinates
		int xysidetri[] = {80,150,120,50}; // Y coordinates
		Polygon sidetri = new Polygon(xssidetri, xysidetri, 4); // New 4 sided polygon class for side of roof
		g.setColor(darkred);
		g.fillPolygon(sidetri);
		
		//Making side of building
		int xsside[] = {350,350,500,500}; // X coordinates
		int xyside[] = {150,350,320,120}; // Y coordinates
		Polygon side = new Polygon(xsside,xyside,4); // New 4 sided polygon class for side of building
		g.setColor(darkgreen);
		g.fillPolygon(side);
		
		// Rectangle for front of house
		g.setColor(green);
		g.fillRect(150, 150, 200, 200);
		
		// Window
		g.setColor(Color.white);
		g.fillRect(170, 170, 50, 50); // Panes
		g.setColor(Color.black);
		g.fillRect(190, 170, 10, 50); // Window frame
		g.fillRect(170, 190, 50, 10);
		
		// Door
		g.setColor(brown);
		g.fillRect(250, 260, 50, 90);
		
		// Sun
		g.setColor(Color.yellow);
		g.fillOval(70, 30, 50, 50);
	}
}

public class DrawHouse // Main class (runtime)
{
	public static void main(String[] a) // main method (first called)
	{
		JFrame window = new JFrame(); // Initializing JFrame class
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets X button to close application
		
		window.setBounds(30,30,600,500); // Sets window size
		
		window.getContentPane().add(new MyCanvas()); // Gets content stated in the paint method
		window.setVisible(true); // Makes window visible
	}
}