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
		int xstri[] = {150, 250, 350};
		int xytri[] = {150, 80, 150};
		Polygon tri = new Polygon(xstri,xytri,3);
		g.setColor(red);
		g.fillPolygon(tri);
		
		// Side of roof
		int xssidetri[] = {250,350,500,400};
		int xysidetri[] = {80,150,120,50};
		Polygon sidetri = new Polygon(xssidetri, xysidetri, 4);
		g.setColor(darkred);
		g.fillPolygon(sidetri);
		
		//Making side of building
		int xsside[] = {350,350,500,500};
		int xyside[] = {150,350,320,120};
		Polygon side = new Polygon(xsside,xyside,4);
		g.setColor(darkgreen);
		g.fillPolygon(side);
		
		// House front
		g.setColor(green);
		g.fillRect(150, 150, 200, 200);
		
		// Sun
		g.setColor(Color.yellow);
		g.fillOval(70, 30, 50, 50);
		
	
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