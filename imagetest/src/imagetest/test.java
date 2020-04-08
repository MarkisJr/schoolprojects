package imagetest;

//libraries
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


//graphical class
class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//character button array
	Icon character;
	JButton button;
	
	public void init()
	{
		//for loop setting buttons and adding them to interface
		for (int i=3; i>=1; i--)
		{
			character = new ImageIcon(String.valueOf(i)+".png");
			button = new JButton();
			button.setPreferredSize(new Dimension(150,100));
			button.setMargin(new Insets(0,0,0,0));
			button.setBorder(null);
			button.setIcon(character);
			add(button);
			
		}
	}
}



public class test 
{

	public static void main(String[] args) 
	{
		Window importclass = new Window();
		importclass.init();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 600, 600);
		window.setResizable(false);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
