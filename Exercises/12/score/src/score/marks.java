package score;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//Defining variables
	int temp=0, a=0, b=0, c=0, d=0;
	
	public void init()
	{
		//Title
		JLabel title = new JLabel("Please enter the achieved score");
		//User input
		JTextField input = new JTextField(10);
		//Buttons
		JButton next = new JButton("Add Score");
		JButton results = new JButton("Results");
		JButton reset = new JButton("Reset");
		//Dialogue
		JLabel scores = new JLabel();
		
		//Add elements to frame
		add(title);
		add(input);
		add(next);
		add(results);
		add(reset);
		add(scores);
		
		//Calculate wage
		next.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					//Get number
					temp = Integer.parseInt(input.getText());
					
					if (temp > 100)
					{
						JOptionPane.showMessageDialog(null, "Cannot achieve a score higher than 100");
						return;
					}
					
					else if (temp > 85)
					{
						a++;
						input.setText("");
						return;
					}
					else if (temp > 70)
					{
						b++;
						input.setText("");
						return;
					}
					else if (temp > 45)
					{
						c++;
						input.setText("");
						return;
					}
					else if (temp <= 45)
					{
						d++;
						input.setText("");
						return;
					}
				}
				//Catching unrelated characters
				catch(NumberFormatException error)
				{
					JOptionPane.showMessageDialog(null, "\"" + input.getText() + "\" is not a test score...");
				}
			}		
		});
		
		results.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				scores.setText("<html><center>"
				+ a + " student(s) who achieved A's<br>"
				+ b + " student(s) who achieved B's<br>"
				+ c + " student(s) who achieved C's<br>"
				+ d + " student(s) who achieved D's</center></html>");
			}
		});
		
		//Reset button
		reset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				a=0;
				b=0;
				c=0;
				d=0;
				input.setText("");
				scores.setText("");
			}
		});
	}
}

public class marks 
{
	public static void main(String[] args) 
	{
		Window importclass = new Window();
		importclass.init();
		JFrame window = new JFrame();
		
		window.setTitle("Grade calculator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 300, 200);
		window.setResizable(false);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
