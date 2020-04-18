package imageshifter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public void init()
	{
		try
		{
			Button confirm = new Button("Start");
			add(confirm);
			
			confirm.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{	
					for (int i=80; i>=1; i--)
					{
						if(i>3)
						{
							File image = new File("C:\\Users\\noahd\\git\\schoolprojects\\smashpicker\\darker\\New folder\\" + String.valueOf(i) + ".png");
							image.renameTo(new File("C:\\Users\\noahd\\git\\schoolprojects\\smashpicker\\darker\\" + String.valueOf(i+6) + ".png"));
						}
					}
				}
				
			});
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
}



public class shifter 
{
	public static void main(String[] args) 
	{
		Window importclass = new Window();
		importclass.init();
		JFrame window = new JFrame();
		window.getContentPane().setForeground(Color.black);
		window.setTitle("Number File Shifter");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 300, 300);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
