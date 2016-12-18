package classimpl;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.Timer;

public class BrooklynBridge2 extends JFrame {
	
	BrooklynBridge2() {
		add(new PaintPanel());
	}

	class PaintPanel extends JPanel {
		S2 s = new S2(10, 10, 100, 500);

		// Simulating time
		double t0; 							// Timestamp of simulationstart in sec
		double t = 0; 						// Time in sec since simulation start

		// Animation
		int frameRate = 25; 				// No of frames/second
		int frameDelay = 1000 / frameRate; 	// time between frames in milli sec
		Timer myTimer = new Timer(frameDelay, new TimerListener());

		// Application
		double g = 9.82;					// Tyngdekraft - Enhed: m/(s*s) - KONSTANT
		double x0 = 41.15;					// Startposition - Enhed: m
		double v0 = 0;						// Starthastighed - Enhed: m/s
		double a = -g;		  				// Acceleration - Enhed: m/(s*s)

		double p = 1.5;						// Drag (air resistance)
		double vT = g / p;					// Terminal speed (terminal velocity)
		
		/* 
		 * Drag coefficients: (Taget fra slides)
		 * Frit fald: p = 0.15
		 * "Overcoat": p = 0.5
		 * Faldskærm: p = 1.5
		 * */
		
		
		PaintPanel() {
			// Start simulation
			t0 = System.currentTimeMillis() / 1000.0;
			myTimer.start();
		}
		
		// Metode der må beregne positionen til tiden t - kan ses på sidste slide (uge 11)
		double x(double t){
			// return 0.5 * a * t * t + v0 * t +x0;
			return ((v0 + vT) / p) * (1 - Math.exp(-p * t)) - vT * t + x0;
		}
		
		// Metode der må beregne hastighed til tiden t - kan ses på slide 16 (uge 11)
		double v(double t){
			// return a * t + v0;
			return (v0 + vT) * Math.exp(-p * t) - vT;
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Update time
			t = System.currentTimeMillis() / 1000.0 - t0;

			// Simulation
			g.drawString("t = " + t, 10, 15);
			g.drawString("x = " + x(t), 10, 30);
			g.drawString("v = " + v(t), 10, 45);
			g.drawString("vT = " + vT, 10, 60);
			s.drawPoint(g, new V2(0,x0), 10);
			s.drawPoint(g, new V2(0,x(t)), 10);
			s.drawAxis(g);

			// Stop simulation
			if (x(t)<0) myTimer.stop();
		}

		class TimerListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		}
	} // class PaintPanel

	public static void main(String[] args) {
		BrooklynBridge2 frame = new BrooklynBridge2();
		frame.setTitle("Game Physics - PointOnLine");
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // main()

} // class MainFrame