package vote;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//Defining variables
	int A, B, C, D;
	
	public void init()
	{
		//Title
		JLabel title = new JLabel("Please vote for desired candidate");

		//Buttons
		JButton a = new JButton("Candidate A");
		JButton b = new JButton("Candidate B");
		JButton c = new JButton("Candidate C");
		JButton d = new JButton("Candidate D");
		JButton result = new JButton("Results");
		JButton reset = new JButton("Reset");
		//Dialogue
		JLabel output = new JLabel();
		
		result.setPreferredSize(new Dimension(82, 26));
		reset.setPreferredSize(new Dimension(78, 26));
		
		//Add elements to frame
		add(title);
		add(a);
		add(b);
		add(c);
		add(d);
		add(result);
		add(reset);
		add(output);
		
		
		a.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				A++;
			}		
		});
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				B++;
			}		
		});
		c.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				C++;
			}		
		});
		d.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				D++;
			}		
		});
		
		//Print voting result
		result.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int winner = Math.max(A, Math.max(B, Math.max(C, D)));
				
				if (winner == A)
					output.setText("The winner is candidate A with " + winner + " vote(s)!");
				
				if (winner == B)
					output.setText("The winner is candidate B with " + winner + " vote(s)!");
				
				if (winner == C)
					output.setText("The winner is candidate C with " + winner + " vote(s)!");
				
				if (winner == D)
					output.setText("The winner is candidate D with " + winner + " vote(s)!");
			}		
		});
		
		//Reset button
		reset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				A=0; 
				B=0; 
				C=0;
				D=0;
				output.setText("");
			}
		});
	}
}

public class thevote 
{
	public static void main(String[] args) 
	{
		Window importclass = new Window();
		importclass.init();
		JFrame window = new JFrame();
		
		window.setTitle("Voting");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 300, 200);
		window.setResizable(false);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}