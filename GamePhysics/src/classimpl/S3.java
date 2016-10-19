package classimpl;

import java.awt.Graphics;

public class S3 {
	
	S2 S;
	
	S3(double sx, double sy, double ox, double oy) {
		S = new S2(sx,sy, ox,oy);
	}
	
	V2 project(V3 v) {
		return new V2(v.y, v.z);
	}
	
	void drawPoint(Graphics g, V3 v) {
		S.drawPoint(g, project(v));
	}

	void drawLine(Graphics g, V3 v1, V3 v2) {
		S.drawLine(g, project(v1), project(v2));
	}

	void drawAxis(Graphics g) {
		S.drawAxis(g);
	}

}
