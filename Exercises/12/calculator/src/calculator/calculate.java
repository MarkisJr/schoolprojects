package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	Double A=0d, B=0d, product=0d;
	
	public void init()
	{
		//Title
		JLabel title = new JLabel("<html><center>Please enter values A and B<br></center></html>");
		
		JTextField a = new JTextField(10);
		JTextField b = new JTextField(10);

		//Buttons
		JButton multiply = new JButton("X");
		JButton devide = new JButton("/");
		JButton add = new JButton("+");
		JButton subtract = new JButton("-");
		JButton calculate = new JButton("Calculate");
		JButton reset = new JButton("Reset");
		
		//Dialogue
		JLabel output = new JLabel();
		
		//Add elements to frame
		add(title);
		add(a);
		add(b);
		add(multiply);
		add(devide);
		add(add);
		add(subtract);
		add(calculate);
		add(reset);
		add(output);
		
		try
		{
			a.getDocument().addDocumentListener(new DocumentListener()
			{
				public void changedUpdate(DocumentEvent e)
				{
					update();
				}

				public void insertUpdate(DocumentEvent arg0) 
				{
					update();		
				}

				public void removeUpdate(DocumentEvent arg0) 
				{
					update();
				}
				public void update()
				{
					A = Double.parseDouble(a.getText());
					System.out.println(A);
				}
			});
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					B = Double.parseDouble(b.getText());
					System.out.println(A);
				}
			});
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "You cannot have letters");
		}
		
		multiply.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				product = A*B;
				output.setText(String.valueOf(product));
			}		
		});
		devide.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				product = A/B;
				output.setText(String.valueOf(product));
			}		
		});
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				product = A+B;
				output.setText(String.valueOf(product));
			}		
		});
		subtract.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				product = A-B;
				output.setText(String.valueOf(product));
			}		
		});
		
		//Reset button
		reset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				A=0d; 
				B=0d;
				a.setText("");
				b.setText("");
				output.setText("");
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
		
		window.setTitle("Calculator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 300, 200);
		window.setResizable(false);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}