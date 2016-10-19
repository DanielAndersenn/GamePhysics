package classimpl;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.Timer;

public class RotateCube extends JFrame {
	RotateCube() {
		add(new PaintPanel());
	}

	class PaintPanel extends JPanel {
		S3 S = new S3(100, 100, 100, 500);

		// Simulating time
		double t0; 													// Timestamp of simulationstart in sec
		double t = 0; 											// Time in sec since simulation start

		// Animation
		int frameRate = 25; 								// No of frames/second
		int frameDelay = 1000 / frameRate; 	// time between frames in milli sec
		Timer myTimer = new Timer(frameDelay, new TimerListener());

		// Application
		V3[] cube=new V3[8];
		V3 c=new V3(0,0,0);
		M3 I=new M3(1,0,0,
                0,1,0,
                0,0,1);
    M3 Sz=new M3(0,-1, 0,
                 1, 0, 0,
                 0, 0, 0);
   double phi=Math.PI/100;
   M3 Rz=I.add(Sz.mul(Math.sin(phi))).add(Sz.mul(Sz).mul(1-Math.cos(phi)));


		PaintPanel() {
			cube[0]=new V3(1,4,1);
			cube[1]=new V3(1,4,3);
			cube[2]=new V3(1,6,1);
			cube[3]=new V3(1,6,3);
			cube[4]=new V3(3,4,1);
			cube[5]=new V3(3,4,3);
			cube[6]=new V3(3,6,1);
			cube[7]=new V3(3,6,3);
			for (int i=0; i<cube.length; i++){
				c=c.add(cube[i]);
			}
			c=c.mul(1.0/cube.length);
			
			
			// Start simulation
			t0 = System.currentTimeMillis() / 1000.0;
			myTimer.start();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Update time
			t = System.currentTimeMillis() / 1000.0 - t0;

			for (int i=0; i<cube.length; i++){
				cube[i]=cube[i].sub(c);
				cube[i]=Rz.mul(cube[i]);
				cube[i]=cube[i].add(c);
			}
			S.drawLine(g, cube[0], cube[1]);
			S.drawLine(g, cube[1], cube[3]);
			S.drawLine(g, cube[3], cube[2]);
			S.drawLine(g, cube[2], cube[0]);
			S.drawLine(g, cube[4], cube[5]);
			S.drawLine(g, cube[5], cube[7]);
			S.drawLine(g, cube[7], cube[6]);
			S.drawLine(g, cube[6], cube[4]);
			S.drawLine(g, cube[0], cube[4]);
			S.drawLine(g, cube[1], cube[5]);
			S.drawLine(g, cube[3], cube[7]);
			S.drawLine(g, cube[2], cube[6]);
			S.drawAxis(g);

		}

		class TimerListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		}
	} // class PaintPanel

	public static void main(String[] args) {
		RotateCube frame = new RotateCube();
		frame.setTitle("Game Physics - RotateCube");
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} // main()

} // class MainFrame
