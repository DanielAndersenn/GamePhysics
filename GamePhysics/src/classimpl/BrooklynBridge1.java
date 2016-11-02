package classimpl;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.Timer;

public class BrooklynBridge1 extends JFrame {
	BrooklynBridge1() {
		add(new PaintPanel());
	}

	class PaintPanel extends JPanel {
		S2 s = new S2(10, 10, 100, 500);

		// Simulating time
		private double t0; 							// Timestamp of simulationstart in sec
		private double t = 0; 						// Time in sec since simulation start

		// Animation
		private int frameRate = 25; 				// No of frames/second
		private int frameDelay = 1000 / frameRate; 	// time between frames in milli sec
		Timer myTimer = new Timer(frameDelay, new TimerListener());

		// Application
		private final double g = 9.82;		// Tyngdekraft - Enhed: m/(s*s) - KONSTANT
		private double x0 = 41.15;		// Startposition - Enhed: m
		private double v0 = 0;			// Starthastighed - Enhed: m/s
		private double a = -g;		  	// Acceleration - Enhed: m/(s*s)
		
		PaintPanel() {
			// Start simulation
			t0 = System.currentTimeMillis() / 1000.0;
			myTimer.start();
		}
		
		// Metode til at udregne position til t (tiden) - x(t)
		private double x(double t) {
			return x0 + v0 * t + 0.5 * a * Math.pow(t, t);
			// Se slides for uge 9 for formel
		}
		
		// Metode til at udregne fart til t (tiden) - v(t)
		private double v(double t) {
			return v0 + a * t;
			// Se slides for uge 9 for formel
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Update time
			t = System.currentTimeMillis() / 1000.0 - t0;

			// Simulation
			g.drawString("t = " + t, 10, 15); // Printer tid
			g.drawString("x = " + x(t), 10, 30); // Printer position
			g.drawString("v = " + v(t), 10, 45); // Printer hastighed
			s.drawPoint(g, new V2(0, x0), 10); // Tegner punktet til x0 - statisk 
			s.drawPoint(g, new V2(0, x(t)), 10); // Tegner punktet til tiden x(t) - dynamisk
			s.drawAxis(g); // Tegner akserne

			// Stop simulation
			if (x(t) < 0) 
				myTimer.stop();
		}

		class TimerListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		}
	} // class PaintPanel

	public static void main(String[] args) {
		BrooklynBridge1 frame = new BrooklynBridge1();
		frame.setTitle("Game Physics - PointOnLine");
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // main()

} // class MainFrame

