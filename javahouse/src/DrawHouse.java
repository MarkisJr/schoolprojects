import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent {
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {
		
		// Setting custom colors
		Color green = new Color(20,100,20);
		Color darkgreen = new Color(20,70,20);
		Color red = new Color(200,0,0);
		Color darkred = new Color(100,0,0);
		
		
		// Front of roof
		g.setColor(red);
		Polygon tri = new Polygon();
		tri.addPoint(100, 100);
		tri.addPoint(150, 150);
		tri.addPoint(50, 150);
		
		g.setColor(green);
		g.fillRect(150, 150, 200, 200);
		
		g.setColor(Color.yellow);
		g.fillOval(240, 30, 50, 50);
		
		g.setColor(Color.black);
		g.fillRect(120, 55, 10, 30);
	
	}
}

public class DrawHouse {
	public static void main(String[] a) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30,30,600,500);
		window.getContentPane().add(new MyCanvas());
		window.setVisible(true);
	}
}