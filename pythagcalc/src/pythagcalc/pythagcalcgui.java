package pythagcalc;

//importing libraries
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.lang.Math;

class Window extends JPanel implements ActionListener
{
	//program version
	private static final long serialVersionUID = 1L;
	
	//declaring graphical elements of gui
	Label title, subtitle, rule;
	TextField valuea, valueb, valuec;
	Button calculate, reset;
	
	//declaring variables
	public double a, b, c, result;
	public boolean hypot;
	
	//initialize
	public void init()
	{
		//setting text of labels
		title = new Label("Please enter two seperate lengths of the right angle triangle");
		subtitle = new Label("The unknown side will be calculated using:");
		rule = new Label("The calculator will only function with integer and real numbers");
		
		//setting size and text of textfields
		valuea = new TextField(10);
		valueb = new TextField(10);
		valuec = new TextField(10);
		
		//setting text of buttons
		calculate = new Button("Calculate");
		reset = new Button("Reset");
		
		//adding components into the frame
		add(title);
		add(subtitle);
		add(rule);
		add(valuea);
		add(valueb);
		add(valuec);
		add(calculate);
		add(reset);
		
		//adding event for when the button is pressed
		calculate.addActionListener(this);
		reset.addActionListener(this);
	}
	
	//When either button is clicked
	public void actionPerformed(ActionEvent e) 
	{
		//determine which button has been pressed
		String type = e.getActionCommand();
		
		//calculating the answer
		if (type == "Calculate")
		{
			//setting variables with data
			if ( )
		}
		
		//resetting the gui
		if (type == "Reset")
		{
			
		}
		
	} 
}

public class pythagcalcgui 
{
	//create gui
	public static void main(String[] args) 
	{
		Window importclass = new Window();
		importclass.init();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setBounds(30,30,300,300);
		
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
