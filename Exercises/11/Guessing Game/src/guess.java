import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	Integer guesses = 0;
	Integer number = 0;
	Integer getrandom = 0;
	
	public void init()
	{
		//Title
		JLabel title = new JLabel("Please guess a number between 1 and 100");
		//User input
		JTextField input = new JTextField(10);
		//Buttons
		JButton start = new JButton("Guess");
		JButton reset = new JButton("Reset");
		//Dialogue
		JLabel result = new JLabel();
		JLabel lastguess = new JLabel();
		
		//Add elements to frame
		add(title);
		add(input);
		add(start);
		add(reset);
		add(result);
		add(lastguess);
		
		//Random number gen and comparison
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					//Get text and covert it to int
					number = Integer.parseInt(input.getText());
					
					//If the game has not been started, select a new random number
					if (getrandom == 0)
					{	
						//Random class
						Random random = new Random();
						
						//Generate number
						getrandom = random.nextInt(100+1);
					}

					//Setting last guess
					lastguess.setText("Last guess: " + input.getText());
					
					//If number was guess first try
					if(number == getrandom && guesses == 0)
					{
						result.setText("Congrats! You guessed it on your first try!");
						start.setEnabled(false);
					}
					
					//If number was guess x tries
					else if(number == getrandom)
					{
						result.setText("Congrats! You took " + guesses + " guesses to get it.");
						start.setEnabled(false);
					}
					
					//If number was too high
					else if (number > getrandom)
					{
						result.setText("Incorrect! Your guess was too high!");
						guesses++;
					}
					
					//If number was too low
					else if (number < getrandom)
					{
						result.setText("Incorrect! Your guess was too low!");
						guesses++;
					}
				}
				//Catching unrelated characters
				catch(NumberFormatException error)
				{
					JOptionPane.showMessageDialog(null, "Only numbers are accepted");
				}
			}		
		});
		
		//Reset button
		reset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Reset values
				guesses = 0;
				number = 0;
				getrandom = 0;
				//Empty input field, reset button and clear output
				input.setText("");
				start.setEnabled(true);
				result.setText("");
				lastguess.setText("");
			}
		});
	}
}

public class guess 
{
	public static void main(String[] args) 
	{
		Window importclass = new Window();
		importclass.init();
		JFrame window = new JFrame();
		
		window.setTitle("Guess the Number");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 300, 130);
		window.setResizable(false);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
