package classimpl;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.Timer;

/**
 * 
 * Slide 3 i "Lesson 10 - Air drop" er også nogen af de resultater som man ender med at have i simulationen.
 * Det kan måske derfor overvejes til eksamen at bruge simulationer til at udregne forskellige værdier,
 * og lige lave en liste over alle værdier, så vi ved hvilken værdi vi skal anvende som resultat
 * 
 * Han slides er generelt fyldt med formler - lad os huske dem til eksamen
 * 
 * Værdierne der er brugt i dette eksempel kan ses på "lesson 10 - air drop" slide 3. F.eks. svarer
 * x i r(t) til d.
 *
 */

public class AirDrop extends JFrame {
	AirDrop() {
		add(new PaintPanel());
	}

	class PaintPanel extends JPanel {
		S2 s = new S2(3, 3, 100, 500);

		// Simulating time
		double t0; 										// Timestamp of simulationstart in sec
		double t = 0; 									// Time in sec since simulation start

		// Animation
		int frameRate = 25; 							// No of frames/second
		int frameDelay = 1000 / frameRate; 				// time between frames in milli sec
		Timer myTimer = new Timer(frameDelay, new TimerListener());

		// Application	
		double g = 9.82;								// Tyngdekraft - Enhed: m/(s*s) - KONSTANT
		V2 r0 = new V2(0, 100);							// Startposition - Enhed: m
		V2 v0 = new V2(200 * 1000.0 / (60*60), 0);		// 200 km/t omdannet til m/s
		V2 a = new V2(0, -g);		  					// Konstant acceleration - Enhed: m/(s*s)
		
		ArrayList<V2> trajactory = new ArrayList<V2>();
		
		PaintPanel() {
			// Start simulation
			t0 = System.currentTimeMillis() / 1000.0;
			myTimer.start();
		}
		
		// Metode til at udregne r(t)
		V2 r(double t){
			// 0.5 * a * t * t + v0 * t + r0;
			return a.mul(0.5 * t * t).add(v0.mul(t)).add(r0);
		}
		
		// Metode til at udregne v(t)
		V2 v(double t){
			// a * t + v0;
			return a.mul(t).add(v0);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Update time
			t = System.currentTimeMillis() / 1000.0 - t0;

			// Simulation
			trajactory.add(r(t)); // Tilføjer hvert r(t) til listen
			g.drawString("t = " + t, 10, 15); // Printer tid
			g.drawString("r = " + r(t), 10, 30); // Printer position til tiden t
			g.drawString("v = " + v(t), 10, 45); // Printer hastigheden til tiden t
			s.drawPoint(g, r0, 10); // Tegner startpositionen - statisk
			s.drawPoint(g, r(t), 10); // Tegner punktet til tiden t - dynamisk
			
			// Kører listen igennem
			for (V2 p:trajactory) 
				s.drawPoint(g, p);
			
			s.drawAxis(g); // Tegner akserne

			// Stop simulation - når y rammer eller bliver mindre end y
			if (r(t).y <= 0)
				myTimer.stop();
		}

		class TimerListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		}
	} // class PaintPanel

	public static void main(String[] args) {
		AirDrop frame = new AirDrop();
		frame.setTitle("Game Physics - AirDrop");
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // main()

} // class MainFrame
