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
	boolean[] buttonstate = new boolean[80];
	
	JToggleButton[] button;
	
	//making character buttons
	public void init()
	{	
		//try 
		//{
			
			
			for (int i=80-1; i>=0; i--)
			{	
				//detecting iteration
				int num = i;
					
				//creating button
				button[i] = new JToggleButton();
				button[i].setPreferredSize(new Dimension(75,50));
				button[i].setMargin(new Insets(0,0,0,0));
				button[i].setBorder(null);
					
				//setting icon and creating dark icon
				Icon character = new ImageIcon("characters/" + String.valueOf(i+1) + ".png");
				Icon darker = new ImageIcon("darker/" + String.valueOf(i+1) + ".png");
				button[i].setIcon(character);
				
				//adding to window pane
				add(button[i]);
				
				//adding right filler and action buttons
				if (i == 0)
				{
					for (int f=2-1; f>=0; f--)
					{
						//filler
						JLabel filler = new JLabel();
						filler.setIcon(new ImageIcon("characters/filler.png"));
						add(filler);
					}
				}
				
				//creating event handler for button
				button[i].addItemListener(new ItemListener()
				{		
					public void itemStateChanged(ItemEvent e) 
					{
						//if button is selected (on)
						if (e.getStateChange()==ItemEvent.SELECTED)
						{
							button[num].setIcon(darker);
							System.out.println("Selected button " + String.valueOf(num+1));
							buttonstate[num] = true;
						}
						
						//if button is unselected (off)
						if (e.getStateChange()==ItemEvent.DESELECTED)
						{
							button[num].setIcon(character);
							System.out.println("Deselected button " + String.valueOf(num+1));
							buttonstate[num] = false;
						}
					}
				});
					
				//adding left filler	
				if (i == 8)
				{
					for (int f=2-1; f>=0; f--)
					{
						JLabel filler = new JLabel();
						filler.setIcon(new ImageIcon("characters/filler.png"));
						add(filler);
					}
				}
			}
			
			//creating button
			JButton toggleon, toggleoff;
			toggleon = new JButton();
			toggleoff = new JButton();
			
			toggleon.setPreferredSize(new Dimension(75,50));
			toggleon.setMargin(new Insets(0,0,0,0));
			toggleon.setBorder(null);
			
			toggleoff.setPreferredSize(new Dimension(75,50));
			toggleoff.setMargin(new Insets(0,0,0,0));
			toggleoff.setBorder(null);
			
			//setting icons
			Icon[] icon = {new ImageIcon("characters/1#.png"),new ImageIcon("characters/2#.png")};
			toggleon.setIcon(icon[1]);
			toggleoff.setIcon(icon[0]);
			
			
			//adding
			add(toggleon);
			add(toggleoff);
			
			//action listeners for on and off
			toggleon.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					//init(true);
				}		
				
			});
			
			toggleoff.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					//init(false);
				}		
				
			});
		//} 
		
		//catching
		//catch (Exception e) 
		//{
			//System.out.println(e);
		//}		
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
		window.setBounds(30, 30, 1000, 490);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}

}
