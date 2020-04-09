package smashpicker;

//libraries
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

//graphical class
class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//character button array
	Icon character, darkcharacter;
	JToggleButton button;
	final float percentage = 0.5f;
	int brightness = (int)(256-256*percentage);
	
	public void init()
	{
		//for loop setting buttons and adding them to interface
		for (int i=72; i>=1; i--)
		{
			int num = i;
			//getting images

			
			character = new ImageIcon(String.valueOf(i)+".png");
			
			//not gonna work :_(
			//File f = new File(String.valueOf(i)+".png");
			//Image img = ImageIO.read(f);
			
			//creating button
			button = new JToggleButton();
			button.setPreferredSize(new Dimension(75,50));
			button.setMargin(new Insets(0,0,0,0));
			button.setBorder(null);
			
			//setting image to button
			button.setIcon(character);
			
			//adding to window pane
			add(button);
			
			//creating event handler for button
			button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
						{
							//if button is selected (on)
							if (button.isSelected() == true)
							{
								JOptionPane.showMessageDialog(null, "Button " + String.valueOf(num) + " is selected");
								
								darkcharacter = new ImageIcon(String.valueOf(num)+".png");
								
								//for (int a=0; a<=button.getWidth(); a++)
								//{
									//for (int b=0; b<=button.getHeight(); b++)
									//{
										
									//}
								//}
							}
							//if button is unselected (off)
							if (button.isSelected() == false)
							{
								JOptionPane.showMessageDialog(null, "Button " + String.valueOf(num) + " is is not selected");
							}
						}
				});
		}
	}
}



public class picker 
{

	public static void main(String[] args) 
	{
		Window importclass = new Window();
		importclass.init();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 300, 300);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
