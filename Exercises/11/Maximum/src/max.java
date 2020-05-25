import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//Defining variables
	Double a = 0d, b = 0d, c = 0d;
	Double[] temp = new Double[3];
	
	public void init()
	{
		//Title
		JLabel title = new JLabel("Please enter the three values");
		//User input
		JTextField fielda = new JTextField(5), fieldb = new JTextField(5), fieldc = new JTextField(5);
		//Buttons
		JButton start = new JButton("Guess"), reset = new JButton("Reset");
		//Dialogue
		JLabel result = new JLabel();
		
		//Add elements to frame
		add(title);
		add(fielda);
		add(fieldb);
		add(fieldc);
		add(start);
		add(result);
		
		//Number comparison for max
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					//Get numbers
					a = Double.parseDouble(fielda.getText());
					b = Double.parseDouble(fieldb.getText());
					c = Double.parseDouble(fieldc.getText());
					
					if (a > b)
						temp[0] = a;
					if (b > c)
						temp[1] = b;
					
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
				
			}
		});
	}
}

public class max 
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
