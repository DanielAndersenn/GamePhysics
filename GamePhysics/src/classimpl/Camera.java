package classimpl;

import java.awt.Color;
import java.awt.Graphics;

public class Camera {
	//Virtuelle verdens enhedsvektorer og origo
	V3 O = new V3(0,0,0);
	V3 i = new V3(1,0,0);
	V3 j = new V3(0,1,0);
	V3 k = new V3(0,0,1);
	
	//Camera enhedsvektorer og origo
	V3 E = new V3(0,0,0);
	V3 D = new V3(1,0,0);
	V3 U = new V3(0,1,0);
	V3 R = new V3(0,0,1);
	
	//Zoom
	double z = 4;
	
	S2 S;
	
	// Constructor
	Camera(double sx, double sy, double ox, double oy){
		S = new S2(sx, sy, ox, oy);
	}
	
	Camera(){
		
	}
	
	// Flyt kameraet
	void moveTo(V3 p){
		E = new V3(p.x, p.y, p.z);
	}
	
	//Slide 7 i slides om kameraet
	void focus(V3 p){
		D = p.sub(E).unit();
		R = D.cross(k).unit();
		U = R.cross(D);
	}
	
	// Slide 4 i slides om kameraet
	V2 project(V3 P){
		V3 EP = P.sub(E);
		double d = D.dot(EP);
		double u = U.dot(EP);
		double r = R.dot(EP);
		double rm = (r/d) * z;
		double um = (u/d) * z;
		return new V2(rm, um);
	}
	
	void drawPoint(Graphics g, V3 v){
		S.drawPoint(g, project(v));
	}

	void drawLine(Graphics g, V3 v1, V3 v2){
		S.drawLine(g, project(v1), project(v2));
	}

	void drawLine(Graphics g,V3 v1,V3 v2, Color c){
		Color oldColor = g.getColor();
		g.setColor(c);
		drawLine(g, v1, v2);
		g.setColor(oldColor);
	}

	void drawAxis(Graphics g){
		drawLine(g, O, i, Color.BLUE);
		drawLine(g, O, j, Color.RED);
		drawLine(g, O, k, Color.GREEN);
	}

}
