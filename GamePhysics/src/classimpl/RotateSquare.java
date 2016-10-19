package classimpl;

import javax.swing.*;
import java.awt.Graphics;

public class RotateSquare  extends JFrame {
	public RotateSquare() {
		add(new DrawPanel());
	}

	public static void main(String[] args) {
		RotateSquare frame = new RotateSquare();
		frame.setTitle("RotateSquare");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}
	
	class DrawPanel extends JPanel {
		
		S2 S = new S2(50,50,200,400);
    
		// Original square
		V2 A = new V2(2,2);
		V2 B = new V2(4,2);
		V2 C = new V2(4,4);
		V2 D = new V2(2,4);
    
		// Sets center of square
		V2 R = A.add(B).add(C).add(D).div(4);
    
		// 	Angle
		double phi = Math.PI/3;
    
		// 	Pre-defined matrix from reading material
		M2 M = new M2(Math.cos(phi), -Math.sin(phi),
    		          Math.sin(phi),  Math.cos(phi));

		// Calculates new square
		V2 Am = M.mul(A.sub(R)).add(R);
		V2 Bm = M.mul(B.sub(R)).add(R);
		V2 Cm = M.mul(C.sub(R)).add(R);
		V2 Dm = M.mul(D.sub(R)).add(R);
    
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
      
    	// Paint axis
    	S.drawAxis(g);
      
    	// Paint original square
    	S.drawLine(g, A, B);
    	S.drawLine(g, B, C);
    	S.drawLine(g, C, D);
    	S.drawLine(g, D, A);
      
    	// Draw center
    	S.drawPoint(g, R);

    	// Draw new square
    	S.drawLine(g, Am, Bm);
    	S.drawLine(g, Bm, Cm);
    	S.drawLine(g, Cm, Dm);
    	S.drawLine(g, Dm, Am);
    }
  }
}
    

