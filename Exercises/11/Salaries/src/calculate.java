import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//Defining variables
	Double hours = 0d, salary =0d;
	
	public void init()
	{
		//Title
		JLabel title = new JLabel("Please insert the number of hours worked");
		//User input
		JTextField input = new JTextField(10);
		//Buttons
		JButton start = new JButton("Calculate");
		JButton reset = new JButton("Reset");
		//Dialogue
		JLabel result = new JLabel();
		
		//Add elements to frame
		add(title);
		add(input);
		add(start);
		add(reset);
		add(result);
		
		//Calculate wage
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					//Get number
					hours = Double.parseDouble(input.getText());
					
					//Hourly rate if worked less than 35 hours
					if (hours < 35)
					{
						salary = hours*15;
						result.setText("At a rate of $15/h, the worker's salary is $" + salary);
						start.setEnabled(false);
					}
					
					//Hourly rate if worked greater than 35 hours
					if (hours >= 35)
					{
						salary = hours*25;
						result.setText("At a rate of $25/h, the worker's salary is $" + salary);
						start.setEnabled(false);
					}
				}
				//Catching unrelated characters
				catch(NumberFormatException error)
				{
					JOptionPane.showMessageDialog(null, "");
				}
			}		
		});
		
		//Reset button
		reset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Reset values
				hours = 0d;
				//Empty input field, reset button and clear output
				input.setText("");
				start.setEnabled(true);
				result.setText("");
			}
		});
	}
}

public class calculate 
{
	public static void main(String[] args) 
	{
		Window importclass = new Window();
		importclass.init();
		JFrame window = new JFrame();
		
		window.setTitle("Wage Calculator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 300, 130);
		window.setResizable(false);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
