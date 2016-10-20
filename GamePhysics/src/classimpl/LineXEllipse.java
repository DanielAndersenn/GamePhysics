package classimpl;

import javax.swing.*;
import java.awt.Graphics;

public class LineXEllipse  extends JFrame {
	
	public LineXEllipse() {
		add(new DrawPanel());
	}

	public static void main(String[] args) {
		LineXEllipse frame = new LineXEllipse();
		frame.setTitle("LineXEllipse");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}

	class DrawPanel extends JPanel {
		S2 S = new S2(50, 50, 200, 400);
		V2 c=new V2(4,3);
		double a = 3;
		double b = 2;
		V2 p1 = new V2(2.5, 0);
		V2 p2 = new V2(10, 5);
    
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			S.drawAxis(g);
			S.drawLine(g, p1, p2);

			for (double i = 0;i < 2 * Math.PI; i = i + 0.01) {
				V2 p = c.add(new V2(a * Math.cos(i), b * Math.sin(i)));
				S.drawPoint(g, p);
			}
		}
	}
}
    

