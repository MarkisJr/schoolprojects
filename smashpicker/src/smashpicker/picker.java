package smashpicker;

//libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.Random;

//graphical class
class Window extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//button state
	int[] state = new int[80];
	
	//making character buttons
	public void init()
	{	
		try 
		{
			//array generation
			JToggleButton[] button = new JToggleButton[80];
			Icon[] character = new Icon[80];
			Icon[] darker = new Icon[80];
			
			for (int i=79; i>=0; i--)
			{	
				//detecting iteration
				int num = i;
				
				//setting states TODO: make bin file load previous states
				state[i] = num;
					
				//creating button
				button[num] = new JToggleButton();
				button[num].setPreferredSize(new Dimension(75,50));
				button[num].setMargin(new Insets(0,0,0,0));
				button[num].setBorder(null);
					
				//setting icon and creating dark icon
				character[num] = new ImageIcon("characters/" + String.valueOf(num+1) + ".png");
				darker[num] = new ImageIcon("darker/" + String.valueOf(num+1) + ".png");
				button[num].setIcon(character[num]);
				
				//adding to window pane
				add(button[num]);
				
				//adding right filler and action buttons
				if (num == 0)
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
				button[num].addItemListener(new ItemListener()
				{		
					public void itemStateChanged(ItemEvent e) 
					{
						//if button is unselected (off)
						if (e.getStateChange()==ItemEvent.SELECTED)
						{
							button[num].setIcon(darker[num]);
							System.out.println("Deselected button " + String.valueOf(num+1));
							state[num] = 0;
						}
						
						//if button is selected (on)
						if (e.getStateChange()==ItemEvent.DESELECTED)
						{
							button[num].setIcon(character[num]);
							System.out.println("Selected button " + String.valueOf(num+1));
							state[num] = num;
						}
					}
				});
					
				//adding left filler	
				if (num == 8)
				{
					for (int f=2-1; f>=0; f--)
					{
						JLabel filler = new JLabel();
						filler.setIcon(new ImageIcon("characters/filler.png"));
						add(filler);
					}
				}
			}
			
			//creating function buttons
			JButton toggleon = new JButton();
			JButton start = new JButton();
			JButton toggleoff = new JButton();
			
			toggleon.setPreferredSize(new Dimension(75,50));
			toggleon.setMargin(new Insets(0,0,0,0));
			toggleon.setBorder(null);
			
			start.setPreferredSize(new Dimension(75,50));
			start.setMargin(new Insets(0,0,0,0));
			start.setBorder(null);
			
			toggleoff.setPreferredSize(new Dimension(75,50));
			toggleoff.setMargin(new Insets(0,0,0,0));
			toggleoff.setBorder(null);
			
			//setting icons
			Icon[] icon = {new ImageIcon("characters/1#.png"), new ImageIcon("characters/2#.png"), new ImageIcon("characters/3#.png")};
			toggleon.setIcon(icon[1]);
			start.setIcon(icon[2]);
			toggleoff.setIcon(icon[0]);
			
			
			//adding
			add(toggleon);
			add(start);
			add(toggleoff);
			
			//all buttons on
			toggleon.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					//for loop to cycle through all buttons
					for (int i=79; i>=0; i--)
					{
						button[i].setSelected(false);	
					}
				}		
				
			});
			
			//all buttons off
			toggleoff.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					//for loop to cycle through all buttons
					for (int i=79; i>=0; i--)
					{
						button[i].setSelected(true);
					}
				}		
				
			});
			
			//select random character
			start.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					Random random = new Random();
					int[]memory = new int[state.length];
					int pool = 0;
					int[] position = new int[80];
					
					for (int i=79; i>=0; i--)
					{
						if (state[i] != 0)
						{
							pool++;
							position[pool] = state[i];
						}
					}
					
					//storing selected characters to memory TODO: store memory of pool int
					for (int i=79; i>=0; i--)
					{
						if (state[i] != 0)
						{
							memory[i] = state[i];
						}
					}
					
					//selection
					int selection = random.nextInt(pool)+1;
					JOptionPane.showMessageDialog(null, character[position[selection]]);
					
					
					//animation
					//for (int i=79; i>=0; i--)
					//{
						
						//if (i == position[selection])
						//{
							//System.out.println("Do nothing");
						//}
						//else
						//{
							//if (button[i].isSelected() == false)
							//{
								//button[i].setSelected(true);
								
							//}
						//}
					//}
				}
			});
		}
		
		//catching any Exceptions
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
		window.setBounds(30, 30, 1000, 490);
		window.getContentPane().add(importclass);
		window.setVisible(true);
	}
}
