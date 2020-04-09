package smashpicker;

//libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//graphical class
class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//button state
	boolean[] state = new boolean[80];
	
	public void init()
	{	
		try 
		{
			for (int i=80-1; i>=0; i--)
			{
				//detecting iteration
				int num = i;
					
				//creating button
				JToggleButton button = new JToggleButton();
				button.setPreferredSize(new Dimension(75,50));
				button.setMargin(new Insets(0,0,0,0));
				button.setBorder(null);
					
				//setting icon and creating dark icon
				Icon character = new ImageIcon("characters/" + String.valueOf(i+1) + ".png");
				Icon darker = new ImageIcon("darker/" + String.valueOf(i+1) + ".png");
				button.setIcon(character);
				
				//adding to window pane
				add(button);
				
				//creating event handler for button
				button.addItemListener(new ItemListener()
				{		
					public void itemStateChanged(ItemEvent e) 
						{
							//if button is selected (on)
							if (e.getStateChange()==ItemEvent.SELECTED)
							{
								button.setIcon(darker);
								System.out.println("Selected button " + String.valueOf(num+1));
								state[num] = true;
							}
							
							//if button is unselected (off)
							if (e.getStateChange()==ItemEvent.DESELECTED)
							{
								button.setIcon(character);
								System.out.println("Deselected button " + String.valueOf(num+1));
								state[num] = false;
							}
						}
					});
				}
			} 
		
		//catching no image
		catch (Exception e) 
		{
			System.out.println(e);
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
		
		//fix background color
		window.getContentPane().setForeground(Color.black);
		window.setTitle("Smash Picker");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 1000, 450);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
