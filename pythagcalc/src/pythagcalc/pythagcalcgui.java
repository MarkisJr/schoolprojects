package pythagcalc;

//importing libraries
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

class Window extends JPanel implements ActionListener
{
	//program version
	private static final long serialVersionUID = 1L;
	
	//declaring graphical elements of gui
	Label title, subtitle, rule;
	TextField valuea, valueb, valuec;
	Button calculate, reset;
	JLabel triangle;
	
	//declaring variables
	DecimalFormat df = new DecimalFormat("#.##");
	double a, b, c, result;
	boolean hypot;
	
	//initialize
	public void init()
	{
		//setting text of labels
		title = new Label("Please enter two seperate lengths of the right angle triangle");
		subtitle = new Label("The unknown side will be calculated using:");
		rule = new Label("The calculator will only function with integer and real numbers");
		
		//setting images to appropriate file
		triangle.setIcon(new ImageIcon("triangle.png"));
		
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
		add(valuea);
		add(valueb);
		add(valuec);
		add(triangle);
		add(calculate);
		add(reset);
		add(rule);
		
		//adding event for when the button is pressed
		calculate.addActionListener(this);
		reset.addActionListener(this);
	}
	
	//When either button is clicked
	public void actionPerformed(ActionEvent e) 
	{
		//determine which button has been pressed
		String type = e.getActionCommand();
		
		try 
		{
		
			//calculating the answer
			if (type == "Calculate")
			{
				//handling null
				if (valuea.getText().equals(""))
				{
					valuea.setText("0");
				}
				if (valueb.getText().equals(""))
				{
					valueb.setText("0");
				}
				if (valuec.getText().equals(""))
				{
					valuec.setText("0");
				}
				
				//converting string to double
				a = Double.parseDouble(valuea.getText());
				b = Double.parseDouble(valueb.getText());
				c = Double.parseDouble(valuec.getText());
			
				//check for negative numbers
				if (a < 0 || b < 0 || c < 0)
				{
					JOptionPane.showMessageDialog(null, "A triangle cannot have negative lengths");
					return;
				}
			
				//what equation to be used
				if (a != 0 && b != 0 && c == 0)
				{
					hypot=true;
				}
				else if (a != 0 && c != 0 && b == 0)
				{
					hypot=false;
				}
				else if (b != 0 && c != 0 && a == 0)
				{
					hypot=false;
				}
				
				//checks if there have been three inputs
				else
				{
					JOptionPane.showMessageDialog(null, "An invalied amount of values have been entered into the text fields");
					return;
				}
				
				//solving for the hypotenuse
				if (hypot == true)
				{
					result = Math.hypot(a, b);
					result = Double.valueOf(df.format(result));
					
					//printing to c
					valuec.setText(String.valueOf(result));
				}
				
				//solving for a or b
				else if (hypot == false)
				{
					result = Math.sqrt(Math.pow(c, 2)-Math.pow(a, 2)+Math.pow(b, 2));

					result = Double.valueOf(df.format(result));
					
					//printing to a
					if (a == 0)
					{
						valuea.setText(String.valueOf(result));
					}
					
					//printing to b
					else if (b == 0)
					{
						valueb.setText(String.valueOf(result));
					}
				}	
			}
			
			//resets the gui
			if (type == "Reset")
			{
				
			}
		}
		
		//handles the error if a non number character is input into the fields
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "The varriables can only contain integers and real numbers. Output: " + error.toString());
		}
		
		//handles all errors that have no catch handling them and prints out the error for debug purposes
		catch (Exception error)
		{
			JOptionPane.showMessageDialog(null, "An error occured. Output: " + error.toString());
		}
	} 
}

public class pythagcalcgui
{
	
	
	
	
	//create panel for gui
	public static void main(String[] args) 
	{
		Window importclass = new Window();
		
		importclass.setLayout(new BoxLayout(importclass, BoxLayout.PAGE_AXIS));
		
		importclass.init();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setBounds(30,30,600,300);
		
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
