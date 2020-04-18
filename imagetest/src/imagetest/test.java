package imagetest;

//libraries
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


//graphical class
class Window extends JPanel
{
	final float percentage = 0.5f;
	int brightness = (int)(256-256*percentage);
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g)
	{
		g.setColor(new Color(255,0,0));
		g.drawRect(0,0,20,20);
		g.setColor(new Color(0,0,0,brightness));
		g.drawRect(0,0,20,20);
	}
}



public class test 
{

	public static void main(String[] args) 
	{
		Window importclass = new Window();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 600, 600);
		window.setResizable(false);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
