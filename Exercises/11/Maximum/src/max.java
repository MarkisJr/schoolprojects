import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//Defining variables
	Double a = 0d, b = 0d, c = 0d;
	String highest = "";
	
	public void init()
	{
		//Labels
		JLabel 
			title = new JLabel("<html><center>Please enter the three values</center></html>"),
			labela = new JLabel("A: "),
			labelb = new JLabel("B: "),
			labelc = new JLabel("C: ")
		;
		//User input
		JTextField fielda = new JTextField(3), fieldb = new JTextField(3), fieldc = new JTextField(3);
		//Buttons
		JButton start = new JButton("Guess"), reset = new JButton("Reset");
		start.setPreferredSize(new Dimension(100, 26));
		reset.setPreferredSize(new Dimension(100, 26));
		//Dialogue
		JLabel result = new JLabel();
		
		//Add elements to frame
		add(title);
		add(labela);
		add(fielda);
		add(labelb);
		add(fieldb);
		add(labelc);
		add(fieldc);
		add(start);
		add(reset);
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
					
					//Checking if all values are the same
					if ((a.equals(b)) && (a.equals(c)))
					{
						JOptionPane.showMessageDialog(null, "All three values are of the same value");
						return;
					}
					
					//Checking what value is the max
					if (Math.max(a, Math.max(b, c)) == a)
						highest = "A";
					else if (Math.max(a, Math.max(b, c)) == b)
						highest = "B";
					else
						highest = "C";
					
					//Print the max value
					result.setText("The highest number is value " + highest + " at " + String.valueOf(Math.max(a, Math.max(b, c))));					
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
				fielda.setText("");
				fieldb.setText("");
				fieldc.setText("");
				result.setText("");
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
		
		window.setTitle("Maximum Number");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 400, 140);
		window.setResizable(false);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
