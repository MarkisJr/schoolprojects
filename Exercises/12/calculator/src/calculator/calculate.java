package calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	Double A=0d, B=0d, product=0d;
	
	public void init()
	{
		//Title
		JLabel title = new JLabel("    Please enter values A and B    ");
		
		JTextField a = new JTextField(12);
		JTextField b = new JTextField(12);

		//Buttons
		JButton multiply = new JButton("X");
		JButton devide = new JButton("/");
		JButton add = new JButton("+");
		JButton subtract = new JButton("-");
		JButton calculate = new JButton("Calculate");
		JButton reset = new JButton("Reset");
		
		multiply.setPreferredSize(new Dimension(50, 26));
		devide.setPreferredSize(new Dimension(50, 26));
		add.setPreferredSize(new Dimension(50, 26));
		subtract.setPreferredSize(new Dimension(50, 26));
		
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
		

		a.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent e)
				{
					char c = e.getKeyChar();
					if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE))
						e.consume();
				}
			});
			
		b.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE))
					e.consume();
			}
		});
		
		
		{
			
		}
		
		multiply.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				A = Double.parseDouble(a.getText());
				B = Double.parseDouble(b.getText());
				product = A*B;
				output.setText(String.valueOf(product));
			}		
		});
		devide.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				A = Double.parseDouble(a.getText());
				B = Double.parseDouble(b.getText());
				product = A/B;
				output.setText(String.valueOf(product));
			}		
		});
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				A = Double.parseDouble(a.getText());
				B = Double.parseDouble(b.getText());
				product = A+B;
				output.setText(String.valueOf(product));
			}		
		});
		subtract.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				A = Double.parseDouble(a.getText());
				B = Double.parseDouble(b.getText());
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