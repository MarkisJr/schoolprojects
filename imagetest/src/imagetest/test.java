package imagetest;

import java.awt.*;
import javax.swing.*;

class Window extends JPanel
{
	JLabel triangle;
	
	public void init()
	{
		triangle = new JLabel();
		triangle.setIcon(new ImageIcon("triangle.png"));
		add(triangle);
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
		window.setBounds(30,30,400,400);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
